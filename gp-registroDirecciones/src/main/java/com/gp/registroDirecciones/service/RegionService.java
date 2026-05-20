package com.gp.registroDirecciones.service;

import com.gp.registroDirecciones.dto.RegionResponseDto;

import java.util.List;

public interface RegionService {
    List<RegionResponseDto> findAll();
    RegionResponseDto findById(Integer id);
}
