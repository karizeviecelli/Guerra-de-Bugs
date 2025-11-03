package com.senai.exercicioUsuario.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //INDICA o auto incremento
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nickname", unique = true)
    private String nickname;

    @Column(name = "senha")
    private String senha;

    public UsuarioModel() {
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "/nNome: " + nome + "/nnickname: " + nickname;
    }
}
