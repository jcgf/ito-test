package com.jcgfdev.itoTest.factura.services.impl;

import com.jcgfdev.itoTest.factura.entities.Factura;
import com.jcgfdev.itoTest.factura.entities.ProductosFactura;
import com.jcgfdev.itoTest.factura.payloads.requests.ProductosFacturaRequest;
import com.jcgfdev.itoTest.factura.repositories.FacturaRepository;
import com.jcgfdev.itoTest.factura.repositories.ProductosFacturaRepository;
import com.jcgfdev.itoTest.factura.services.ProductosFacturaService;
import com.jcgfdev.itoTest.producto.entities.Producto;
import com.jcgfdev.itoTest.producto.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosFacturaServiceImpl implements ProductosFacturaService {
    @Autowired
    private ProductosFacturaRepository productosFacturaRepository;
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public String agregarProductoFactura(ProductosFacturaRequest productosFacturaRequest) {
        ProductosFactura productosFactura = new ProductosFactura();
        Factura factura = facturaRepository.findById(productosFacturaRequest.getIdFactura())
                .orElseThrow(() -> new IllegalStateException("factura no existe"));
        Producto producto = productoRepository.findByCodigoProducto(productosFacturaRequest.getCodigoProducto())
                .orElseThrow(() -> new IllegalStateException("producto no existe"));
        productosFactura.setIdFactura(factura);
        productosFactura.setIdProducto(producto);
        productosFactura.setCantidad(productosFacturaRequest.getCantidad());
        productosFactura.setTotal(producto.getValorUnidad() * productosFacturaRequest.getCantidad());
        productosFacturaRepository.save(productosFactura);
        return "producto agregado exitosamente";
    }
}
