package com.senai.CRUD.dtos;

public class CategoriaRequestDto {
    private String nome;

    public CategoriaRequestDto() {
    }

    public CategoriaRequestDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "CategoriaDto{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
