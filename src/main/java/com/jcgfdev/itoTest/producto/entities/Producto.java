package com.jcgfdev.itoTest.producto.entities;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String codigoProducto;
    @Lob
    private String nombreProducto;
    private Double valorUnidad;
    private String estado;
}
