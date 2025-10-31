package com.senai.CRUD.dtos;

import com.senai.CRUD.models.ContatoModel;

import java.time.LocalDate;

public class RespostaContatoDto {
    private Long id;
    private String nome;
    private String email;
    private long telefone;
    private String cidade;
    private LocalDate dataCadastro;

    public RespostaContatoDto() {
    }

    public RespostaContatoDto(Long id, String nome, String email, String cidade, long telefone,LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
    }

    public RespostaContatoDto(ContatoModel model) {
        this.id = model.getId();
        this.nome = model.getNome();
        this.email = model.getEmail();
        this.cidade = model.getCidade().getNome();
        this.telefone = model.getTelefone();
        this.dataCadastro = model.getDataCadastro();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
