package com.gp.registroIndicadores.service.impl;

import com.gp.registroIndicadores.dto.AfpResponseDto;
import com.gp.registroIndicadores.model.Afp;
import com.gp.registroIndicadores.repository.AfpRepository;
import com.gp.registroIndicadores.service.AfpService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AfpServiceImpl implements AfpService {

    private final AfpRepository repository;

    private AfpResponseDto toDto(Afp afp) {
        return new AfpResponseDto(
                afp.getIdAfp(),
                afp.getNombreAfp(),
                afp.getPorcentajeCotizacion()
        );
    }

    private Afp toEntity(AfpResponseDto dto) {
        Afp afp = new Afp();
        afp.setIdAfp(dto.getIdAfp());
        afp.setNombreAfp(dto.getNombreAfp());
        afp.setPorcentajeCotizacion(dto.getPorcentajeCotizacion());
        return afp;
    }

    @Override
    public List<AfpResponseDto> findAll() {
        log.info("Consultando todas las AFP");
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public AfpResponseDto findById(int id) {
        log.info("Consultando AFP por ID");
        return repository.findById(id).map(this::toDto).orElseThrow(() -> new EntityNotFoundException("AFP no encontrada con ID: " + id));
    }
}
