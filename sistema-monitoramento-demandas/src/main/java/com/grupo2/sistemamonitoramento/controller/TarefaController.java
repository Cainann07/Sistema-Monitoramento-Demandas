package com.grupo2.sistemamonitoramento.controller;


import com.grupo2.sistemamonitoramento.dto.TarefaDTORequest;
import com.grupo2.sistemamonitoramento.model.Tarefa;
import com.grupo2.sistemamonitoramento.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Tarefa> inserirTarefa(@RequestBody TarefaDTORequest tarefaDTORequest){
        return ResponseEntity.ok(tarefaService.inserirTarefa(tarefaDTORequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Tarefa>> lerTarefa(@PathVariable Long id){
        return ResponseEntity.ok(tarefaService.lerTarefa(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<Tarefa>> listarTarefas(){
        return ResponseEntity.ok(tarefaService.listarTarefas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefas(@PathVariable Long id, @RequestBody TarefaDTORequest tarefaDTORequest){
        return ResponseEntity.ok(tarefaService.atualizarTarefa(id, tarefaDTORequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Tarefa>> excluirTarefa(@PathVariable Long id){
        return ResponseEntity.ok(tarefaService.excluirTarefa(id));
    }
}
