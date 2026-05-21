package com.gp.registroIsapre.service.impl;

import com.gp.registroIsapre.dto.IsapreResponseDto;
import com.gp.registroIsapre.model.Isapre;
import com.gp.registroIsapre.repository.IsapreRepository;
import com.gp.registroIsapre.service.IsapreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IsapreServiceImpl implements IsapreService {

    private final IsapreRepository repository;

    private IsapreResponseDto toDto(Isapre isapre) {
        return new IsapreResponseDto(
                isapre.getIdIsapre(),
                isapre.getNombreIsapre(),
                isapre.getPorcentajeCotizacion()
        );
    }

    private Isapre toEntity(IsapreResponseDto dto) {
        Isapre isapre = new Isapre();
        isapre.setIdIsapre(dto.getIdIsapre());
        isapre.setNombreIsapre(dto.getNombreIsapre());
        isapre.setPorcentajeCotizacion(dto.getPorcentajeCotizacion());
        return isapre;
    }

    @Override
    public List<IsapreResponseDto> findAll() {
        log.info("Consultando todas las Isapres");
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public IsapreResponseDto findById(int id) {
        log.info("Consultando Isapre con ID: {}", id);
        return repository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Isapre no encontrada con ID: " + id));
    }
}
