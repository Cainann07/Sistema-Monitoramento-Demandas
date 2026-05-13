package com.grupo2.sistemamonitoramento.repository;

import com.grupo2.sistemamonitoramento.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
