package com.senai.CRUD.exceptions;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException(long id) {
        super("Usuario não econtrado com esse id: "+id);
    }
}
