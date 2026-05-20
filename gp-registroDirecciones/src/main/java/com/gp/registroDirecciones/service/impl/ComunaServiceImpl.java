package com.gp.registroDirecciones.service.impl;

import com.gp.registroDirecciones.dto.ComunaResponseDto;
import com.gp.registroDirecciones.dto.RegionResponseDto;
import com.gp.registroDirecciones.model.Comuna;
import com.gp.registroDirecciones.model.Region;
import com.gp.registroDirecciones.repository.ComunaRepository;
import com.gp.registroDirecciones.service.ComunaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComunaServiceImpl implements ComunaService {

    private final ComunaRepository repository;

    ComunaResponseDto toDto(Comuna entity) {
        return new ComunaResponseDto(
                entity.getId(),
                entity.getNombreComuna(),
                toDto(entity.getRegion())
        );
    }

    Comuna toEntity(ComunaResponseDto dto) {
        return new Comuna(
                dto.getId(),
                dto.getNombre(),
                toEntity(dto.getRegion())
        );
    }

    RegionResponseDto toDto(Region entity) {
        return new RegionResponseDto(
                entity.getId(),
                entity.getNombreRegion()
        );
    }

    Region toEntity(RegionResponseDto dto) {
        return new Region(
                dto.getId(),
                dto.getNombreRegion()
        );
    }

    @Override
    public List<ComunaResponseDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public ComunaResponseDto findById(Integer id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }
}
