package com.senai.CRUD.dtos;

import com.senai.CRUD.models.ProdutoModel;

public class ProdutoResponseDto {
    private Long id;
    private String nome;
    private Double preco;
    private String categoria;

    public ProdutoResponseDto() {
    }

    public ProdutoResponseDto(ProdutoModel p,String categoria){
        this.id = p.getId();
        this.nome = p.getNome();
        this.preco = p.getPreco();
        this.categoria = categoria;
    }

    public ProdutoResponseDto(Long id, String nome, Double preco, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ProdutoResponseDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", categoria=" + categoria +
                '}';
    }
}
