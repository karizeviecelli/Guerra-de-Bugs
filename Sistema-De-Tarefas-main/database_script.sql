-- Script SQL para o Sistema de Tarefas
-- Execute este script no MySQL para criar o banco e inserir dados de teste

CREATE DATABASE IF NOT EXISTS taskdb;
USE taskdb;

-- Tabela de usuários
CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    INDEX idx_email (email)
);

-- Tabela de tarefas
CREATE TABLE IF NOT EXISTS tarefa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    data_agendamento DATE NOT NULL,
    status INT NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE RESTRICT,
    INDEX idx_usuario_data (usuario_id, data_agendamento)
);

-- Inserir usuários de teste
INSERT INTO usuario (nome, email) VALUES
('João Silva', 'joao@email.com'),
('Maria Souza', 'maria@email.com'),
('Carlos Lima', 'carlos@email.com'),
('Ana Paula', 'ana@email.com'),
('Pedro Santos', 'pedro@email.com');

-- Inserir tarefas de teste
INSERT INTO tarefa (titulo, descricao, data_agendamento, status, usuario_id) VALUES
('Backup', 'Realizar backup do servidor', '2025-01-15', 1, 1),
('Atualização', 'Atualizar sistema operacional', '2025-01-16', 2, 2),
('Suporte', 'Atender chamado técnico', '2025-01-17', 1, 3),
('Reunião', 'Reunião com cliente', '2025-01-18', 3, 4),
('Configuração', 'Configurar nova impressora', '2025-01-19', 1, 5),
('Manutenção', 'Manutenção preventiva da rede', '2025-01-20', 4, 1),
('Treinamento', 'Treinamento da equipe', '2025-01-21', 2, 2);

-- Verificar dados inseridos
SELECT 'Usuários cadastrados:' as info;
SELECT * FROM usuario;

SELECT 'Tarefas cadastradas:' as info;
SELECT t.id, t.titulo, t.descricao, t.data_agendamento, t.status, u.nome as usuario_nome, u.email as usuario_email 
FROM tarefa t 
JOIN usuario u ON t.usuario_id = u.id;
