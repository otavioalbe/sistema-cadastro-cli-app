package com.t3es2.cadastramento_geral.entity;

import jakarta.persistence.*;

@Entity
public class Aplicativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomeApp")
    private String nomeApp;
    @Column(name = "custoMensal")
    private float custoMensal;

    public Aplicativo() {}

    public Aplicativo(Long id, String nomeApp, float custoMensal) {
        this.id = id;
        this.nomeApp = nomeApp;
        this.custoMensal = custoMensal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeApp() {
        return nomeApp;
    }

    public void setNomeApp(String nomeApp) {
        this.nomeApp = nomeApp;
    }

    public float getCustoMensal() {
        return custoMensal;
    }

   public void setCustoMensal(float custoMensal){
        this.custoMensal = custoMensal;
   }

}
