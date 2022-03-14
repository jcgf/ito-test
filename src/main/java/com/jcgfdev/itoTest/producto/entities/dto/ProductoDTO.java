package com.jcgfdev.itoTest.producto.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private Long id;
    private String codigoProducto;
    private String nombreProducto;
    private Double valorUnidad;
    private String estado;
}
