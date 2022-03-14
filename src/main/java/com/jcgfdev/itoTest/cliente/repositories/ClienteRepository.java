package com.jcgfdev.itoTest.cliente.repositories;

import com.jcgfdev.itoTest.cliente.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findById(long id);

    Optional<Cliente> findByNumeroDocumento(String numeroDocumento);
}
