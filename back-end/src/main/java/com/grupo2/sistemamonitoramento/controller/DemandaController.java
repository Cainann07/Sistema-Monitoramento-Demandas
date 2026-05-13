package com.grupo2.sistemamonitoramento.controller;


import com.grupo2.sistemamonitoramento.dto.DemandaDTORequest;
import com.grupo2.sistemamonitoramento.model.Demanda;
import com.grupo2.sistemamonitoramento.service.DemandaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/demanda")
public class DemandaController {

    private DemandaService demandaService;

    public DemandaController(DemandaService demandaService) {
        this.demandaService = demandaService;
    }

    @PostMapping
    public ResponseEntity<Demanda> inserirDemanda(@RequestBody DemandaDTORequest demandaDTORequest){
        return ResponseEntity.ok(demandaService.inserirTarefa(demandaDTORequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Demanda>> lerDemanda(@PathVariable Long id){
        return ResponseEntity.ok(demandaService.lerDemanda(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<Demanda>> listarDemandas(){
        return ResponseEntity.ok(demandaService.listarDemandas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Demanda> atualizarDemanda(@PathVariable Long id, @RequestBody DemandaDTORequest demandaDTORequest){
        return ResponseEntity.ok(demandaService.atualizarDemanda(id, demandaDTORequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Demanda>> excluirDemanda(@PathVariable Long id){
        return ResponseEntity.ok(demandaService.excluirDemanda(id));
    }
}
