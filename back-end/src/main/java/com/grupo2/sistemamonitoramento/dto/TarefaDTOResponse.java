package com.grupo2.sistemamonitoramento.dto;

public class TarefaDTOResponse {

    private String nome;
    private String status;

    public TarefaDTOResponse(String nome, String status) {
        this.nome = nome;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
