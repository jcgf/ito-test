package com.jcgfdev.itoTest.factura.entities.dto;

import com.jcgfdev.itoTest.factura.entities.Factura;
import com.jcgfdev.itoTest.producto.entities.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductosFacturaDTO {
    private Long id;
    private Factura idFactura;
    private Producto idProducto;
    private Integer cantidad;
    private Double total;
}
