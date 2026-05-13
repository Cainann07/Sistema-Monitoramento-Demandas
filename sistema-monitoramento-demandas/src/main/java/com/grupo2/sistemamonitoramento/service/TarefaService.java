package com.grupo2.sistemamonitoramento.service;

import com.grupo2.sistemamonitoramento.dto.TarefaDTORequest;
import com.grupo2.sistemamonitoramento.model.Tarefa;
import com.grupo2.sistemamonitoramento.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Optional<Tarefa> lerTarefa(Long id){
        return Optional.of(tarefaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Essa tarefa não existe.")));
    }

    public Iterable<Tarefa> listarTarefas(){
        return tarefaRepository.findAll();
    }

    public Tarefa inserirTarefa(TarefaDTORequest tarefaDTORequest){
        Tarefa novaTarefa = new Tarefa(tarefaDTORequest);
        return tarefaRepository.save(novaTarefa);
    }

    public Tarefa atualizarTarefa(Long id, TarefaDTORequest tarefaDTORequest){
        Optional<Tarefa> tarefaExistente = Optional.of(tarefaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Essa tarefa não existe.")));
        tarefaExistente.get().setNome(tarefaDTORequest.getNome());
        tarefaExistente.get().setStatus(tarefaDTORequest.getStatus());
        return tarefaRepository.save(tarefaExistente.get());
    }

    public Optional<Tarefa> excluirTarefa(Long id){
        Optional<Tarefa> tarefa = Optional.of(tarefaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Essa tarefa não existe.")));
        tarefaRepository.deleteById(id);
        return tarefa;
    }
}
