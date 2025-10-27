package com.senai.task_springboot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "tarefa")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Título não pode ser vazio")
    @Column(nullable = false, length = 100)
    private String titulo;

    @NotBlank(message = "Descrição não pode ser vazia")
    @Column(nullable = false, length = 255)
    private String descricao;

    @NotNull(message = "Data de agendamento não pode ser vazia")
    @Column(name = "data_agendamento", nullable = false)
    private LocalDate dataAgendamento;

    @NotNull(message = "Status não pode ser vazio")
    @Column(nullable = false)
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UserModel usuario;

    // Construtores
    public TaskModel() {}

    public TaskModel(String titulo, String descricao, LocalDate dataAgendamento, Integer status, UserModel usuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataAgendamento = dataAgendamento;
        this.status = status;
        this.usuario = usuario;
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

    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }
}