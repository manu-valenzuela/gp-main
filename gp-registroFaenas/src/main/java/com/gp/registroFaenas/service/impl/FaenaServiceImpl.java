package com.gp.registroFaenas.service.impl;

import com.gp.registroFaenas.client.DireccionClient;
import com.gp.registroFaenas.dto.FaenaRequestDto;
import com.gp.registroFaenas.dto.FaenaResponseDto;
import com.gp.registroFaenas.model.Faena;
import com.gp.registroFaenas.repository.FaenaRepository;
import com.gp.registroFaenas.service.FaenaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FaenaServiceImpl implements FaenaService {

    private final FaenaRepository faenaRepository;
    private final DireccionClient direccionClient; // conexiónFeignClient

    public FaenaServiceImpl(FaenaRepository faenaRepository, DireccionClient direccionClient) {
        this.faenaRepository = faenaRepository;
        this.direccionClient = direccionClient;
    }

    private FaenaResponseDto toDto(Faena faena) {
        FaenaResponseDto dto = new FaenaResponseDto();
        dto.setId(faena.getId());
        dto.setNombre(faena.getNombre());
        dto.setDescripcion(faena.getDescripcion());
        dto.setFechaInicio(faena.getFechaInicio());
        dto.setFechaFin(faena.getFechaFin());
        dto.setIdDireccion(faena.getIdDireccion());

        String direccionCompleta = direccionClient.getDireccionCompleta(faena.getIdDireccion());
        dto.setDireccionCompleta(direccionCompleta);

        return dto;
    }

    @Override
    public FaenaResponseDto create(FaenaRequestDto dto) {
        log.info("Creando nueva faena: {}", dto.getNombre());

        Faena faena = new Faena();
        faena.setNombre(dto.getNombre());
        faena.setDescripcion(dto.getDescripcion());
        faena.setFechaInicio(dto.getFechaInicio());
        faena.setFechaFin(dto.getFechaFin());
        faena.setIdDireccion(dto.getIdDireccion());

        Faena saved = faenaRepository.save(faena);
        log.info("Faena creada exitosamente con ID: {}", saved.getId());

        return toDto(saved);
    }

    @Override
    public List<FaenaResponseDto> findAll() {
        log.info("Consultando todas las faenas");
        List<Faena> faenas = faenaRepository.findAll();
        log.info("Se encontraron {} faenas", faenas.size());
        return faenas.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FaenaResponseDto findById(Integer id) {
        log.info("Consultando faena con ID: {}", id);
        Faena faena = faenaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faena no encontrada"));
        log.info("Faena encontrada con ID: {}", id);
        return toDto(faena);
    }

    @Override
    public void delete(Integer id) {
        log.info("Eliminando faena con ID: {}", id);
        if (!faenaRepository.existsById(id)) {
            throw new RuntimeException("Faena no encontrada");
        }
        faenaRepository.deleteById(id);
        log.info("Faena eliminada exitosamente con ID: {}", id);
    }

}
