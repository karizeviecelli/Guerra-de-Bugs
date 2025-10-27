package com.senai.CRUD.exceptions;

public class CategoriaExistenteException extends RuntimeException{
    public CategoriaExistenteException(){
        super("Categoria já existe no banco de dados");
    }
}
