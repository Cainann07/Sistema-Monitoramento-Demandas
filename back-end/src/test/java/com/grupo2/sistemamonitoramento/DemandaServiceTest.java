package com.grupo2.sistemamonitoramento;

import com.grupo2.sistemamonitoramento.model.Demanda;
import com.grupo2.sistemamonitoramento.repository.DemandaRepository;
import com.grupo2.sistemamonitoramento.service.DemandaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DemandaServiceTest {

    @Mock
    private DemandaRepository demandaRepository; // Simula o BD

    @InjectMocks
    private DemandaService demandaService; // Injeta o Mock no service

    @Test
    @DisplayName("Deve retornar o ID informado")
    void buscarPorIdComSucesso() {
        // Cenário
        Long id = 1L;
//        Demanda demanda = new Demanda("Estudar JUnit", "Em andamento");
//        when(demandaRepository.findById(id)).thenReturn(Optional.of(demanda));

        // Ação
        Optional<Demanda> resultado = demandaService.lerDemanda(id);

        // Verificação
        assertNotNull(resultado);
        assertEquals("Estudar JUnit", resultado.get().getNome());
        verify(demandaRepository, times(1)).findById(id); // Garante que o banco foi consultado 1 vez
    }

    @Test
    @DisplayName("Deve lançar exceção quando a tarefa não for encontrada")
    void buscarPorIdFalha() {
        // Cenário
        Long id = 2L;
        when(demandaRepository.findById(id)).thenReturn(Optional.empty());

        // Ação e Verificação
        assertThrows(NoSuchElementException.class, () -> demandaService.lerDemanda(id));
    }
}
