package com.senai.CRUD.exceptions;

public class CidadeExistenteException extends RuntimeException{

    public CidadeExistenteException() {
        super("Cidade já existe no banco de dados!!");
    }
}
