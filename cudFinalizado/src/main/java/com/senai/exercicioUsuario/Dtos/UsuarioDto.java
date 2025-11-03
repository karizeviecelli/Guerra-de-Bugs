package com.senai.exercicioUsuario.Dtos;

public class UsuarioDto {

    private Long id;
    private String nome;
    private String nickname;
    private String senha;

    public UsuarioDto() {
    }

    public UsuarioDto(Long id, String nome, String nickname, String senha) {
        this.id = id;
        this.nome = nome;
        this.nickname = nickname;
        this.senha = senha;
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
        return "/nId: " + id + "/nNome: " + nome + "/nnickname: " + nickname + "/nSenha: " + senha ;
    }
}
