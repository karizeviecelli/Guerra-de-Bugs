package com.senai.CRUD.models;

import jakarta.persistence.*;

@Entity
@Table(name = "estado")
public class EstadoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "estado",nullable = false,unique = true,length = 255)
    private String nome;
    @Column(name = "sigla",nullable = false,unique = true,length = 2)
    private String sigla;

    public EstadoModel() {
    }

    public EstadoModel(long id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
