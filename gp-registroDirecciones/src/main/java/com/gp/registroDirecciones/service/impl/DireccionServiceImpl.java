package com.gp.registroDirecciones.service.impl;

import com.gp.registroDirecciones.dto.DireccionRequestDto;
import com.gp.registroDirecciones.dto.DireccionResponseDto;
import com.gp.registroDirecciones.model.Comuna;
import com.gp.registroDirecciones.model.Direccion;
import com.gp.registroDirecciones.repository.ComunaRepository;
import com.gp.registroDirecciones.repository.DireccionRepository;
import com.gp.registroDirecciones.service.DireccionService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DireccionServiceImpl implements DireccionService {

    private static final Logger logger = LoggerFactory.getLogger(DireccionServiceImpl.class);

    private final DireccionRepository direccionRepository;
    private final ComunaRepository comunaRepository;

    public DireccionServiceImpl(DireccionRepository direccionRepository, ComunaRepository comunaRepository) {
        this.direccionRepository = direccionRepository;
        this.comunaRepository = comunaRepository;
    }

    @Override
    public List<DireccionResponseDto> findAll() {
        logger.info("Buscando todas las direcciones");
        return direccionRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DireccionResponseDto findById(Long id) {
        logger.info("Buscando dirección con id {}", id);
        Direccion direccion = direccionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dirección no encontrada con id " + id));
        return toResponseDTO(direccion);
    }

    @Override
    public DireccionResponseDto create(DireccionRequestDto request) {
        logger.info("Creando nueva dirección: {} {}", request.getCalle(), request.getNumero());
        Comuna comuna = comunaRepository.findById(request.getIdComuna())
                .orElseThrow(() -> new EntityNotFoundException("Comuna no encontrada con id " + request.getIdComuna()));

        Direccion direccion = new Direccion();
        direccion.setCalle(request.getCalle());
        direccion.setNumero(request.getNumero());
        direccion.setComuna(comuna);

        Direccion nueva = direccionRepository.save(direccion);
        return toResponseDTO(nueva);
    }

    @Override
    public DireccionResponseDto update(Long id, DireccionRequestDto request) {
        logger.info("Actualizando dirección con id {}", id);
        Direccion direccion = direccionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dirección no encontrada con id " + id));

        Comuna comuna = comunaRepository.findById(request.getIdComuna())
                .orElseThrow(() -> new EntityNotFoundException("Comuna no encontrada con id " + request.getIdComuna()));

        direccion.setCalle(request.getCalle());
        direccion.setNumero(request.getNumero());
        direccion.setComuna(comuna);

        Direccion actualizada = direccionRepository.save(direccion);
        return toResponseDTO(actualizada);
    }

    @Override
    public void delete(Long id) {
        logger.info("Eliminando dirección con id {}", id);
        if (!direccionRepository.existsById(id)) {
            throw new EntityNotFoundException("Dirección no encontrada con id " + id);
        }
        direccionRepository.deleteById(id);
    }

    private DireccionResponseDto toResponseDTO(Direccion direccion) {
        return new DireccionResponseDto(
                direccion.getId(),
                direccion.getCalle(),
                direccion.getNumero(),
                direccion.getComuna().getNombreComuna(),
                direccion.getComuna().getRegion().getNombreRegion()
        );
    }
}
