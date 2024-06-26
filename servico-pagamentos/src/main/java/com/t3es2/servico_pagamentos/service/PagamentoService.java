package com.t3es2.servico_pagamentos.service;

import com.t3es2.servico_pagamentos.entity.Pagamento;
import com.t3es2.servico_pagamentos.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;


    public ResponseEntity<Pagamento> registrarPagamento(Pagamento pagamento){
        if(true){
            Long codAssinatura = pagamento.getCodAssinatura();
            float valorPago = pagamento.getValorPago();
            LocalDate dataPagamento = pagamento.getDataPagamento();
            Pagamento novoPagamento = new Pagamento(codAssinatura,valorPago,dataPagamento);
            repository.save(novoPagamento);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    //public boolean verificaAssinatura(){
    //}
}
