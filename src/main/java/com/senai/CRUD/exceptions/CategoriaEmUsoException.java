package com.senai.CRUD.exceptions;

public class CategoriaEmUsoException extends RuntimeException{

    public CategoriaEmUsoException() {
        super("Erro ao excluir: Categoria em uso.");
    }
}
