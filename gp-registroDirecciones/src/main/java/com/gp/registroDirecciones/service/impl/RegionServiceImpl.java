package com.gp.registroDirecciones.service.impl;

import com.gp.registroDirecciones.dto.RegionResponseDto;
import com.gp.registroDirecciones.model.Region;
import com.gp.registroDirecciones.repository.RegionRepository;
import com.gp.registroDirecciones.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository repository;

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
    public List<RegionResponseDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public RegionResponseDto findById(Integer id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }
}
