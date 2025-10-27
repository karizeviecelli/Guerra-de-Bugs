package com.senai.CRUD.dtos;

public class ErrorMessage {
    private String erroMessage;


    public ErrorMessage() {
    }

    public ErrorMessage(String erroMessage) {
        this.erroMessage = erroMessage;
    }

    public String getErroMessage() {
        return erroMessage;
    }

    public void setErroMessage(String erroMessage) {
        this.erroMessage = erroMessage;
    }


}
