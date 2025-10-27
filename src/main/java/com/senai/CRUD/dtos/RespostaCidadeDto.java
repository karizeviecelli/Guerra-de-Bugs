package com.senai.CRUD.dtos;

import com.senai.CRUD.models.CidadeModel;

public class RespostaCidadeDto {
    private Long id;
    private String nome;
    private String estado;


    public RespostaCidadeDto() {
    }

    public RespostaCidadeDto(Long id, String nome, String estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;

    }
    public RespostaCidadeDto(CidadeModel model) {
        this.id = model.getId();
        this.nome = model.getNome();
        this.estado = model.getEstado().getNome();

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String cidade) {
        this.estado = cidade;
    }
}
