package com.grupo2.sistemamonitoramento.model;

import com.grupo2.sistemamonitoramento.dto.DemandaDTORequest;
import jakarta.persistence.*;

@Entity
public class Demanda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING) // Salva como STRING no MySQL para ficar legível
    private StatusDemanda status;

    public Demanda() {
    }

    public Demanda(Long id, String nome, StatusDemanda status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public Demanda(DemandaDTORequest demandaDTORequest) {
        this.nome = demandaDTORequest.getNome();
        this.status = demandaDTORequest.getStatus();
    }

    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
