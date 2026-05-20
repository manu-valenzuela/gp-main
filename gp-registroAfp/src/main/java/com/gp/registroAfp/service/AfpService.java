package com.gp.registroAfp.service;

import com.gp.registroAfp.dto.AfpResponseDto;
import java.util.List;

public interface AfpService {
    List<AfpResponseDto> findAll();
    AfpResponseDto findById(int id);
}
