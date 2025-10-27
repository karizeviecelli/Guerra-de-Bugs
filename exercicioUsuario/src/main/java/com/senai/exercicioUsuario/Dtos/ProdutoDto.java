package com.senai.exercicioUsuario.Dtos;

public class ProdutoDto {

    private Long id;
    private String nome;
    private Double preco;
    private Long categoriaId;


    public ProdutoDto() {
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
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

    @Override
    public String toString() {
        return "/nId: " + id + "/nNome: " + nome;
    }
}
