/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author igors
 */
public class BoletoDTO {
    private Long codigoBoleto;
    private String nome;
    private String cpf;
    private int qtdeParcelas;
    private BigDecimal valor;
    private Date dtPagamento;
    private Date dtVencimento;
    private String status;
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getQtdeParcelas() {
        return qtdeParcelas;
    }

    public void setQtdeParcelas(int qtdeParcelas) {
        this.qtdeParcelas = qtdeParcelas;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCodigoBoleto() {
        return codigoBoleto;
    }

    public void setCodigoBoleto(Long codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }
    
    
    
}
