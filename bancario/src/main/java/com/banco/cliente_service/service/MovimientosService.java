package com.banco.cliente_service.service;

import com.banco.cliente_service.dto.MovimientosDTO;

public interface MovimientosService {
    MovimientosDTO registrarMovimiento(MovimientosDTO movimientosDTO);
}