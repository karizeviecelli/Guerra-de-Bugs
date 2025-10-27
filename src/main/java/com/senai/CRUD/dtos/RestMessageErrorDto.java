package com.senai.CRUD.dtos;

import org.springframework.http.HttpStatus;

public class RestMessageErrorDto {

    private String mensagem;
    private HttpStatus status;

    public RestMessageErrorDto(String mensagem, HttpStatus status) {
        this.mensagem = mensagem;
        this.status = status;
    }

    public RestMessageErrorDto() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
