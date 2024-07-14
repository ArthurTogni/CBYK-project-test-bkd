package com.example.demo.controller;

import com.example.demo.model.AgendarTransferencia;
import com.example.demo.repository.service.AgendarTransferenciaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitConfig
public class AgendarTransferenciaConsultaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AgendarTransferenciaService agendarTransferenciaService;

    @InjectMocks
    private AgendarTransferenciaConsultaController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testConsultarAll() throws Exception {
        // Mock de dados para o serviço
        AgendarTransferencia transferencia1 = new AgendarTransferencia();
        transferencia1.setId(1L);
        transferencia1.setContaOrigem(123L);
        transferencia1.setContaDestino(456L);
        transferencia1.setValorTransferencia(100.0);
        transferencia1.setDataTransferencia(new Date(System.currentTimeMillis()));
        transferencia1.setDataAgendamento(new Date(System.currentTimeMillis()));
        transferencia1.setTaxa(1.0);
        transferencia1.setValorComTaxa(101.0);

        AgendarTransferencia transferencia2 = new AgendarTransferencia();
        transferencia2.setId(2L);
        transferencia2.setContaOrigem(789L);
        transferencia2.setContaDestino(987L);
        transferencia2.setValorTransferencia(200.0);
        transferencia2.setDataTransferencia(new Date(System.currentTimeMillis()));
        transferencia2.setDataAgendamento(new Date(System.currentTimeMillis()));
        transferencia2.setTaxa(2.0);
        transferencia2.setValorComTaxa(202.0);

        List<AgendarTransferencia> transferencias = Arrays.asList(transferencia1, transferencia2);

        // Configura o comportamento esperado do serviço mockado
        when(agendarTransferenciaService.getAll()).thenReturn(transferencias);

        // Executa a requisição GET para "/api/agendar-transferencia"
        mockMvc.perform(get("/api/agendar-transferencia")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1)) // Verifica o primeiro elemento da lista
                .andExpect(jsonPath("$[0].contaOrigem").value(123))
                .andExpect(jsonPath("$[0].contaDestino").value(456))
                .andExpect(jsonPath("$[0].valorTransferencia").value(100.0))
                .andExpect(jsonPath("$[1].id").value(2)) // Verifica o segundo elemento da lista
                .andExpect(jsonPath("$[1].contaOrigem").value(789))
                .andExpect(jsonPath("$[1].contaDestino").value(987))
                .andExpect(jsonPath("$[1].valorTransferencia").value(200.0));
    }
}
