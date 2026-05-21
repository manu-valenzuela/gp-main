package com.gp.contratosPersonal.client;

import com.gp.contratosPersonal.dto.DireccionResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "direccion-service", url = "http://localhost:8085/api/direcciones")
public interface DireccionClient {

    @GetMapping("/{id}")
    DireccionResponseDto getDireccion(@PathVariable("id") Integer id);
}
