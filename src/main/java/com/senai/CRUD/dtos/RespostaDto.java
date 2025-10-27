package com.senai.CRUD.dtos;

import com.senai.CRUD.models.UsuarioModel;

public class RespostaDto {
    private Long id;
    private String nome;
    private String login;
    private String senha;

    public RespostaDto(UsuarioModel usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
    }

    public RespostaDto(Long id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public RespostaDto(String senha, String login, String nome) {
        this.senha = senha;
        this.login = login;
        this.nome = nome;
    }
    public RespostaDto() {
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
