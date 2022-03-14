package com.jcgfdev.itoTest.producto.services;

import com.jcgfdev.itoTest.producto.entities.dto.ProductoDTO;

public interface ProductoService {
    ProductoDTO agregarProducto(ProductoDTO productoDTO);

    String eliminarProducto(String codigoProducto);

    ProductoDTO obtenerProducto(String codigoProducto);

    ProductoDTO actualizaPrecioProducto(String codigoProducto, Double nuevoValorProducto);
}
