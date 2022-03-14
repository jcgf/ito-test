package com.jcgfdev.itoTest.producto.repositories;

import com.jcgfdev.itoTest.producto.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> findById(Long id);

    Optional<Producto> findByCodigoProducto(String codigoProducto);
}
