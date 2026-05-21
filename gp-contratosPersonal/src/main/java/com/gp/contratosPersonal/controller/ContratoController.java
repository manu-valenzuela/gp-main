package com.gp.contratosPersonal.controller;

import com.gp.contratosPersonal.dto.ContratoRequestDto;
import com.gp.contratosPersonal.dto.ContratoResponseDto;
import com.gp.contratosPersonal.service.ContratoService;
import com.gp.contratosPersonal.client.FaenaClient;
import com.gp.contratosPersonal.dto.FaenaResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/contratos")
@Slf4j
public class ContratoController {

    private final ContratoService contratoService;
    private final FaenaClient faenaClient;

    public ContratoController(ContratoService contratoService, FaenaClient faenaClient) {
        this.contratoService = contratoService;
        this.faenaClient = faenaClient;
    }

    @PostMapping
    public ResponseEntity<ContratoResponseDto> create(@Valid @RequestBody ContratoRequestDto dto) {
        log.info("Solicitud para crear contrato de persona ID {}", dto.getIdPersona());

        // Validación contra la duración de la faena
        FaenaResponseDto faena = faenaClient.getFaena(dto.getIdFaena());
        if (dto.getFechaInicio().isBefore(faena.getFechaInicio()) ||
                (faena.getFechaFin() != null && dto.getFechaInicio().isAfter(faena.getFechaFin()))) {
            throw new RuntimeException("La fecha de inicio del contrato está fuera del rango de la faena");
        }
        if (dto.getFechaFin() != null) {
            if (dto.getFechaFin().isBefore(faena.getFechaInicio()) ||
                    (faena.getFechaFin() != null && dto.getFechaFin().isAfter(faena.getFechaFin()))) {
                throw new RuntimeException("La fecha de término del contrato está fuera del rango de la faena");
            }
        }

        ContratoResponseDto response = contratoService.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoResponseDto> findById(@PathVariable Integer id) {
        log.info("Solicitud para obtener contrato con ID {}", id);
        ContratoResponseDto response = contratoService.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ContratoResponseDto>> findAll() {
        log.info("Solicitud para listar todos los contratos");
        List<ContratoResponseDto> contratos = contratoService.findAll();
        return ResponseEntity.ok(contratos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        log.info("Solicitud para eliminar contrato con ID {}", id);
        contratoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
