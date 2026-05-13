package com.grupo2.sistemamonitoramento;

import com.grupo2.sistemamonitoramento.model.Tarefa;
import com.grupo2.sistemamonitoramento.repository.TarefaRepository;
import com.grupo2.sistemamonitoramento.service.TarefaService;
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
public class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository; // Simula o BD

    @InjectMocks
    private TarefaService tarefaService; // Injeta o Mock no service

    @Test
    @DisplayName("Deve retornar o ID informado")
    void buscarPorIdComSucesso(){
        // Cenário
        Long id = 1L;
        Tarefa tarefa = new Tarefa("Estudar JUnit", "Em andamento");
        when(tarefaRepository.findById(id)).thenReturn(Optional.of(tarefa));

        // Ação
        Optional<Tarefa> resultado = tarefaService.lerTarefa(id);

        // Verificação
        assertNotNull(resultado);
        assertEquals("Estudar JUnit", resultado.get().getNome());
        verify(tarefaRepository, times(1)).findById(id); // Garante que o banco foi consultado 1 vez
    }

    @Test
    @DisplayName("Deve lançar exceção quando a tarefa não for encontrada")
    void buscarPorIdFalha() {
        // Cenário
        Long id = 2L;
        when(tarefaRepository.findById(id)).thenReturn(Optional.empty());

        // Ação e Verificação
        assertThrows(NoSuchElementException.class, () -> tarefaService.lerTarefa(id));
    }
}
