package com.gp.registroTiposDeContrato.service.impl;

import com.gp.registroTiposDeContrato.dto.TipoContratoResponseDto;
import com.gp.registroTiposDeContrato.model.TipoContrato;
import com.gp.registroTiposDeContrato.repository.TipoContratoRepository;
import com.gp.registroTiposDeContrato.service.TipoContratoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TipoContratoServiceImpl implements TipoContratoService {

    private final TipoContratoRepository tipoContratoRepository;

    public TipoContratoServiceImpl(TipoContratoRepository tipoContratoRepository) {
        this.tipoContratoRepository = tipoContratoRepository;
    }

    private TipoContratoResponseDto toDto(TipoContrato contrato) {
        TipoContratoResponseDto dto = new TipoContratoResponseDto();
        dto.setId(contrato.getId());
        dto.setNombre(contrato.getNombre());
        return dto;
    }

    @Override
    public List<TipoContratoResponseDto> findAll() {
        log.info("Consultando todos los tipos de contrato");
        List<TipoContrato> contratos = tipoContratoRepository.findAll();
        log.info("Se encontraron {} tipos de contrato", contratos.size());
        return contratos.stream().map(this::toDto).toList();
    }

    @Override
    public TipoContratoResponseDto findById(Integer id) {
        log.info("Consultando tipo de contrato con ID: {}", id);
        TipoContrato contrato = tipoContratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de contrato no encontrado"));
        log.info("Tipo de contrato encontrado con ID: {}", id);
        return toDto(contrato);
    }

}
