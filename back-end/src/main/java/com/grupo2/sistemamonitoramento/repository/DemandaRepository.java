package com.grupo2.sistemamonitoramento.repository;

import com.grupo2.sistemamonitoramento.model.Demanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandaRepository extends JpaRepository<Demanda, Long> {
}
