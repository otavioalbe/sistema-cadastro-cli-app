package com.t3es2.servico_assinaturas_validas.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Assinatura {
    private Long id;
    private Long codApp;
    private Long codCli;
    private LocalDate dataCriacao;
    private LocalDate dataExpiracao;

    private String status;


    public Assinatura(Long id, Long codApp, Long codCli, LocalDate dataCriacao, LocalDate dataExpiracao, String status) {
        this.codApp = codApp;
        this.codCli = codCli;
        this.dataCriacao = dataCriacao;
        this.dataExpiracao = dataExpiracao;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodApp() {
        return codApp;
    }

    public void setCodApp(Long codApp) {
        this.codApp = codApp;
    }

    public Long getCodCli() {
        return codCli;
    }

    public void setCodCli(Long codCli) {
        this.codCli = codCli;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
