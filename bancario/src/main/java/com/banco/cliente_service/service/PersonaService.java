package com.banco.cliente_service.service;

import com.banco.cliente_service.exception.IdentificacionDuplicadaException;
import com.banco.cliente_service.exception.PersonaNotFoundException;
import com.banco.cliente_service.model.Persona;
import com.banco.cliente_service.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    /**
     * Crea una nueva persona.
     *
     * @param persona La persona a crear.
     * @return La persona creada.
     * @throws IdentificacionDuplicadaException Si la identificación ya está en uso.
     */
    public Persona crearPersona(Persona persona) {
        // Verifica si la identificación ya existe
        if (personaRepository.existsByIdentificacion(persona.getIdentificacion())) {
            throw new IdentificacionDuplicadaException("La identificación " + persona.getIdentificacion() + " ya está en uso.");
        }

        try {
            return personaRepository.save(persona);
        } catch (DataIntegrityViolationException ex) {
            // Captura cualquier otra violación de integridad (por si acaso)
            throw new IdentificacionDuplicadaException("Error al guardar la persona: " + ex.getMessage());
        }
    }

    /**
     * Obtiene todas las personas.
     *
     * @return Una lista de todas las personas.
     */
    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }

    /**
     * Obtiene una persona por su ID.
     *
     * @param id El ID de la persona.
     * @return La persona encontrada.
     * @throws PersonaNotFoundException Si la persona no existe.
     */
    public Persona obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new PersonaNotFoundException("Persona no encontrada con ID: " + id));
    }

    /**
     * Actualiza una persona existente.
     *
     * @param id               El ID de la persona a actualizar.
     * @param personaActualizada Los nuevos datos de la persona.
     * @return La persona actualizada.
     * @throws PersonaNotFoundException Si la persona no existe.
     */
    public Persona actualizarPersona(Long id, Persona personaActualizada) {
        return personaRepository.findById(id)
                .map(persona -> {
                    persona.setNombre(personaActualizada.getNombre());
                    persona.setGenero(personaActualizada.getGenero());
                    persona.setEdad(personaActualizada.getEdad());
                    persona.setIdentificacion(personaActualizada.getIdentificacion());
                    persona.setDireccion(personaActualizada.getDireccion());
                    persona.setTelefono(personaActualizada.getTelefono());
                    return personaRepository.save(persona);
                })
                .orElseThrow(() -> new PersonaNotFoundException("Persona no encontrada con ID: " + id));
    }

    /**
     * Elimina una persona por su ID.
     *
     * @param id El ID de la persona a eliminar.
     * @throws PersonaNotFoundException Si la persona no existe.
     */
    public void eliminarPersona(Long id) {
        if (!personaRepository.existsById(id)) {
            throw new PersonaNotFoundException("Persona no encontrada con ID: " + id);
        }
        personaRepository.deleteById(id);
    }

    /**
     * Busca una persona por su identificación.
     *
     * @param identificacion La identificación de la persona.
     * @return La persona encontrada.
     * @throws PersonaNotFoundException Si la persona no existe.
     */
    public Persona obtenerPersonaPorIdentificacion(String identificacion) {
        return personaRepository.findByIdentificacion(identificacion)
                .orElseThrow(() -> new PersonaNotFoundException("Persona no encontrada con identificación: " + identificacion));
    }
}