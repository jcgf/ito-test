package com.jcgfdev.itoTest.factura.services;

import com.jcgfdev.itoTest.factura.entities.dto.FacturaDTO;
import com.jcgfdev.itoTest.factura.payloads.requests.FacturaRequest;
import com.jcgfdev.itoTest.factura.payloads.responses.FullFacturaResponse;

import java.util.List;

public interface FacturaService {
    FacturaDTO registrarFactura(FacturaRequest facturaRequest);
    List<FullFacturaResponse> listarFacturas();
}
