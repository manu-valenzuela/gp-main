package com.gp.registroPersonas.service;

import com.gp.registroPersonas.dto.PersonaRequestDto;
import com.gp.registroPersonas.dto.PersonaResponseDto;
import com.gp.registroPersonas.model.Persona;

import java.util.List;

public interface PersonaService {
    PersonaResponseDto create(PersonaRequestDto dto);

    List<PersonaResponseDto> findAll();

    PersonaResponseDto findById(String rut);

    PersonaResponseDto update(String rut, PersonaRequestDto dto);

    void delete(String rut);
}
