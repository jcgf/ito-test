package com.jcgfdev.itoTest.factura.repositories;

import com.jcgfdev.itoTest.factura.entities.Factura;
import com.jcgfdev.itoTest.factura.entities.ProductosFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductosFacturaRepository extends JpaRepository<ProductosFactura, Long> {
    Optional<ProductosFactura> findById(Long id);

    List<ProductosFactura> findByIdFactura(Factura idFactura);
}
