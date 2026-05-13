package com.grupo2.sistemamonitoramento.service;

import com.grupo2.sistemamonitoramento.dto.DemandaDTORequest;
import com.grupo2.sistemamonitoramento.model.Demanda;
import com.grupo2.sistemamonitoramento.repository.DemandaRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DemandaService {

    private DemandaRepository demandaRepository;

    public DemandaService(DemandaRepository demandaRepository) {
        this.demandaRepository = demandaRepository;
    }

    public Optional<Demanda> lerDemanda(Long id) {
        return Optional.of(demandaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Essa demanda não existe.")));
    }

    public Iterable<Demanda> listarDemandas() {
        return demandaRepository.findAll();
    }

    public Demanda inserirTarefa(DemandaDTORequest demandaDTORequest) {
        Demanda novaDemanda = new Demanda(demandaDTORequest);
        return demandaRepository.save(novaDemanda);
    }

    public Demanda atualizarDemanda(Long id, DemandaDTORequest demandaDTORequest) {
        Optional<Demanda> demandaExistente = Optional.of(demandaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Essa demanda não existe.")));
        demandaExistente.get().setNome(demandaDTORequest.getNome());
        demandaExistente.get().setStatus(demandaDTORequest.getStatus());
        return demandaRepository.save(demandaExistente.get());
    }

    public Optional<Demanda> excluirDemanda(Long id) {
        Optional<Demanda> demanda = Optional.of(demandaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Essa demanda não existe.")));
        demandaRepository.deleteById(id);
        return demanda;
    }
}
