package com.jcgfdev.itoTest.cliente.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    private String primerNombre;
    private String segundoNombre;
    @Basic(optional = false)
    private String primerApellido;
    @Basic(optional = false)
    private String segundoApellido;
    @Basic(optional = false)
    private String tipoDocumento;
    @Basic(optional = false)
    private String numeroDocumento;
    @Lob
    @Basic(optional = false)
    private String direccion;
}
