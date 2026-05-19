package com.gp.registroPersonas.service;

import com.gp.registroPersonas.dto.PersonaResponseDto;

import java.util.List;

public interface PersonaService {
    List<PersonaResponseDto> findAll();
    PersonaResponseDto findById(String rut);
}
