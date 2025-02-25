package com.banco.cliente_service.service;

import com.banco.cliente_service.dto.ClienteDTO;
import java.util.List;

public interface ClienteService {
    ClienteDTO crearCliente(ClienteDTO clienteDTO);
    ClienteDTO obtenerClientePorId(Long id);
    List<ClienteDTO> obtenerTodosLosClientes();
    ClienteDTO actualizarCliente(Long id, ClienteDTO clienteDTO);
    void eliminarCliente(Long id);
}