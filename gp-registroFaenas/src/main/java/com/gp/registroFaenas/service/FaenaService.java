package com.gp.registroFaenas.service;

import com.gp.registroFaenas.dto.FaenaRequestDto;
import com.gp.registroFaenas.dto.FaenaResponseDto;

import java.util.List;

public interface FaenaService {
    FaenaResponseDto create(FaenaRequestDto dto);

    List<FaenaResponseDto> findAll();

    FaenaResponseDto findById(Integer id);

    void delete(Integer id);
}
