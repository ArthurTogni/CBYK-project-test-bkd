package com.example.demo.service;

import com.example.demo.model.AgendarTransferencia;
import com.example.demo.model.dto.AgendarTransferenciaDTO;
import com.example.demo.repository.AgendarTransferenciaRepository;
import com.example.demo.repository.service.AgendarTransferenciaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AgendarTransferenciaServiceTest {

    @Mock
    private AgendarTransferenciaRepository agendarTransferenciaRepository;

    @InjectMocks
    private AgendarTransferenciaService agendarTransferenciaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCadastrarAgendamento() {
        // Criação dos dados de entrada
        AgendarTransferenciaDTO dto = new AgendarTransferenciaDTO();
        dto.setContaOrigem(1L); // Corrigido para Long
        dto.setContaDestino(2L); // Corrigido para Long
        dto.setDataTransferencia(Date.valueOf("2024-07-14"));
        dto.setDataAgendamento(Date.valueOf("2024-07-13"));
        dto.setValorTransferencia(100.0);

        double taxa = 5.0;
        double valorComTaxa = 105.0;

        // Mock do comportamento do repositório
        when(agendarTransferenciaRepository.save(any(AgendarTransferencia.class))).thenReturn(new AgendarTransferencia());

        // Chama o método a ser testado
        AgendarTransferencia result = agendarTransferenciaService.cadastrarAgendamento(dto, taxa, valorComTaxa);

        // Verificações
        verify(agendarTransferenciaRepository, times(1)).save(any(AgendarTransferencia.class));
        assertEquals(dto.getContaOrigem(), result.getContaOrigem());
        assertEquals(dto.getContaDestino(), result.getContaDestino());
        assertEquals(dto.getDataTransferencia(), result.getDataTransferencia());
        assertEquals(dto.getDataAgendamento(), result.getDataAgendamento());
        assertEquals(taxa, result.getTaxa());
        assertEquals(dto.getValorTransferencia(), result.getValorTransferencia());
        assertEquals(valorComTaxa, result.getValorComTaxa());
    }

    @Test
    public void testGetById_ExistingId() {
        Long id = 1L;
        AgendarTransferencia expected = new AgendarTransferencia();
        expected.setId(id);
        when(agendarTransferenciaRepository.findById(id)).thenReturn(Optional.of(expected));

        AgendarTransferencia result = agendarTransferenciaService.getById(id);

        assertEquals(expected.getId(), result.getId());
    }


    // Você pode adicionar mais testes conforme necessário
}
