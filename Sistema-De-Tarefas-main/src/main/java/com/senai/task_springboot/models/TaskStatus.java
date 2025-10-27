package com.senai.task_springboot.models;

public enum TaskStatus {
    EM_ABERTO(1, "Em aberto"),
    EM_ANDAMENTO(2, "Em andamento"),
    CONCLUIDO(3, "Concluído"),
    CANCELADO(4, "Cancelado");

    private final int codigo;
    private final String descricao;

    TaskStatus(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TaskStatus fromCodigo(int codigo) {
        for (TaskStatus status : values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código de status inválido: " + codigo);
    }

    public static TaskStatus fromString(String status) {
        for (TaskStatus s : values()) {
            if (s.name().equalsIgnoreCase(status) || s.getDescricao().equalsIgnoreCase(status)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + status);
    }
}
