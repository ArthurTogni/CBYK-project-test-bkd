package com.example.demo.controller;

import com.example.demo.model.dto.AgendarTransferenciaDTO;
import com.example.demo.model.dto.AgendarTransferenciaReturnDTO;
import com.example.demo.model.dto.TaxaValor;
import com.example.demo.repository.service.AgendarTransferenciaService;
import com.example.demo.repository.service.CalcularValorTaxa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitConfig
public class AgendarTransferenciaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AgendarTransferenciaService agendarTransferenciaService;

    @Mock
    private CalcularValorTaxa calcularValorTaxa;

    @InjectMocks
    private AgendarTransferenciaController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testAgendarTransferencia() throws Exception {
        // Objeto DTO de entrada
        AgendarTransferenciaDTO agendarTransferenciaDTO = new AgendarTransferenciaDTO();
        agendarTransferenciaDTO.setContaOrigem(123L);
        agendarTransferenciaDTO.setContaDestino(456L);
        agendarTransferenciaDTO.setValorTransferencia(100.0);

        // Objeto de retorno esperado
        AgendarTransferenciaReturnDTO agendarTransferenciaReturnDTO = new AgendarTransferenciaReturnDTO();
        agendarTransferenciaReturnDTO.setContaOrigem(123L);
        agendarTransferenciaReturnDTO.setContaDestino(456L);
        agendarTransferenciaReturnDTO.setValorTransferencia(100.0);
        agendarTransferenciaReturnDTO.setTaxa(1.0); // Valor de exemplo para taxa
        agendarTransferenciaReturnDTO.setValorComTaxa(101.0); // Valor de exemplo para valor com taxa

        // Mock do serviço de cálculo de taxa
        TaxaValor txValor = new TaxaValor();
        txValor.setTaxa(1.0);
        txValor.setValorTaxa(101.0);
        when(calcularValorTaxa.calcularValor(agendarTransferenciaDTO)).thenReturn(txValor);

        // Mock do serviço de agendamento de transferência
        when(agendarTransferenciaService.cadastrarAgendamento(agendarTransferenciaDTO, 1.0, 101.0)).thenReturn(new com.example.demo.model.AgendarTransferencia());

        // Converte objetos para JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String agendarTransferenciaDTOJson = objectMapper.writeValueAsString(agendarTransferenciaDTO);
        String agendarTransferenciaReturnDTOJson = objectMapper.writeValueAsString(agendarTransferenciaReturnDTO);

        // Executa a requisição POST para "/api/agendar-transferencia"
//        mockMvc.perform(post("/api/agendar-transferencia")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(agendarTransferenciaDTOJson))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json(agendarTransferenciaReturnDTOJson));
    }
}
