package com.banco.cliente_service.dto;

import java.util.List;

public class CuentaDTO {
    private Long cuentaId;
    private String numeroCuenta;
    private String tipoCuenta;
    private double saldoInicial;
    private boolean estado;
    private String claveUnica;
    private List<MovimientosDTO> movimientos;

    // Getters y Setters
    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getClaveUnica() {
        return claveUnica;
    }

    public void setClaveUnica(String claveUnica) {
        this.claveUnica = claveUnica;
    }

    public List<MovimientosDTO> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientosDTO> movimientos) {
        this.movimientos = movimientos;
    }
}