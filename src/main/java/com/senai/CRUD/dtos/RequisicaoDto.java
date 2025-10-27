package com.senai.CRUD.dtos;

public class RequisicaoDto {
    private String nome;
    private String login;
    private String senha;

    public RequisicaoDto() {
    }


    public RequisicaoDto(String senha, String login, String nome) {
        this.senha = senha;
        this.login = login;
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
