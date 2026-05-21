package com.gp.registroPersonas.service.impl;

import com.gp.registroPersonas.dto.PersonaRequestDto;
import com.gp.registroPersonas.dto.PersonaResponseDto;
import com.gp.registroPersonas.model.EstadoCivil;
import com.gp.registroPersonas.model.Persona;
import com.gp.registroPersonas.repository.EstadoCivilRepository;
import com.gp.registroPersonas.repository.PersonaRepository;
import com.gp.registroPersonas.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final EstadoCivilRepository estadoCivilRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository,
                              EstadoCivilRepository estadoCivilRepository) {
        this.personaRepository = personaRepository;
        this.estadoCivilRepository = estadoCivilRepository;
    }

    @Override
    public PersonaResponseDto create(PersonaRequestDto dto) {
        log.info("Creando nueva persona con RUT: {}-{}", dto.getRut(), dto.getDv());
        Persona persona = toEntity(dto);
        Persona saved = personaRepository.save(persona);
        log.info("Persona creada exitosamente con RUT: {}-{}", saved.getRut(), saved.getDv());
        return toDto(saved);
    }

    @Override
    public List<PersonaResponseDto> findAll() {
        log.info("Listando todas las personas registradas");
        return personaRepository.findAll()
                .stream()
                .map(this::toDto).toList();
    }

    @Override
    public PersonaResponseDto findById(String rut) {
        log.info("Buscando persona con RUT: {}", rut);
        Persona persona = personaRepository.findById(rut)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        log.info("Persona encontrada con RUT: {}", rut);
        return toDto(persona);
    }

    @Override
    public PersonaResponseDto update(String rut, PersonaRequestDto dto) {
        log.info("Actualizando persona con RUT: {}", rut);
        Persona persona = personaRepository.findById(rut)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        persona.setDv(dto.getDv());
        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());
        persona.setFechaNacimiento(dto.getFechaNacimiento());

        EstadoCivil estadoCivil = estadoCivilRepository.findById(dto.getIdEstadoCivil())
                .orElseThrow(() -> new RuntimeException("Estado civil no encontrado"));
        persona.setEstadoCivil(estadoCivil);

        Persona updated = personaRepository.save(persona);
        log.info("Persona actualizada exitosamente con RUT: {}-{}", updated.getRut(), updated.getDv());
        return toDto(updated);
    }

    @Override
    public void delete(String rut) {
        log.info("Eliminando persona con RUT: {}", rut);
        Persona persona = personaRepository.findById(rut)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        personaRepository.delete(persona);
        log.info("Persona eliminada exitosamente con RUT: {}", rut);
    }

    //métodos auxiliares

    private Persona toEntity(PersonaRequestDto dto) {
        EstadoCivil estadoCivil = estadoCivilRepository.findById(dto.getIdEstadoCivil())
                .orElseThrow(() -> new RuntimeException("Estado civil no encontrado"));

        Persona persona = new Persona();
        persona.setRut(dto.getRut());
        persona.setDv(dto.getDv());
        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());
        persona.setFechaNacimiento(dto.getFechaNacimiento());
        persona.setEstadoCivil(estadoCivil);

        return persona;
    }

    private PersonaResponseDto toDto(Persona persona) {
        PersonaResponseDto response = new PersonaResponseDto();
        response.setRut(persona.getRut());
        response.setDv(persona.getDv());
        response.setNombre(persona.getNombre());
        response.setApellido(persona.getApellido());
        response.setFechaNacimiento(persona.getFechaNacimiento());
        response.setEstadoCivil(persona.getEstadoCivil().getEstadoCivil()); // solo el nombre

        return response;
    }
}


