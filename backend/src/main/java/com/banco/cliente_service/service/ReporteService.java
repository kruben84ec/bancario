package com.banco.cliente_service.service;

import com.banco.cliente_service.dto.ReporteEstadoCuentaDTO;

import java.util.Date;

public interface ReporteService {
    ReporteEstadoCuentaDTO generarEstadoDeCuenta(Long clienteId, Date fechaInicio, Date fechaFin);
}