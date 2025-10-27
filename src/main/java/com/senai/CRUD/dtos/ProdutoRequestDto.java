package com.senai.CRUD.dtos;

public class ProdutoRequestDto {
    private String nome;
    private Double preco;
    private Long categoriaId;

    public ProdutoRequestDto() {
    }

    public ProdutoRequestDto(String nome, Double preco, Long categoriaId) {

        this.nome = nome;
        this.preco = preco;
        this.categoriaId = categoriaId;
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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public String toString() {
        return "ProdutoRequestDto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", categoriaId=" + categoriaId +
                '}';
    }
}
