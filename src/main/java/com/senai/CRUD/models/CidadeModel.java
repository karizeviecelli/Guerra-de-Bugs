package com.senai.CRUD.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cidade")
public class CidadeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false,unique = true)
    private String nome;
    @ManyToOne
    @JoinColumn(name = "estado", nullable = false)
    private EstadoModel estado;

    public CidadeModel() {
    }

    public CidadeModel(Long id, String nome, EstadoModel estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoModel getEstado() {
        return estado;
    }

    public void setEstado(EstadoModel estado) {
        this.estado = estado;
    }
}
