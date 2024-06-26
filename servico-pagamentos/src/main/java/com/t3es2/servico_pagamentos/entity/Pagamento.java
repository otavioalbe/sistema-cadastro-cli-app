package com.t3es2.servico_pagamentos.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cod_assinatura")
    private Long codAssinatura;
    @Column(name = "valor_pago")
    private float valorPago;
    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;
    public Pagamento(){}

    public Pagamento(Long codAssinatura, float valorPago, LocalDate dataPagamento){
        this.codAssinatura = codAssinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodAssinatura() {
        return codAssinatura;
    }

    public void setCodAssinatura(Long codAssinatura) {
        this.codAssinatura = codAssinatura;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
