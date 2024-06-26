package com.t3es2.cadastramento_geral.entity;

import jakarta.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String from) {
        this.nome = from;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String to) {
        this.email = to;
    }

}
