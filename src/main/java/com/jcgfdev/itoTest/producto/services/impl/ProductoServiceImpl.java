package com.jcgfdev.itoTest.producto.services.impl;

import com.jcgfdev.itoTest.producto.entities.Producto;
import com.jcgfdev.itoTest.producto.entities.dto.ProductoDTO;
import com.jcgfdev.itoTest.producto.repositories.ProductoRepository;
import com.jcgfdev.itoTest.producto.services.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    private final ModelMapper modelMapper;

    public ProductoServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductoDTO agregarProducto(ProductoDTO productoDTO) {
        Producto producto = productoRepository.save(modelMapper
                .map(productoDTO, Producto.class));
        System.out.println(productoDTO);
        System.out.println(producto);
        return modelMapper.map(producto, ProductoDTO.class);
    }

    @Override
    public String eliminarProducto(String codigoProducto) {
        Producto producto = productoRepository.findByCodigoProducto(codigoProducto)
                .orElseThrow(() -> new IllegalStateException("producto no existe"));
        productoRepository.deleteById(producto.getId());
        return "producto con codigo<" + codigoProducto + "> ha sido eliminado";
    }

    @Override
    public ProductoDTO obtenerProducto(String codigoProducto) {
        Producto producto = productoRepository.findByCodigoProducto(codigoProducto)
                .orElseThrow(() -> new IllegalStateException("producto no existe"));
        return modelMapper.map(producto, ProductoDTO.class);
    }

    @Override
    public ProductoDTO actualizaPrecioProducto(String codigoProducto, Double nuevoValorProducto) {
        Producto producto = productoRepository.findByCodigoProducto(codigoProducto)
                .orElseThrow(() -> new IllegalStateException("producto no existe"));
        producto.setValorUnidad(nuevoValorProducto);
        return modelMapper.map(productoRepository.save(producto), ProductoDTO.class);
    }
}
