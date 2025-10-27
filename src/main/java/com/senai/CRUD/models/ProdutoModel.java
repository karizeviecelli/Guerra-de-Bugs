package com.senai.CRUD.models;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome",length = 45,nullable = false,unique = true)
    private String nome;
    @Column(name = "preco",nullable = false)
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "categoriaId")
    private CategoriaModel categoriaId;

    public ProdutoModel() {
    }

    public ProdutoModel(Long id, String nome, Double preco, CategoriaModel categoriaId) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoriaId = categoriaId;
    }

    public ProdutoModel(CategoriaModel categoriaId, Double preco, String nome) {
        this.categoriaId = categoriaId;
        this.preco = preco;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public CategoriaModel getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(CategoriaModel categoriaId) {
        this.categoriaId = categoriaId;
    }
}
