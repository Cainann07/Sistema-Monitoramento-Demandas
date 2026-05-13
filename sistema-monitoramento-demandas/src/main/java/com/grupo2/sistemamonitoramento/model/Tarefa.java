package com.grupo2.sistemamonitoramento.model;

import com.grupo2.sistemamonitoramento.dto.TarefaDTORequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String status;

    public Tarefa(String nome, String status) {
        this.nome = nome;
        this.status = status;
    }

    public Tarefa(TarefaDTORequest tarefaDTORequest) {
        this.nome = tarefaDTORequest.getNome();
        this.status = tarefaDTORequest.getStatus();
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
