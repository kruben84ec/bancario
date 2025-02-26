package com.banco.cliente_service.service;

import com.banco.cliente_service.entity.Cliente;
import com.banco.cliente_service.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ClienteServiceIntegrationTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @Test
    public void testCrearCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Ana Gómez");
        cliente.setContrasena("password456");
        cliente.setEstado(true);

        Cliente clienteGuardado = clienteRepository.save(cliente);

        assertNotNull(clienteGuardado.getClienteId());
        assertEquals("Ana Gómez", clienteGuardado.getNombre());
        assertEquals("password456", clienteGuardado.getContrasena());
        assertTrue(clienteGuardado.isEstado());
    }
}