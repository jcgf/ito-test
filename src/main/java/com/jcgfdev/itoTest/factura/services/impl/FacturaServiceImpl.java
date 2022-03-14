package com.jcgfdev.itoTest.factura.services.impl;

import com.jcgfdev.itoTest.cliente.entities.Cliente;
import com.jcgfdev.itoTest.cliente.repositories.ClienteRepository;
import com.jcgfdev.itoTest.factura.entities.Factura;
import com.jcgfdev.itoTest.factura.entities.dto.FacturaDTO;
import com.jcgfdev.itoTest.factura.payloads.requests.FacturaRequest;
import com.jcgfdev.itoTest.factura.payloads.responses.FullFacturaResponse;
import com.jcgfdev.itoTest.factura.repositories.FacturaRepository;
import com.jcgfdev.itoTest.factura.services.FacturaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    public FacturaServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public FacturaDTO registrarFactura(FacturaRequest facturaRequest) {
        Factura factura = new Factura();
        Cliente cliente = clienteRepository.findByNumeroDocumento(facturaRequest.getNumeroDocumentoCliente())
                .orElseThrow(()-> new IllegalStateException("cliente no existe"));
        factura.setNombreCajero(facturaRequest.getNombreCajero());
        factura.setNumeroCaja(facturaRequest.getNumeroCaja());
        factura.setIdCliente(cliente);
        factura.setTotal(0.0);
        return modelMapper.map(factura, FacturaDTO.class);
    }

    @Override
    public List<FullFacturaResponse> listarFacturas() {
        List<Factura> facturaList = facturaRepository.findAll();
        List<FullFacturaResponse> fullFacturaResponseList = new ArrayList<>();

        return null;
    }
}
