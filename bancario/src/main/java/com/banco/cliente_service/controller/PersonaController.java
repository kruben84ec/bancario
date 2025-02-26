package com.banco.cliente_service.controller;

import com.banco.cliente_service.model.Persona;
import com.banco.cliente_service.service.PersonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    /**
     * Crea una nueva persona.
     *
     * @param persona La persona a crear.
     * @return La persona creada.
     */
    @PostMapping
    public ResponseEntity<Persona> crearPersona(@Valid @RequestBody Persona persona) {
        Persona nuevaPersona = personaService.crearPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPersona);
    }

    /**
     * Obtiene todas las personas.
     *
     * @return Una lista de todas las personas.
     */
    @GetMapping
    public ResponseEntity<List<Persona>> obtenerTodasLasPersonas() {
        List<Persona> personas = personaService.obtenerTodasLasPersonas();
        return ResponseEntity.ok(personas);
    }

    /**
     * Obtiene una persona por su ID.
     *
     * @param id El ID de la persona.
     * @return La persona encontrada.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id) {
        Persona persona = personaService.obtenerPersonaPorId(id);
        return ResponseEntity.ok(persona);
    }

    /**
     * Actualiza una persona existente.
     *
     * @param id               El ID de la persona a actualizar.
     * @param personaActualizada Los nuevos datos de la persona.
     * @return La persona actualizada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @Valid @RequestBody Persona personaActualizada) {
        Persona persona = personaService.actualizarPersona(id, personaActualizada);
        return ResponseEntity.ok(persona);
    }

    /**
     * Elimina una persona por su ID.
     *
     * @param id El ID de la persona a eliminar.
     * @return Respuesta sin contenido.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
        return ResponseEntity.noContent().build();
    }
}