package com.gp.registroPersonas.service;

import com.gp.registroPersonas.dto.EstadoCivilResponseDto;

import java.util.List;

public interface EstadoCivilService {
    List<EstadoCivilResponseDto> findAll();
    EstadoCivilResponseDto findByID(Integer id);
}
