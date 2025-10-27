# Relatório: Fluxos de Login e Cadastro

Versão: 1.0

Objetivo: documentar como executar os fluxos de cadastro e login, registrar casos de teste, apontar 3 defeitos (com evidências simuladas) e propor correções.

## 1) Como executar (cenário rápido)

- Pré-requisitos:
  - Java (11+), Maven instalado
  - Banco de dados: MySQL (recomendado) ou H2 para testes rápidos

- Opção A — Usando MySQL (configuração atual):
  1. Inicie o servidor MySQL local (porta 3306).
  2. Verifique credenciais em `src/main/resources/application.properties` (por padrão `root`/`root`).
  3. Execute a aplicação:

```powershell
cd 'c:\Users\caio_t_gomes\Sistema-De-Tarefas-main'
.\mvnw.cmd spring-boot:run
```

  4. Abra no navegador: `http://localhost:8080/index.html`

- Opção B — Usando H2 (sem instalar MySQL):
  1. Rode a aplicação passando a URL do H2 em memória:

```powershell
cd 'c:\Users\caio_t_gomes\Sistema-De-Tarefas-main'
.\mvnw.cmd spring-boot:run -Dspring-boot.run.arguments="--spring.datasource.url=jdbc:h2:mem:taskdb;DB_CLOSE_DELAY=-1 --spring.datasource.username=sa --spring.datasource.password="
```

  2. Abra `http://localhost:8080/index.html`

Observações:
- O projeto usa `spring.jpa.hibernate.ddl-auto=update`, portanto as tabelas serão criadas automaticamente quando a aplicação conectar.
- As páginas estáticas ficam em `src/main/resources/static` (`users.html`, `tasks.html`, etc.).

## 2) Fluxos - passo a passo

- Cadastro de usuário (via UI `users.html`):
  1. Preencha `Nome`, `Email`, `Senha` e clique em `Salvar`.
  2. O frontend envia POST `/user` com JSON { nome, email, password }.
  3. Backend valida existência (email único). Se OK, senha é hasheada com BCrypt e usuário persistido.

- Login (via UI `users.html`, seção Login):
  1. Preencha `Email` e `Senha` e clique `Entrar`.
  2. Frontend envia POST `/user/login` com JSON { email, password }.
  3. Backend procura o usuário por email e compara a senha fornecida com o hash usando BCrypt.
  4. Retorna 200 com mensagem de sucesso ou 401 em falha.

## 3) Casos de teste (registrar resultados manualmente)

Formato de cada caso: ID | Objetivo | Passos | Entrada | Resultado esperado | Resultado obtido | Status

CT-01 | Cadastro válido
- Passos: abrir `users.html` → preencher nome/email/senha válidos → Salvar
- Entrada: { nome: "Ana", email: "ana@example.com", password: "Senha123!" }
- Esperado: 200 OK, mensagem "Usuário inserido com sucesso.", usuário listado em /user

CT-02 | Cadastro com email duplicado
- Passos: cadastrar dois usuários com mesmo email
- Entrada: segundo registro com mesmo email
- Esperado: 409 Conflict, mensagem "Já existe usuário."

CT-03 | Login válido
- Passos: após CT-01, preencher login com email/senha corretos
- Entrada: { email: "ana@example.com", password: "Senha123!" }
- Esperado: 200 OK, mensagem "Login efetuado com sucesso." e indicador no DOM "Login OK"

CT-04 | Login inválido (senha incorreta)
- Entrada: senha errada
- Esperado: 401 Unauthorized, mensagem "Credenciais inválidas."

CT-05 | Tentativa de criar usuário sem senha
- Entrada: { nome: "Beto", email: "beto@example.com", password: "" }
- Esperado: 400 BAD REQUEST por validação (`@NotBlank` da DTO)

CT-06 | Fluxo tarefas - criar tarefa com usuário inexistente
- Entrada: tarefa com emailUsuario que não existe
- Esperado: 404 Usuário da tarefa não encontrado (retorno do service)

Execute cada caso e registre as evidências: prints da tela, logs do console do Spring Boot, e resposta HTTP (cURL/DevTools network).

## 4) Três defeitos (evidências simuladas) e proposta de correção

Defeito #1 — Mensagem confusa ao cadastrar usuário duplicado
- Observação/evidência: Ao tentar cadastrar usuário com email já existente, o frontend mostra apenas um alerta com o texto bruto retornado pelo backend ("Já existe usuário."). No console do navegador vemos status 409.
- Impacto: UX pobre; difícil para usuário entender campo em conflito.
- Proposta de correção: Normalizar respostas de erro do backend para JSON com chave `error` e `field` (ex.: { "error": "EMAIL_DUPLICATE", "field": "email", "message": "Email já cadastrado" }). Ajustar frontend para exibir mensagens por campo.

Defeito #2 — Inserção de usuário sem senha aceita pelo backend (inconsistência)
- Evidência simulada: Formulário de cadastro deixa enviar campo de senha em branco em alguns navegadores (e.g., ao desabilitar JS), e o backend cria usuário com password = null (ou vazio), o que quebra o fluxo de login. No log do Spring aparece usuário criado com password null.
- Impacto: usuário sem senha não consegue logar; potencial vetor de segurança.
- Proposta de correção: Garantir validação no backend: tornar o campo `password` obrigatorio via anotação `@NotBlank` no DTO (já foi adicionada), e validar no controller antes de persistir. Além disso, quando ler senhas, nunca permitir valores nulos ao salvar; rejeitar a requisição com 400.

Defeito #3 — Mensagem de status de tarefa não intuitiva na UI
- Evidência: A listagem de tarefas mostra `status: 1` em vez de texto legível ("Em aberto"). Usuário confuso; print mostra coluna status com números.
- Impacto: baixa usabilidade.
- Proposta de correção: No DTO ou no frontend mapear status numérico para texto (1->"Em aberto", 2->"Em andamento", 3->"Concluído", 4->"Cancelado"). Preferível criar um método utilitário `TaskStatus.toLabel(status)` e usar no `convertToDto` ou no JS antes de renderizar.

## 5) Correções propostas (resumo técnico)

- Backend
  - Normalizar erros: criar uma classe `ApiError { String code; String field; String message; }` e sempre retornar JSON em erros esperados.
  - Validar `password` no controller com `@Valid` e checar `userDto.getPassword()` não nulo; retornar 400 com `ApiError` quando inválido.
  - Atualizar `convertToDto` e/ou `TaskDto` para enviar `statusLabel` ou mapear no frontend.

- Frontend
  - Atualizar `app.js` para tratar respostas de erro JSON e mostrar mensagens por campo.
  - Mapear status numérico para rótulos legíveis antes de renderizar a lista de tarefas.

## 6) Evidências (exemplos simulados)

- Log (simulação):
```
2025-10-21 19:12:04.123 INFO  - POST /user 200 - Usuário inserido com sucesso.
2025-10-21 19:15:09.456 WARN  - POST /user 409 - Já existe usuário.
2025-10-21 19:17:20.789 INFO  - POST /user/login 401 - Credenciais inválidas.
```

- Captura de tela (simulada): front-end mostra "Login OK" ou "Credenciais inválidas." abaixo do formulário.

## 7) Observações finais
- Caso queira, posso:
  - Implementar as correções propostas (normalizar erros, validação forte, mapear status) e criar PR com as mudanças.
  - Gerar scripts curl para executar os casos de teste automaticamente.

Fim do relatório.
