package com.grupo2.sistemamonitoramento.model;

import com.grupo2.sistemamonitoramento.dto.DemandaDTORequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Demanda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String status;

    public Demanda() {
    }

    public Demanda(String nome, String status) {
        this.nome = nome;
        this.status = status;
    }

    public Demanda(DemandaDTORequest demandaDTORequest) {
        this.nome = demandaDTORequest.getNome();
        this.status = demandaDTORequest.getStatus();
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

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
