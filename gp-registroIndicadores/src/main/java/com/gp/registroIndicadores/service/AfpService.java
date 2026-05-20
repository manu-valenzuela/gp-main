package com.gp.registroIndicadores.service;

import com.gp.registroIndicadores.dto.AfpResponseDto;
import java.util.List;

public interface AfpService {
    List<AfpResponseDto> findAll();
    AfpResponseDto findById(int id);
}
