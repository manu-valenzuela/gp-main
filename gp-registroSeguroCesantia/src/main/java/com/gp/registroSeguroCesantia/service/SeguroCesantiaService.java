package com.gp.registroSeguroCesantia.service;

import com.gp.registroSeguroCesantia.dto.SeguroCesantiaResponseDto;
import java.util.List;

public interface SeguroCesantiaService {
    List<SeguroCesantiaResponseDto> findAll();
    SeguroCesantiaResponseDto findById(int id);
}
