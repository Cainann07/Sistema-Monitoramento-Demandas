package com.grupo2.sistemamonitoramento.dto;

import com.grupo2.sistemamonitoramento.model.StatusDemanda;

public class DemandaDTORequest {

    private String nome;
    private StatusDemanda status;

    public DemandaDTORequest(String nome, StatusDemanda status) {
        this.nome = nome;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusDemanda getStatus() {
        return status;
    }

    public void setStatus(StatusDemanda status) {
        this.status = status;
    }
}
