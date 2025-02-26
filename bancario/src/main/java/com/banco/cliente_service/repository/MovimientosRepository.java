package com.banco.cliente_service.repository;

import com.banco.cliente_service.entity.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientosRepository extends JpaRepository<Movimientos, Long> {
}