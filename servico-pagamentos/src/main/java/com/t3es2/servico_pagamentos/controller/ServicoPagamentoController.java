package com.t3es2.servico_pagamentos.controller;

import com.t3es2.servico_pagamentos.entity.Pagamento;
import com.t3es2.servico_pagamentos.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@FeignClient(name = "cadastramento-geral")
@Controller
public class ServicoPagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/registrarpagamento")
    public ResponseEntity<Pagamento> registrarPagamento(@RequestBody Pagamento pagamento){

        ResponseEntity<Boolean> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8002/assinvalidas/{codAss}", Boolean.class, pagamento.getCodAssinatura());
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            boolean valida = responseEntity.getBody();
            if (valida) {
                Pagamento pagamentoNovo = pagamentoService.registrarPagamento(pagamento);
                return ResponseEntity.ok(pagamentoNovo);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).body(null);
        }

    }
}
