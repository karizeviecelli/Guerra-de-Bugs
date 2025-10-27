package com.senai.CRUD.dtos;

import com.senai.CRUD.models.EstadoModel;

public class RespostaEstadoDto {

    private long id;
    private String nome;
    private String sigla;

    public RespostaEstadoDto() {
    }

    public RespostaEstadoDto(long id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }
    public RespostaEstadoDto(EstadoModel model) {
        this.id = model.getId();
        this.nome = model.getNome();
        this.sigla = model.getSigla();
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
