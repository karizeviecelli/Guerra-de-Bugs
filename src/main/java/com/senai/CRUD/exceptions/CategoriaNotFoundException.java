package com.senai.CRUD.exceptions;

public class CategoriaNotFoundException extends RuntimeException{
    public CategoriaNotFoundException() {
        super("Categoria não encontrada");
    }
}
