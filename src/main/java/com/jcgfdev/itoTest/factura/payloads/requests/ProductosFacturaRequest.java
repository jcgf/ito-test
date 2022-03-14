package com.jcgfdev.itoTest.factura.payloads.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductosFacturaRequest {
    private Long idFactura;
    private String codigoProducto;
    private Integer cantidad;
}
