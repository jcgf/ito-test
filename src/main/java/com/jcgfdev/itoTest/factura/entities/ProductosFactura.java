package com.jcgfdev.itoTest.factura.entities;

import com.jcgfdev.itoTest.producto.entities.Producto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "productos_factura")
public class ProductosFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_factura", referencedColumnName = "id")
    private Factura idFactura;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private Producto idProducto;
    private Integer cantidad;
    private Double total;
}
