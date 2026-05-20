package com.gp.registroIndicadores.service;

import com.gp.registroIndicadores.dto.SeguroCesantiaResponseDto;
import java.util.List;

public interface SeguroCesantiaService {
    List<SeguroCesantiaResponseDto> findAll();
    SeguroCesantiaResponseDto findById(int id);
}
