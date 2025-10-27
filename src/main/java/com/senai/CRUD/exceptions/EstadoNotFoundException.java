package com.senai.CRUD.exceptions;

public class EstadoNotFoundException extends RuntimeException{

    public EstadoNotFoundException() {
        super("nenhum estado existente!");
    }
}
