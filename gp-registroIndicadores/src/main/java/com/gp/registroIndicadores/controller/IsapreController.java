package com.gp.registroIndicadores.controller;

import com.gp.registroIndicadores.dto.IsapreResponseDto;
import com.gp.registroIndicadores.service.IsapreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/isapre")
@RequiredArgsConstructor
@Slf4j
public class IsapreController {

    private final IsapreService isapreService;

    @GetMapping
    public List<IsapreResponseDto> getAllIsapres() {
        log.info("Consultando todas las Isapres");
        return isapreService.findAll();
    }

    @GetMapping("/{id}")
    public IsapreResponseDto getIsapreById(@PathVariable int id) {
        log.info("Consultando Isapre con ID: {}", id);
        return isapreService.findById(id);
    }
}
