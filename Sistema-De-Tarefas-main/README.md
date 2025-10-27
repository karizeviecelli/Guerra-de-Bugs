# 🚀 Sistema de Tarefas - Spring Boot

<div align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen.svg" alt="Spring Boot Version">
  <img src="https://img.shields.io/badge/Java-21-orange.svg" alt="Java Version">
  <img src="https://img.shields.io/badge/MySQL-8.0+-blue.svg" alt="MySQL Version">
  <img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="License">
</div>

---

## 📋 Sobre o Projeto

Um sistema completo de gerenciamento de tarefas desenvolvido com **Spring Boot** para empresas de TI gerenciarem demandas de atendimento do setor de suporte. O sistema permite controlar tarefas que precisam ser realizadas pela equipe de suporte.

### ✨ Principais Características

- 🎯 **API REST Completa** para gerenciamento de usuários e tarefas
- 🔐 **Validações Robustas** com Bean Validation
- 🗄️ **Integração com MySQL** para persistência de dados
- 📅 **Controle de Agendamento** com validação de conflitos
- 🚦 **Sistema de Status** para acompanhamento de tarefas
- 🔗 **Relacionamentos JPA** otimizados

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão | Descrição |
|------------|--------|-----------|
| **Java** | 21 | Linguagem de programação |
| **Spring Boot** | 3.5.6 | Framework principal |
| **Spring Data JPA** | - | Persistência de dados |
| **Spring Validation** | - | Validação de dados |
| **MySQL** | 8.0+ | Banco de dados |
| **Maven** | - | Gerenciador de dependências |

---

## 📊 Arquitetura do Sistema

```
📁 Sistema de Tarefas
├── 🎮 Controllers (API REST)
│   ├── UserController
│   └── TaskController
├── 🏗️ Services (Lógica de Negócio)
│   ├── UserService
│   └── TaskService
├── 🗄️ Repositories (Acesso a Dados)
│   ├── UserRepository
│   └── TaskRepository
├── 📋 Models (Entidades)
│   ├── UserModel
│   ├── TaskModel
│   └── TaskStatus (Enum)
└── 📦 DTOs (Transferência de Dados)
    ├── UserDto
    └── TaskDto
```

---

## 🚀 Como Executar

### 📋 Pré-requisitos

- ☕ **Java 21** ou superior
- 🐬 **MySQL 8.0+** instalado e rodando
- 🔧 **Maven 3.6+**

### ⚙️ Configuração

1. **Clone o repositório**
```bash
git clone https://github.com/seu-usuario/task-springboot.git
cd task-springboot
```

2. **Configure o banco de dados**
```sql
-- Execute o script SQL no MySQL
mysql -u root -p < database_script.sql
```

3. **Configure as credenciais do banco**
```properties
# src/main/resources/application.properties
spring.datasource.username=root
spring.datasource.password=sua_senha
```

4. **Execute a aplicação**
```bash
mvn spring-boot:run
```

### 🌐 Acessar a API

- **URL Base**: `http://localhost:8080`
- **Documentação**: Use o arquivo `requisicoes_api.md` para exemplos

---

## 📚 Endpoints da API

### 👥 **Usuários**

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/user` | Listar todos os usuários |
| `POST` | `/user` | Criar novo usuário |
| `PUT` | `/user/{email}` | Atualizar usuário |
| `DELETE` | `/user/{email}` | Excluir usuário |

### 📝 **Tarefas**

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/task` | Listar todas as tarefas |
| `POST` | `/task` | Criar nova tarefa |
| `PUT` | `/task/{id}` | Atualizar tarefa |
| `DELETE` | `/task/{id}` | Excluir tarefa |

---

## 💡 Exemplos de Uso

### 🆕 Criar Usuário
```bash
curl -X POST http://localhost:8080/user \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "email": "joao@email.com"
  }'
```

### 📋 Criar Tarefa
```bash
curl -X POST http://localhost:8080/task \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Backup do servidor",
    "descricao": "Realizar backup completo do servidor principal",
    "dataAgendamento": "2025-01-15",
    "status": 1,
    "emailUsuario": "joao@email.com"
  }'
```

### 📊 Status das Tarefas
| Código | Status |
|--------|--------|
| `1` | 🟡 Em aberto |
| `2` | 🔵 Em andamento |
| `3` | 🟢 Concluído |
| `4` | 🔴 Cancelado |

---

## ✅ Validações Implementadas

### 👤 **Usuário**
- ✅ Nome obrigatório
- ✅ Email obrigatório e formato válido
- ✅ Email único no sistema

### 📝 **Tarefa**
- ✅ Título obrigatório
- ✅ Descrição obrigatória
- ✅ Data de agendamento obrigatória
- ✅ Status válido (1-4)
- ✅ Usuário deve existir
- ✅ **Um usuário não pode ter duas tarefas na mesma data**

---

## 📈 Códigos de Resposta HTTP

| Código | Descrição | Exemplo |
|--------|-----------|---------|
| `200` | ✅ Sucesso | Operação realizada com sucesso |
| `400` | ❌ Erro de validação | Dados inválidos |
| `404` | 🔍 Não encontrado | Recurso não existe |
| `409` | ⚠️ Conflito | Email já existe / Data já agendada |

---

## 🗄️ Estrutura do Banco de Dados

```sql
-- Tabela de usuários
CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- Tabela de tarefas
CREATE TABLE tarefa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    data_agendamento DATE NOT NULL,
    status INT NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
```

---

## 🧪 Testando a API

### 📋 **Coleção de Testes**

Use os exemplos do arquivo `requisicoes_api.md` ou importe no seu cliente HTTP preferido:

- 🚀 **Postman**
- ⚡ **Thunder Client** (VSCode)
- 🔥 **Insomnia**

### 🎯 **Sequência de Testes Recomendada**

1. **Inserir usuários** → `POST /user`
2. **Listar usuários** → `GET /user`
3. **Inserir tarefas** → `POST /task`
4. **Listar tarefas** → `GET /task`
5. **Atualizar tarefas** → `PUT /task/{id}`
6. **Testar validações** → Tentar inserir tarefa duplicada
7. **Excluir recursos** → `DELETE /task/{id}` e `DELETE /user/{email}`

---

## 📁 Estrutura do Projeto

```
task-springboot/
├── 📁 src/main/java/com/senai/task_springboot/
│   ├── 📁 controllers/          # Controladores REST
│   ├── 📁 services/            # Lógica de negócio
│   ├── 📁 repositories/        # Acesso a dados
│   ├── 📁 models/              # Entidades JPA
│   ├── 📁 dtos/                # Objetos de transferência
│   └── 📄 SistemaDeTarefasApplication.java
├── 📁 src/main/resources/
│   └── 📄 application.properties
├── 📄 pom.xml                  # Dependências Maven
├── 📄 database_script.sql      # Script do banco
├── 📄 requisicoes_api.md       # Exemplos de requisições
└── 📄 README.md               # Este arquivo
```

---

## 🤝 Contribuindo

1. **Fork** o projeto
2. **Crie** uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. **Commit** suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. **Push** para a branch (`git push origin feature/AmazingFeature`)
5. **Abra** um Pull Request

---

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 👨‍💻 Autor

**Seu Nome**
- 📧 Email: gcaio98406@gmail.com
- 💼 LinkedIn: https://www.linkedin.com/in/caio-mata-8bb741219/
- 🐙 GitHub:https://github.com/eucaiogomes

---

## 🙏 Agradecimentos

- 🎓 **SENAI** - Serviço Nacional de Aprendizagem Industrial
- ☕ **Spring Boot** - Framework incrível
- 🗄️ **MySQL** - Banco de dados confiável
- 👥 **Comunidade Java** - Por toda a documentação e suporte

---

<div align="center">
  <p>Feito com ❤️ e ☕ por estudantes do SENAI</p>
  <p>⭐ Se este projeto te ajudou, deixe uma estrela!</p>
</div>
