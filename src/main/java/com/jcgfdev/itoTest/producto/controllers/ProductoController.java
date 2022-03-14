package com.jcgfdev.itoTest.producto.controllers;

import com.jcgfdev.itoTest.base.utils.ResponseDTOService;
import com.jcgfdev.itoTest.producto.entities.dto.ProductoDTO;
import com.jcgfdev.itoTest.producto.services.ProductoService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @Autowired
    private ResponseDTOService responseDTOService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @PostMapping("/agregarProducto")
    public ResponseEntity<?> agregarProducto(@Valid @RequestBody ProductoDTO productoDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return responseDTOService.response(HttpStatus.BAD_REQUEST);
        } else {
            return responseDTOService.response(productoService.agregarProducto(productoDTO), HttpStatus.CREATED);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Accepted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoDTO.class))}),
            @ApiResponse(responseCode = "404", description = "producto no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @DeleteMapping("/eliminarProducto")
    public ResponseEntity<?> eliminarProducto(@RequestParam String codigoProducto) {
        return responseDTOService.response(productoService.eliminarProducto(codigoProducto), HttpStatus.ACCEPTED);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoDTO.class))}),
            @ApiResponse(responseCode = "404", description = "producto no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @GetMapping("/obtenerProducto")
    public ResponseEntity<?> obtenerProducto(@RequestParam String codigoProducto) {
        return responseDTOService.response(productoService.obtenerProducto(codigoProducto), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Accepted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoDTO.class))}),
            @ApiResponse(responseCode = "404", description = "producto no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @PutMapping("/actualizaPrecioProducto")
    public ResponseEntity<?> actualizaPrecioProducto(@RequestParam String codigoProducto, @RequestParam Double nuevoValorProducto){
        return responseDTOService.response(productoService.actualizaPrecioProducto(codigoProducto, nuevoValorProducto), HttpStatus.ACCEPTED);
    }
}
