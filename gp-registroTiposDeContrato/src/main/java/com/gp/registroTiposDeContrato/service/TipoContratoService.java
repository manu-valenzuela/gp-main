package com.gp.registroTiposDeContrato.service;

import com.gp.registroTiposDeContrato.dto.TipoContratoResponseDto;
import java.util.List;

public interface TipoContratoService {
    List<TipoContratoResponseDto> findAll();
    TipoContratoResponseDto findById(Integer id);
}
