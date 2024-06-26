package com.t3es2.servico_assinaturas_validas.controller;

import com.t3es2.servico_assinaturas_validas.entity.Assinatura;
import com.t3es2.servico_assinaturas_validas.service.ServicoAssinaturasValidas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ServicoAssinaturasValidasController {

    @Autowired
    private ServicoAssinaturasValidas servicoAssinaturasValidas;

    @GetMapping("/assinvalidas/{codAss}")
    public ResponseEntity<Boolean> verificarAssinaturaValida(@PathVariable Long codAss) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8000/assinaturas/ATIVAS";

        ResponseEntity<List<Assinatura>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Assinatura>>() {}
        );

        List<Assinatura> todasAssinaturasValidas = response.getBody();

        boolean assinaturaValida = servicoAssinaturasValidas.isAssinaturaValida(codAss, todasAssinaturasValidas);
        return ResponseEntity.ok(assinaturaValida);
    }
}
