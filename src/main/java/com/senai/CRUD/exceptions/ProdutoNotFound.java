package com.senai.CRUD.exceptions;



public class ProdutoNotFound extends RuntimeException{

    public ProdutoNotFound() {
        super("Produto não econtrado com essa categoria.");
    }

    public ProdutoNotFound(long id){
        super("Produto não encontrado com esse id: "+id);
    }
}
