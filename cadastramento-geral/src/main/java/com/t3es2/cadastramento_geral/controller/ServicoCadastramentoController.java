package com.t3es2.cadastramento_geral.controller;

import com.t3es2.cadastramento_geral.entity.Aplicativo;
import com.t3es2.cadastramento_geral.entity.Assinatura;
import com.t3es2.cadastramento_geral.entity.AssinaturaRequest;
import com.t3es2.cadastramento_geral.entity.Cliente;
import com.t3es2.cadastramento_geral.service.AplicativoService;
import com.t3es2.cadastramento_geral.service.AssinaturaService;
import com.t3es2.cadastramento_geral.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/servcad")
public class ServicoCadastramentoController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private AplicativoService aplicativoService;
    @Autowired
    private AssinaturaService assinaturaService;


    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/aplicativos")
    public List<Aplicativo> listarAplicativos() {
        return aplicativoService.listarAplicativos();
    }

    @PostMapping("/assinaturas")
    public ResponseEntity<Assinatura> registraAssinatura(@RequestBody AssinaturaRequest assinatura){
        return assinaturaService.cadastrarAssinatura(assinatura);
    }

    @PatchMapping("/aplicativos/{id}")
    public ResponseEntity<Aplicativo> atualizarCustoApp(@PathVariable Long id, @RequestBody Map<String, Object> atualizado) {
        if (atualizado.containsKey("custoMensal")) {
            float custoMensal = ((Number) atualizado.get("custoMensal")).floatValue();
            return aplicativoService.atualizarCustoMensal(id, custoMensal);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/assinaturas/{tipo}")
    public List<Assinatura> assinaturaTipos(@PathVariable String tipo){
        return assinaturaService.listaTiposAssinaturas(tipo);
    }

    @GetMapping("/asscli/{codCli}")
    public List<Assinatura> assinaturasDoCliente (@PathVariable Long codCli){
        return assinaturaService.assinaturasDoCliente(codCli);
    }

    @GetMapping("/assapp/{codApp}")
    public List<Assinatura> assinaturasDoApp (@PathVariable Long codApp){
        return assinaturaService.assinaturasDoApp(codApp);
    }
}
