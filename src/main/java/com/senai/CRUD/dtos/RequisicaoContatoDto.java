package com.senai.CRUD.dtos;

public class RequisicaoContatoDto {
    private String nome;
    private String email;
    private long telefone;
    private String cidade;

    public RequisicaoContatoDto(String nome, String email, long telefone, String cidade) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cidade = cidade;
    }

    public RequisicaoContatoDto() {
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

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
