package com.jcgfdev.itoTest.factura.payloads.responses;

import com.jcgfdev.itoTest.cliente.entities.Cliente;
import com.jcgfdev.itoTest.cliente.entities.dto.ClienteDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FullFacturaResponse {
    private Long id;
    private String nombreCajero;
    private String numeroCaja;
    private ClienteDTO idCliente;
    private List<ProductosFacturaResponse> productosFacturaResponseList;
    private Double total;
}
