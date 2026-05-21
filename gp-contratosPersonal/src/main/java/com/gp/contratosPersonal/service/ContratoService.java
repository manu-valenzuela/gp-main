package com.gp.contratosPersonal.service;

import com.gp.contratosPersonal.dto.ContratoRequestDto;
import com.gp.contratosPersonal.dto.ContratoResponseDto;

import java.util.List;

public interface ContratoService {

    ContratoResponseDto create(ContratoRequestDto dto);

    ContratoResponseDto findById(Integer id);

    List<ContratoResponseDto> findAll();

    void delete(Integer id);
}
