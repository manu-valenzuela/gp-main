package com.gp.contratosPersonal.client;

import com.gp.contratosPersonal.dto.PersonaResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "personas-service", url = "http://localhost:8086/api/personas")
public interface PersonaClient {

    @GetMapping("/{id}")
    PersonaResponseDto getPersona(@PathVariable("id") Integer id);
}
