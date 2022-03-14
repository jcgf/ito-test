package com.jcgfdev.itoTest.cliente.services;

import com.jcgfdev.itoTest.cliente.entities.dto.ClienteDTO;

public interface ClienteService {
    ClienteDTO agregarCliente(ClienteDTO clienteDTO);
    String eliminarCliente(String numeroDocumento);
    ClienteDTO obtenerCliente(String numeroDocumento);
}
