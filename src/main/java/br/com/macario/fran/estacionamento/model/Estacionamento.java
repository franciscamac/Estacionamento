package br.com.macario.fran.estacionamento.model;

import java.time.LocalDateTime;

public class Estacionamento {

    private String id;
    private String licenca;
    private String estado;
    private String modelo;
    private String cor;
    private LocalDateTime dataDeEntrada;
    private LocalDateTime dataDeSaida;
    private Double conta;

    public Estacionamento() {
    }

    public Estacionamento(String id, String licenca, String estado, String modelo, String cor) {
        this.id = id;
        this.licenca = licenca;
        this.estado = estado;
        this.modelo = modelo;
        this.cor = cor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLicenca() {
        return licenca;
    }

    public void setLicenca(String licenca) {
        this.licenca = licenca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public LocalDateTime getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(LocalDateTime dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    public LocalDateTime getDataDeSaida() {
        return dataDeSaida;
    }

    public void setDataDeSaida(LocalDateTime dataDeSaida) {
        this.dataDeSaida = dataDeSaida;
    }

    public Double getConta() {
        return conta;
    }

    public void setConta(Double conta) {
        this.conta = conta;
    }
}
