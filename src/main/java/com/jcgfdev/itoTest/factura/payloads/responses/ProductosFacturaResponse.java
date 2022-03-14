package com.jcgfdev.itoTest.factura.payloads.responses;

import com.jcgfdev.itoTest.producto.entities.dto.ProductoDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductosFacturaResponse {
    private ProductoDTO productoDTO;
    private Integer cantidad;
    private Double total;
}
