package com.gp.registroIndicadores.controller;

import com.gp.registroIndicadores.dto.SeguroCesantiaResponseDto;
import com.gp.registroIndicadores.service.SeguroCesantiaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seguro-cesantia")
@RequiredArgsConstructor
@Slf4j
public class SeguroCesantiaController {

    private final SeguroCesantiaService seguroCesantiaService;

    @GetMapping
    public List<SeguroCesantiaResponseDto> getAllSeguros() {
        log.info("Consultando todos los seguros de cesantía del trabajador");
        return seguroCesantiaService.findAll();
    }

    @GetMapping("/{id}")
    public SeguroCesantiaResponseDto getSeguroById(@PathVariable int id) {
        log.info("Consultando seguro de cesantía del trabajador con ID: {}", id);
        return seguroCesantiaService.findById(id);
    }
}
