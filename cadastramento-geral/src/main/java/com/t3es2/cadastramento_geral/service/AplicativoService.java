package com.t3es2.cadastramento_geral.service;

import com.t3es2.cadastramento_geral.entity.Aplicativo;
import com.t3es2.cadastramento_geral.repository.AplicativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AplicativoService {

    @Autowired
    AplicativoRepository repository;

    public List<Aplicativo> listarAplicativos(){
        return (List<Aplicativo>) repository.findAll();
    }

    public ResponseEntity<Aplicativo> atualizarCustoMensal(Long id, float custoMensal){
        if(verificarAplicativo(id) != null){
            Aplicativo appAtualizado = verificarAplicativo(id);
            appAtualizado.setCustoMensal(custoMensal);
            appAtualizado = repository.save(appAtualizado);
            return ResponseEntity.status(HttpStatus.OK).body(appAtualizado);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(verificarAplicativo(id));
        }

    }

    private Aplicativo verificarAplicativo(Long id){
        for(Aplicativo app : listarAplicativos()){
            if(app.getId().equals(id)){
                return app;
            }
        }
        return null;
    }
}
