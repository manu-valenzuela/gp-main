package com.gp.registroDirecciones.service.impl;

import com.gp.registroDirecciones.dto.ComunaResponseDto;
import com.gp.registroDirecciones.dto.DireccionResponseDto;
import com.gp.registroDirecciones.dto.RegionResponseDto;
import com.gp.registroDirecciones.model.Comuna;
import com.gp.registroDirecciones.model.Direccion;
import com.gp.registroDirecciones.model.Region;
import com.gp.registroDirecciones.repository.DireccionRepository;
import com.gp.registroDirecciones.service.DireccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DireccionServiceImpl implements DireccionService {

    private final DireccionRepository repository;

    DireccionResponseDto toDto(Direccion entity) {
        return new DireccionResponseDto(
                entity.getId(),
                entity.getCalle(),
                entity.getNumero(),
                toDto(entity.getComuna()),
                toDto(entity.getRegion())
        );
    }

    Direccion toEntity(DireccionResponseDto dto) {
        return new Direccion(
                dto.getId(),
                dto.getCalle(),
                dto.getNumero(),
                toEntity(dto.getComuna()),
                toEntity(dto.getRegion())
        );
    }

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
    public List<DireccionResponseDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public DireccionResponseDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }
}
