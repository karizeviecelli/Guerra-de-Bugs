package com.senai.task_springboot.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class TaskDto {
    
    private Long id;

    @NotBlank(message = "Título não pode ser vazio")
    private String titulo;

    @NotBlank(message = "Descrição não pode ser vazia")
    private String descricao;

    @NotNull(message = "Data de agendamento não pode ser vazia")
    private LocalDate dataAgendamento;

    @NotNull(message = "Status não pode ser vazio")
    private Integer status; // 1 – em aberto, 2 – em andamento, 3 – concluído e 4 cancelado

    @NotBlank(message = "Email do usuário não pode ser vazio")
    @Email(message = "Email deve ser válido")
    private String emailUsuario;

    // Construtores
    public TaskDto() {
    }

    public TaskDto(Long id, String titulo, String descricao, LocalDate dataAgendamento, Integer status, String emailUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataAgendamento = dataAgendamento;
        this.status = status;
        this.emailUsuario = emailUsuario;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
}