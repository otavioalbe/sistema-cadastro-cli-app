package com.t3es2.cadastramento_geral.service;

import com.t3es2.cadastramento_geral.entity.Cliente;
import com.t3es2.cadastramento_geral.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listarClientes(){
        return (List<Cliente>) repository.findAll();
    }
}
