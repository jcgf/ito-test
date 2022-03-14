package com.jcgfdev.itoTest.factura.entities;

import com.jcgfdev.itoTest.cliente.entities.Cliente;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCajero;
    private String numeroCaja;
    @ManyToOne(optional = false)
    @JoinColumn(name="id_cliente", referencedColumnName = "id")
    private Cliente idCliente;
    private Double total;
}
