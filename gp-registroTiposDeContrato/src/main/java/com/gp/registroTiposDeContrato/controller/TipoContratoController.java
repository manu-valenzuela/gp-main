package com.gp.registroTiposDeContrato.controller;

import com.gp.registroTiposDeContrato.dto.TipoContratoResponseDto;
import com.gp.registroTiposDeContrato.service.TipoContratoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-contrato")
@Slf4j
public class TipoContratoController {

    private final TipoContratoService tipoContratoService;

    public TipoContratoController(TipoContratoService tipoContratoService) {
        this.tipoContratoService = tipoContratoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoContratoResponseDto>> findAll() {
        log.info("Buscando los tipos de contrato");
        List<TipoContratoResponseDto> contratos = tipoContratoService.findAll();
        log.info("Se encontraron {} tipos de contrato", contratos.size());
        return ResponseEntity.ok(contratos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoContratoResponseDto> findById(@PathVariable Integer id) {
        log.info("Buscando tipo de contrato con ID: {}", id);
        TipoContratoResponseDto response = tipoContratoService.findById(id);
        log.info("Encontrado: {}", id);
        return ResponseEntity.ok(response);
    }
}
