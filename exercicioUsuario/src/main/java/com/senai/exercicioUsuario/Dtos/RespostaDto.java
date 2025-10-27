package com.senai.exercicioUsuario.Dtos;

public class RespostaDto {

    private String msgResposta;

    public RespostaDto() {
    }

    public RespostaDto(String msgResposta) {
        this.msgResposta = msgResposta;
    }

    public String getMsgResposta() {
        return msgResposta;
    }

    public void setMsgResposta(String msgResposta) {
        this.msgResposta = msgResposta;
    }
}
