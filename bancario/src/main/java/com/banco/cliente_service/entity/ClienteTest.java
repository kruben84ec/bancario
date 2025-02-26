package com.banco.cliente_service.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void testCliente() {
        Cliente cliente = new Cliente();
        cliente.setClienteId(1L);
        cliente.setNombre("Juan Pérez");
        cliente.setContrasena("password123");
        cliente.setEstado(true);

        assertEquals(1L, cliente.getClienteId());
        assertEquals("Juan Pérez", cliente.getNombre());
        assertEquals("password123", cliente.getContrasena());
        assertTrue(cliente.isEstado());
    }
}