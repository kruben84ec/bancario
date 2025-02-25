package com.banco.cliente_service.repository;

import com.banco.cliente_service.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}