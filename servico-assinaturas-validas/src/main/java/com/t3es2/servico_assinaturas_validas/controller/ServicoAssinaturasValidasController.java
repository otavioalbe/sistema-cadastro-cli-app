package com.t3es2.servico_assinaturas_validas.controller;

import com.t3es2.servico_assinaturas_validas.entity.Assinatura;
import com.t3es2.servico_assinaturas_validas.service.ServicoAssinaturasValidas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Controller
public class ServicoAssinaturasValidasController {

    @Autowired
    private ServicoAssinaturasValidas servicoAssinaturasValidas;

    @GetMapping("/assinvalidas/{codAss}")
    public ResponseEntity<Boolean> verificarAssinaturaValida(@PathVariable Long codAss) {

        ResponseEntity<Assinatura> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/servcad/assid/{codAss}", Assinatura.class, codAss);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            Assinatura assinatura = responseEntity.getBody();
            if (assinatura != null) {
                boolean isValida = servicoAssinaturasValidas.isAssinaturaValida(assinatura);
                return ResponseEntity.ok(isValida);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
            }
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).body(false);
        }

    }
}
