package com.example.demo.model.dto;

import java.sql.Date;
import java.sql.Time;

public class AgendarTransferenciaReturnDTO {

    private Long contaOrigem;
    private Long contaDestino;
    private Double valorTransferencia;
    private Date dataTransferencia;
    private Date dataAgendamento;
    private Double taxa;
    private Double ValorComTaxa;

    public Long getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Long contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Long getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Long contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Double getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(Double valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(Date dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public Double getValorComTaxa() {
        return ValorComTaxa;
    }

    public void setValorComTaxa(Double valorComTaxa) {
        ValorComTaxa = valorComTaxa;
    }
}
