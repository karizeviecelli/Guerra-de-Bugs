package com.senai.CRUD.exceptions;

public class ContatoNotFound extends RuntimeException{
    public ContatoNotFound() {
        super("nenhum contato encontrado");
    }
}
