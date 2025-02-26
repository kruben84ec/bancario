package com.banco.cliente_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@MappedSuperclass // Indica que esta clase es una superclase y no se mapea directamente a una tabla
@Data // Lombok: Genera getters, setters, toString, equals y hashCode
public abstract class Persona {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "El nombre solo puede contener letras, espacios y algunos caracteres especiales")
    private String nombre;

    private String genero;

    @Min(value = 0, message = "La edad no puede ser negativa")
    private int edad;

    @NotBlank(message = "La identificación no puede estar vacía")
    private String identificacion;

    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(max = 50, message = "La dirección no puede superar los 50 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s.,'-]+$", message = "La dirección contiene caracteres no permitidos")
    private String direccion;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "^[0-9]+$", message = "El teléfono solo puede contener números")
    private String telefono;
}