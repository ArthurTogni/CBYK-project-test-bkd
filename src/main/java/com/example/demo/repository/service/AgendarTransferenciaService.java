package com.example.demo.repository.service;

import com.example.demo.model.AgendarTransferencia;
import com.example.demo.model.dto.AgendarTransferenciaDTO;
import com.example.demo.repository.AgendarTransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class AgendarTransferenciaService {

    @Autowired
    private AgendarTransferenciaRepository agendarTransferenciaRepository;

    public AgendarTransferencia getById(Long id){
        return agendarTransferenciaRepository.findById(id).orElse(new AgendarTransferencia());
    }

    public AgendarTransferencia cadastrarAgendamento(AgendarTransferenciaDTO agendarTransferenciaDTO, double taxa, double valorComTaxa){

        AgendarTransferencia agendarTransferencia  = new AgendarTransferencia();

        agendarTransferencia.setContaOrigem(agendarTransferenciaDTO.getContaOrigem());
        agendarTransferencia.setContaDestino(agendarTransferenciaDTO.getContaDestino());
        agendarTransferencia.setDataTransferencia(agendarTransferenciaDTO.getDataTransferencia());
        agendarTransferencia.setDataAgendamento(agendarTransferenciaDTO.getDataAgendamento());
        agendarTransferencia.setTaxa(taxa);
        agendarTransferencia.setValorTransferencia(agendarTransferenciaDTO.getValorTransferencia());
        agendarTransferencia.setValorComTaxa(valorComTaxa);

        agendarTransferenciaRepository.save(agendarTransferencia);
        return agendarTransferencia;
    }

}
