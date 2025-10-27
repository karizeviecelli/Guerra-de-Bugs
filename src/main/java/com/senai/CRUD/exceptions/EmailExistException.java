package com.senai.CRUD.exceptions;

public class EmailExistException extends RuntimeException{
    public EmailExistException(){
        super("Já existe login com esse email.");
    }
    public EmailExistException(String mensagem){
        super(mensagem);
    }
}
