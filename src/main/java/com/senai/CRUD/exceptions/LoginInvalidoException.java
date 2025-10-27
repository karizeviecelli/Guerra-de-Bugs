package com.senai.CRUD.exceptions;

public class LoginInvalidoException extends RuntimeException{
    public LoginInvalidoException() {
        super("Login inválido!!");
    }
}
