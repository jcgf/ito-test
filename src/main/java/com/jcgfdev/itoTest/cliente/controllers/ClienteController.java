package com.jcgfdev.itoTest.cliente.controllers;

import com.jcgfdev.itoTest.base.utils.ResponseDTOService;
import com.jcgfdev.itoTest.cliente.entities.dto.ClienteDTO;
import com.jcgfdev.itoTest.cliente.services.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ResponseDTOService responseDTOService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @GetMapping("/obtenerCliente")
    public ResponseEntity<?> obtenerCliente(@RequestParam String numeroDocumento) {
        ClienteDTO clienteDTO = clienteService.obtenerCliente(numeroDocumento);
        return responseDTOService.response(clienteDTO, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Accepted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @DeleteMapping("/eliminarCliente")
    public ResponseEntity<?> eliminarCliente(@RequestParam String numeroDocumento) {
        return responseDTOService.response(clienteService.eliminarCliente(numeroDocumento), HttpStatus.ACCEPTED);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @PostMapping("/agregarCliente")
    public ResponseEntity<?> agregarCliente(@Valid @RequestBody ClienteDTO clienteDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return responseDTOService.response(HttpStatus.BAD_REQUEST);
        } else {
            return responseDTOService.response(clienteService.agregarCliente(clienteDTO), HttpStatus.CREATED);
        }
    }
}
