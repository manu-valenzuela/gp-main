package com.gp.registroDirecciones.service;

import com.gp.registroDirecciones.dto.DireccionRequestDto;
import com.gp.registroDirecciones.dto.DireccionResponseDto;

import java.util.List;

public interface DireccionService {
    List<DireccionResponseDto> findAll();
    DireccionResponseDto findById(Long id);
    DireccionResponseDto create(DireccionRequestDto request);
    DireccionResponseDto update(Long id, DireccionRequestDto request);
    void delete(Long id);
}
