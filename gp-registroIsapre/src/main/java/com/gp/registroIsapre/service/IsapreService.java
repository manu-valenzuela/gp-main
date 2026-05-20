package com.gp.registroIsapre.service;

import com.gp.registroIsapre.dto.IsapreResponseDto;
import java.util.List;

public interface IsapreService {
    List<IsapreResponseDto> findAll();
    IsapreResponseDto findById(int id);
}
