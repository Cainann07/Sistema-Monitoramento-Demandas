package com.grupo2.sistemamonitoramento.dto;

import com.grupo2.sistemamonitoramento.model.StatusDemanda;

public class DemandaDTOResponse {

    private Long id;
    private String nome;
    private StatusDemanda status;

    public DemandaDTOResponse(Long id, String nome, StatusDemanda status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
