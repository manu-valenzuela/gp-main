package com.gp.registroIndicadores.controller;

import com.gp.registroIndicadores.dto.AfpResponseDto;
import com.gp.registroIndicadores.service.AfpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/afp")
@RequiredArgsConstructor
@Slf4j
public class AfpController {

    private final AfpService afpService;

    @GetMapping
    public List<AfpResponseDto> getAllAfp() {
        log.info("Consultando todas las AFPs");
        return afpService.findAll();
    }

    @GetMapping("/{id}")
    public AfpResponseDto getAfpById(@PathVariable int id) {
        log.info("Consultando AFP con ID: {}", id);
        return afpService.findById(id);
    }
}
