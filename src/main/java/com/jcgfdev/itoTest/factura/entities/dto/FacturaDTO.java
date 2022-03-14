package com.jcgfdev.itoTest.factura.entities.dto;

import com.jcgfdev.itoTest.cliente.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {
    private Long id;
    private String nombreCajero;
    private String numeroCaja;
    private Cliente idCliente;
    private Double total;
}
