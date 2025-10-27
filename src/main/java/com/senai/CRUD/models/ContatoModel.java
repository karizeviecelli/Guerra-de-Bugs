package com.senai.CRUD.models;

import jakarta.persistence.*;

@Entity
@Table(name = "contato")
public class ContatoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false,length = 50)
    private String nome;
    @Column(name = "email", nullable = false,length = 50)
    private String email;
    @Column(name = "telefone", nullable = false,length = 12)
    private long telefone;
    @ManyToOne
    @JoinColumn(name = "cidade")
    private CidadeModel cidade;

    public ContatoModel(Long id, String nome, String email, CidadeModel cidade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
    }
    public ContatoModel() {}

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

    public CidadeModel getCidade() {
        return cidade;
    }

    public void setCidade(CidadeModel cidade) {
        this.cidade = cidade;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
}
