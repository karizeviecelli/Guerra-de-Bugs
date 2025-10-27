package com.senai.CRUD.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",nullable = false,length = 45)
    private String nome;
    @Column(name = "login",nullable = false,length = 45, unique = true)
    private String login;
    @Column(name = "senha",nullable = false,length = 45)
    private String senha;

    public UsuarioModel() {
    }


    public UsuarioModel(Long id,String senha, String login, String nome) {
        this.id = id;
        this.senha = senha;
        this.login = login;
        this.nome = nome;
    }
    public UsuarioModel(String senha, String login, String nome) {
        this.senha = senha;
        this.login = login;
        this.nome = nome;
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
