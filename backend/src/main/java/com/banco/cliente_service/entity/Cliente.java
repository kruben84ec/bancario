package com.banco.cliente_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data // Lombok: Genera getters, setters, toString, equals y hashCode
@EqualsAndHashCode(callSuper = true) // Lombok: Incluye los campos de la superclase en equals y hashCode
public class Cliente extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(max = 50, message = "La contraseña no puede superar los 50 caracteres")
    private String contrasena;

    private boolean estado;
}