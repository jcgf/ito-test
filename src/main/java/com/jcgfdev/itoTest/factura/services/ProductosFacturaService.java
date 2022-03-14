package com.jcgfdev.itoTest.factura.services;

import com.jcgfdev.itoTest.factura.payloads.requests.ProductosFacturaRequest;

public interface ProductosFacturaService {
    String agregarProductoFactura(ProductosFacturaRequest productosFacturaRequest);
}
