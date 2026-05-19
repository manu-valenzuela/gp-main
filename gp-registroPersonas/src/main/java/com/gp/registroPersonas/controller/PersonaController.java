package com.gp.registroPersonas.controller;

import com.gp.registroPersonas.dto.PersonaResponseDto;
import com.gp.registroPersonas.service.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService service;

    public PersonaController(PersonaService service) { this.service = service; }

    @GetMapping
    public List<PersonaResponseDto> findAll() { return service.findAll(); }

    @GetMapping("/{rut}")
    public PersonaResponseDto findById(@PathVariable String rut) { return service.findById(rut); }
}
