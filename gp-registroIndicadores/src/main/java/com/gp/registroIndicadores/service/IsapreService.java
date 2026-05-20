package com.gp.registroIndicadores.service;

import com.gp.registroIndicadores.dto.IsapreResponseDto;
import java.util.List;

public interface IsapreService {
    List<IsapreResponseDto> findAll();
    IsapreResponseDto findById(int id);
}
