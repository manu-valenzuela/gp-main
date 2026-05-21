package com.gp.registroFaenas.controller;

import com.gp.registroFaenas.dto.FaenaRequestDto;
import com.gp.registroFaenas.dto.FaenaResponseDto;
import com.gp.registroFaenas.service.FaenaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faenas")
@Slf4j
public class FaenaController {

    private final FaenaService faenaService;

    public FaenaController(FaenaService faenaService) {
        this.faenaService = faenaService;
    }

    @PostMapping
    public ResponseEntity<FaenaResponseDto> create(@Valid @RequestBody FaenaRequestDto dto) {
        log.info("Solicitud para crear nueva faena: {}", dto.getNombre());
        FaenaResponseDto response = faenaService.create(dto);
        log.info("Faena creada exitosamente con ID: {}", response.getId());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<FaenaResponseDto>> findAll() {
        log.info("Solicitud para listar todas las faenas");
        List<FaenaResponseDto> faenas = faenaService.findAll();
        log.info("Se encontraron {} faenas", faenas.size());
        return ResponseEntity.ok(faenas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaenaResponseDto> findById(@PathVariable Integer id) {
        log.info("Solicitud para obtener faena con ID: {}", id);
        FaenaResponseDto response = faenaService.findById(id);
        log.info("Faena obtenida exitosamente con ID: {}", id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        log.info("Solicitud para eliminar faena con ID: {}", id);
        faenaService.delete(id);
        log.info("Faena eliminada exitosamente con ID: {}", id);
        return ResponseEntity.noContent().build();
    }
}
