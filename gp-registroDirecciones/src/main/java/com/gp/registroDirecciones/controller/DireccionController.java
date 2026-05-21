package com.gp.registroDirecciones.controller;

import com.gp.registroDirecciones.dto.DireccionRequestDto;
import com.gp.registroDirecciones.dto.DireccionResponseDto;
import com.gp.registroDirecciones.service.DireccionService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    private static final Logger logger = LoggerFactory.getLogger(DireccionController.class);
    private final DireccionService service;

    public DireccionController(DireccionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DireccionResponseDto>> findAll() {
        logger.info("Listando todas las direcciones");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionResponseDto> findById(@PathVariable Long id) {
        logger.info("Obteniendo dirección con id {}", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<DireccionResponseDto> create(@Valid @RequestBody DireccionRequestDto request) {
        logger.info("Creando nueva dirección: {} {}", request.getCalle(), request.getNumero());
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DireccionResponseDto> update(@PathVariable Long id,
                                                       @Valid @RequestBody DireccionRequestDto request) {
        logger.info("Actualizando dirección con id {}", id);
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Eliminando dirección con id {}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
