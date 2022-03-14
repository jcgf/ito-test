package com.jcgfdev.itoTest.factura.payloads.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacturaRequest {
    private String nombreCajero;
    private String numeroCaja;
    private String numeroDocumentoCliente;
}
