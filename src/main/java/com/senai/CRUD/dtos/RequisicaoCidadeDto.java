package com.senai.CRUD.dtos;

import com.senai.CRUD.models.CidadeModel;

public class RequisicaoCidadeDto {
    private String nome;
    private String estado;

    public RequisicaoCidadeDto() {
    }

    public RequisicaoCidadeDto(String nome, String estado) {
        this.nome = nome;
        this.estado = estado;
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

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
