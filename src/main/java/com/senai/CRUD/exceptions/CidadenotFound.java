package com.senai.CRUD.exceptions;

public class CidadenotFound extends RuntimeException{
    public CidadenotFound() {
        super("Nenhuma cidade existesnte!!");
    }
}
