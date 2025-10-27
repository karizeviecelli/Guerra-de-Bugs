package com.senai.CRUD.dtos;

import com.senai.CRUD.models.CategoriaModel;

public class CategoriaReponseDto {
    private String nome;
    private Long id;

    public CategoriaReponseDto() {
    }

    public CategoriaReponseDto(CategoriaModel dados) {
        this.nome = dados.getNome();
        this.id = dados.getId();
    }

    public CategoriaReponseDto(String nome, Long id) {
        this.nome = nome;
        this.id = id;
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

    @Override
    public String toString() {
        return "CategoriaReponseDto{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}
