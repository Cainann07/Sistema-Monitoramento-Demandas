package com.grupo2.sistemamonitoramento.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusDemanda {
    EM_ANDAMENTO("Em andamento"),
    CONCLUIDO("Concluído"),
    CANCELADO("Cancelado");

    private final String descricao;

    StatusDemanda(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue // Controla o JSON enviado e recebido pelo Angular
    public String getDescricao() {
        return descricao;
    }
}