package com.senai.CRUD.exceptions;

public class EstadoExistException extends RuntimeException{
    public EstadoExistException() {
        super("Estado já existe no banco de dados!!");
    }
}
