package com.gp.registroDirecciones.service;

import com.gp.registroDirecciones.dto.ComunaResponseDto;

import java.util.List;

public interface ComunaService {
    List<ComunaResponseDto> findAll();
    ComunaResponseDto findById(Integer id);
}
