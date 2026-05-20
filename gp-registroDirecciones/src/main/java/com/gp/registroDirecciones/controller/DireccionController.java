package com.gp.registroDirecciones.controller;

import com.gp.registroDirecciones.dto.DireccionResponseDto;
import com.gp.registroDirecciones.service.DireccionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    private final DireccionService service;

    public DireccionController(DireccionService service) {
        this.service = service;
    }

    @GetMapping
    public List<DireccionResponseDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DireccionResponseDto findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
