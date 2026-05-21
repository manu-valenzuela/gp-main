package com.gp.registroSeguroCesantia.service.impl;

import com.gp.registroSeguroCesantia.dto.SeguroCesantiaResponseDto;
import com.gp.registroSeguroCesantia.model.SeguroCesantia;
import com.gp.registroSeguroCesantia.repository.SeguroCesantiaRepository;
import com.gp.registroSeguroCesantia.service.SeguroCesantiaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SeguroCesantiaServiceImpl implements SeguroCesantiaService {

    private final SeguroCesantiaRepository repository;

    private SeguroCesantiaResponseDto toDto(SeguroCesantia seguro) {
        return new SeguroCesantiaResponseDto(
                seguro.getIdSeguro(),
                seguro.getNombreSeguro(),
                seguro.getPorcentajeCotizacion()
        );
    }

    private SeguroCesantia toEntity(SeguroCesantiaResponseDto dto) {
        SeguroCesantia seguro = new SeguroCesantia();
        seguro.setIdSeguro(dto.getIdSeguro());
        seguro.setNombreSeguro(dto.getNombreSeguro());
        seguro.setPorcentajeCotizacion(dto.getPorcentajeCotizacion());
        return seguro;
    }

    @Override
    public List<SeguroCesantiaResponseDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public SeguroCesantiaResponseDto findById(int id) {
        log.info("Consultando porcentaje de cotización según id de contrato (1: indefinido; 2: definido) : {}", id);
        return repository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new EntityNotFoundException("No se han encontrado resultados para el id: " + id));
    }
}
