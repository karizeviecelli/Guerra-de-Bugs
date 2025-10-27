# Requisições da API - Sistema de Tarefas

## Configuração Base
- **URL Base**: `http://localhost:8080`
- **Content-Type**: `application/json`

---

## APIs de Usuário

### 1. Consultar Usuários (GET)
```http
GET http://localhost:8080/user
```

### 2. Inserir Usuário (POST)
```http
POST http://localhost:8080/user
Content-Type: application/json

{
    "nome": "João Silva",
    "email": "joao@email.com"
}
```

### 3. Atualizar Usuário (PUT)
```http
PUT http://localhost:8080/user/joao@email.com
Content-Type: application/json

{
    "nome": "João Silva Santos",
    "email": "joao@email.com"
}
```

### 4. Excluir Usuário (DELETE)
```http
DELETE http://localhost:8080/user/joao@email.com
```

---

## APIs de Tarefa

### 1. Consultar Tarefas (GET)
```http
GET http://localhost:8080/task
```

### 2. Inserir Tarefa (POST)
```http
POST http://localhost:8080/task
Content-Type: application/json

{
    "titulo": "Backup do servidor",
    "descricao": "Realizar backup completo do servidor principal",
    "dataAgendamento": "2025-01-15",
    "status": 1,
    "emailUsuario": "joao@email.com"
}
```

### 3. Atualizar Tarefa (PUT)
```http
PUT http://localhost:8080/task/1
Content-Type: application/json

{
    "titulo": "Backup do servidor - Atualizado",
    "descricao": "Realizar backup completo do servidor principal com criptografia",
    "dataAgendamento": "2025-01-15",
    "status": 2,
    "emailUsuario": "joao@email.com"
}
```

### 4. Excluir Tarefa (DELETE)
```http
DELETE http://localhost:8080/task/1
```

---

## Códigos de Status das Tarefas
- **1**: Em aberto
- **2**: Em andamento  
- **3**: Concluído
- **4**: Cancelado

---

## Exemplos de Respostas

### Sucesso (200)
```json
{
    "nome": "João Silva",
    "email": "joao@email.com"
}
```

### Erro - Usuário não encontrado (404)
```json
"Usuário não encontrado."
```

### Erro - Usuário já existe (409)
```json
"Já existe usuário."
```

### Erro - Usuário vinculado em tarefas (409)
```json
"Usuário vinculado em tarefas."
```

### Erro - Data já agendada (409)
```json
"Usuário já possui agenda para a data informada."
```

---

## Sequência de Teste Recomendada

1. **Inserir usuários** usando POST /user
2. **Consultar usuários** usando GET /user
3. **Inserir tarefas** usando POST /task
4. **Consultar tarefas** usando GET /task
5. **Atualizar tarefas** usando PUT /task/{id}
6. **Atualizar usuários** usando PUT /user/{email}
7. **Excluir tarefas** usando DELETE /task/{id}
8. **Excluir usuários** usando DELETE /user/{email}

---

## Validações Implementadas

### Usuário
- Nome não pode estar em branco
- Email não pode estar em branco e deve ter formato válido
- Email deve ser único

### Tarefa
- Título não pode ser vazio
- Descrição não pode ser vazia
- Data de agendamento não pode ser vazia
- Status deve ser 1, 2, 3 ou 4
- Email do usuário não pode ser vazio e deve ter formato válido
- Usuário deve existir no sistema
- Não pode haver mais de uma tarefa por usuário na mesma data
