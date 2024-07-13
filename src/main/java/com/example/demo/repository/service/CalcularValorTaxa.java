package com.example.demo.repository.service;

import com.example.demo.model.dto.AgendarTransferenciaDTO;
import com.example.demo.model.dto.TaxaValor;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class CalcularValorTaxa {

    public TaxaValor calcularValor(AgendarTransferenciaDTO agendarTransferenciaDTO) throws Exception {
        TaxaValor taxaValor = new TaxaValor();
        try {

            final double taxa0x0 = 2.5;
            final double taxa1x10 = 0;
            final double taxa11x20 = 8.2;
            final double taxa21x30 = 6.9;
            final double taxa31x40 = 4.7;
            final double taxa41x50 = 1.7;

            Date dataIni = agendarTransferenciaDTO.getDataAgendamento();
            Date dataFin = agendarTransferenciaDTO.getDataTransferencia();

            if (dataFin.getTime() < dataIni.getTime()){
                String message = "data de transferência menor que a data de agendamento";
                throw new RuntimeException(message);
            }

            long diasMillise = dataFin.getTime() - dataIni.getTime();
            long totalDias = diasMillise / (1000 * 60 * 60 * 24);

            double tx;
            double vlTx;

            if(totalDias == 0){
                tx = taxa0x0;
                double x = agendarTransferenciaDTO.getValorTransferencia() * 0.025;
                vlTx = agendarTransferenciaDTO.getValorTransferencia() + x;

                taxaValor.setTaxa(tx);
                taxaValor.setValorTaxa(vlTx);
                return taxaValor;

            }else if(totalDias >= 1 && totalDias <= 10){
                tx = taxa1x10;

                taxaValor.setTaxa(tx);
                taxaValor.setValorTaxa(agendarTransferenciaDTO.getValorTransferencia());
                return taxaValor;

            }else if(totalDias >= 11 && totalDias <= 20) {
                tx = taxa11x20;
                double x = agendarTransferenciaDTO.getValorTransferencia() * 0.082;
                vlTx = agendarTransferenciaDTO.getValorTransferencia() + x;

                taxaValor.setTaxa(tx);
                taxaValor.setValorTaxa(vlTx);
                return taxaValor;

            }else if(totalDias >= 21 && totalDias <= 30) {
                tx = taxa21x30;
                double x = agendarTransferenciaDTO.getValorTransferencia() * 0.069;
                vlTx = agendarTransferenciaDTO.getValorTransferencia() + x;

                taxaValor.setTaxa(tx);
                taxaValor.setValorTaxa(vlTx);
                return taxaValor;

            }else if(totalDias >= 31 && totalDias <= 40) {
                tx = taxa31x40;
                double x = agendarTransferenciaDTO.getValorTransferencia() * 0.049;
                vlTx = agendarTransferenciaDTO.getValorTransferencia() + x;

                taxaValor.setTaxa(tx);
                taxaValor.setValorTaxa(vlTx);
                return taxaValor;

            }else if(totalDias >= 41 && totalDias <= 50) {
                tx = taxa41x50;
                double x = agendarTransferenciaDTO.getValorTransferencia() * 0.017;
                vlTx = agendarTransferenciaDTO.getValorTransferencia() + x;

                taxaValor.setTaxa(tx);
                taxaValor.setValorTaxa(vlTx);
                return taxaValor;

            }else if (totalDias > 50){
                String message = "data de transferência fora do estipulado";
                throw new RuntimeException(message);
            }

                return null;
        } catch (Exception e) {
            String message = "data de transferência fora do estipulado";
            throw new RuntimeException(message, e);
        }
    }

}
