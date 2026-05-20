package com.gp.registroPersonas.controller;

import com.gp.registroPersonas.dto.PersonaRequestDto;
import com.gp.registroPersonas.dto.PersonaResponseDto;
import com.gp.registroPersonas.service.PersonaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
@Slf4j
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping
    public ResponseEntity<PersonaResponseDto> create(@Valid @RequestBody PersonaRequestDto dto) {
        log.info("Solicitud para crear persona con RUT: {}-{}", dto.getRut(), dto.getDv());
        PersonaResponseDto response = personaService.create(dto);
        log.info("Persona creada exitosamente con RUT: {}-{}", response.getRut(), response.getDv());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PersonaResponseDto>> findAll() {
        log.info("Solicitud para listar todas las personas");
        List<PersonaResponseDto> personas = personaService.findAll();
        log.info("Se encontraron {} personas registradas", personas.size());
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/{rut}")
    public ResponseEntity<PersonaResponseDto> findById(@PathVariable String rut) {
        log.info("Solicitud para obtener persona con RUT: {}", rut);
        PersonaResponseDto response = personaService.findById(rut);
        log.info("Persona obtenida exitosamente con RUT: {}", rut);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{rut}")
    public ResponseEntity<PersonaResponseDto> update(@PathVariable String rut,
                                                     @Valid @RequestBody PersonaRequestDto dto) {
        log.info("Solicitud para actualizar persona con RUT: {}", rut);
        PersonaResponseDto response = personaService.update(rut, dto);
        log.info("Persona actualizada exitosamente con RUT: {}", rut);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity<Void> delete(@PathVariable String rut) {
        log.info("Solicitud para eliminar persona con RUT: {}", rut);
        personaService.delete(rut);
        log.info("Persona eliminada exitosamente con RUT: {}", rut);
        return ResponseEntity.noContent().build();
    }
}
