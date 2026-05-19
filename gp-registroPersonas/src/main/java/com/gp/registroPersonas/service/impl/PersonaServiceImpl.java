package com.gp.registroPersonas.service.impl;

import com.gp.registroPersonas.dto.EstadoCivilResponseDto;
import com.gp.registroPersonas.dto.PersonaResponseDto;
import com.gp.registroPersonas.model.EstadoCivil;
import com.gp.registroPersonas.model.Persona;
import com.gp.registroPersonas.repository.PersonaRepository;
import com.gp.registroPersonas.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository repository;

    PersonaResponseDto toDto(Persona entity) {
        return new PersonaResponseDto(
                entity.getRut(),
                entity.getDv(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getFechaNacimiento(),
                toDto(entity.getEstadoCivil())
        );
    }

    EstadoCivilResponseDto toDto(EstadoCivil entity) {
        return new EstadoCivilResponseDto(
                entity.getId(),
                entity.getEstadoCivil()
        );
    }

    @Override
    public List<PersonaResponseDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public PersonaResponseDto findById(String rut) {
        return repository.findById(rut).map(this::toDto).orElse(null);
    }
}
