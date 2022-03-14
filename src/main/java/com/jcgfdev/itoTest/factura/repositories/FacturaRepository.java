package com.jcgfdev.itoTest.factura.repositories;

import com.jcgfdev.itoTest.factura.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
    Optional<Factura> findById(Long id);
}
