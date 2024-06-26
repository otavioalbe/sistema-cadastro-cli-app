package com.t3es2.cadastramento_geral.service;

import com.t3es2.cadastramento_geral.entity.Assinatura;
import com.t3es2.cadastramento_geral.entity.AssinaturaRequest;
import com.t3es2.cadastramento_geral.repository.AplicativoRepository;
import com.t3es2.cadastramento_geral.repository.AssinaturaRepository;
import com.t3es2.cadastramento_geral.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AssinaturaService {

    @Autowired
    AssinaturaRepository repository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    AplicativoRepository aplicativoRepository;


    public ResponseEntity<Assinatura> cadastrarAssinatura(AssinaturaRequest assinatura){
        Long codCli = assinatura.getCodCli();
        Long codApp = assinatura.getCodApp();
        if(verificaCliente(codCli) && verificaAplicativo(codApp)){
            Assinatura assinaturaNew = new Assinatura(codCli, codApp);
            repository.save(assinaturaNew);
            return ResponseEntity.status(HttpStatus.CREATED).body(assinaturaNew);
        }
        Assinatura badResponse = new Assinatura(codCli, codApp);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badResponse);
    }

    public List<Assinatura> listaTiposAssinaturas(String tipo){
        tipo = tipo.toLowerCase();
        switch (tipo) {
            case "todas" -> {
                return listarAssinaturas();
            }
            case "ativas" -> {
                List<Assinatura> assinaturasAtivas = new ArrayList<>();
                LocalDate hoje = LocalDate.now();
                for (Assinatura a : listarAssinaturas()) {
                    if (a.getDataExpiracao().isAfter(hoje) || a.getDataExpiracao().isEqual(hoje)) {
                        assinaturasAtivas.add(a);
                    }
                }
                return assinaturasAtivas;
            }
            case "canceladas" -> {
                List<Assinatura> assinaturasCanceladas = new ArrayList<>();
                LocalDate hoje = LocalDate.now();
                for (Assinatura a : listarAssinaturas()) {
                    if (a.getDataExpiracao().isBefore(hoje)) {
                        a.setStatus("CANCELADA");
                        repository.save(a);
                        assinaturasCanceladas.add(a);
                    }
                }
                return assinaturasCanceladas;
            }
            default -> {
                return Collections.emptyList();
            }
        }
    }

    public List<Assinatura> assinaturasDoCliente(Long codCli){
        List<Assinatura> assCliente = new ArrayList<>();
        for(Assinatura a : listarAssinaturas()){
            if(a.getCodCli().equals(codCli)){
                assCliente.add(a);
            }
        }
        return assCliente;
    }

    public List<Assinatura> assinaturasDoApp(Long codApp){
        List<Assinatura> assApp = new ArrayList<>();
        for(Assinatura a : listarAssinaturas()){
            if(a.getCodApp().equals(codApp)){
                assApp.add(a);
            }
        }
        return assApp;
    }

    public List<Assinatura> listarAssinaturas(){
        return (List<Assinatura>) repository.findAll();
    }

    public boolean verificaCliente(Long idCli){
        return clienteRepository.existsById(idCli);
    }
    public boolean verificaAplicativo(Long idApp){
        return aplicativoRepository.existsById(idApp);
    }
}
