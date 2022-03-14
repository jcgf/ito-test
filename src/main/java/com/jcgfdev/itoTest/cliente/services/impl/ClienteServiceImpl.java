package com.jcgfdev.itoTest.cliente.services.impl;

import com.jcgfdev.itoTest.cliente.entities.Cliente;
import com.jcgfdev.itoTest.cliente.entities.dto.ClienteDTO;
import com.jcgfdev.itoTest.cliente.repositories.ClienteRepository;
import com.jcgfdev.itoTest.cliente.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    private final ModelMapper modelMapper;

    public ClienteServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ClienteDTO agregarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.save(modelMapper
                .map(clienteDTO, Cliente.class));
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @Override
    public String eliminarCliente(String numeroDocumento) {
        Cliente cliente = clienteRepository.findByNumeroDocumento(numeroDocumento)
                .orElseThrow(() -> new IllegalStateException("cliente no existe"));
        clienteRepository.deleteById(cliente.getId());
        return "cliente con numero de documento<" + numeroDocumento + "> ha sido eliminado";
    }

    @Override
    public ClienteDTO obtenerCliente(String numeroDocumento) {
        Cliente cliente = clienteRepository.findByNumeroDocumento(numeroDocumento)
                .orElseThrow(() -> new IllegalStateException("cliente no existe"));
        return modelMapper.map(cliente, ClienteDTO.class);
    }
}
