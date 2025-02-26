package com.banco.cliente_service.repository;

import com.banco.cliente_service.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    // Verifica si una identificación ya existe
    boolean existsByIdentificacion(String identificacion);

    // Busca una persona por identificación
    Optional<Persona> findByIdentificacion(String identificacion);
}