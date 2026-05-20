package com.gp.registroDirecciones.service;

import com.gp.registroDirecciones.dto.DireccionResponseDto;

import java.util.List;

public interface DireccionService {
    List<DireccionResponseDto> findAll();
    DireccionResponseDto findById(Long id);
}
