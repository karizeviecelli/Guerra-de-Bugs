package com.senai.CRUD.models;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome",nullable = false,length = 45,unique = true)
    private String nome;

    public CategoriaModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaModel() {
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
}
