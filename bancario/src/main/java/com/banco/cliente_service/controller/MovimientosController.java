package com.banco.cliente_service.controller;

import com.banco.cliente_service.dto.MovimientosDTO;
import com.banco.cliente_service.service.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {

    @Autowired
    private MovimientosService movimientosService;

    @PostMapping
    public ResponseEntity<MovimientosDTO> registrarMovimiento(@RequestBody MovimientosDTO movimientosDTO) {
        MovimientosDTO movimientoRegistrado = movimientosService.registrarMovimiento(movimientosDTO);
        return new ResponseEntity<>(movimientoRegistrado, HttpStatus.CREATED);
    }
}