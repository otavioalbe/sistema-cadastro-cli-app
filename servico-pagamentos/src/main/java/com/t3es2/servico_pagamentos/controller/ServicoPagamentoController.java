package com.t3es2.servico_pagamentos.controller;

import com.t3es2.servico_pagamentos.entity.Pagamento;
import com.t3es2.servico_pagamentos.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ServicoPagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/registrarpagamento")
    public ResponseEntity<Pagamento> registrarPagamento(@RequestBody Pagamento pagamento){
        return pagamentoService.registrarPagamento(pagamento);
    }
}
