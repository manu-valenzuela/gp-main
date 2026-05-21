package com.gp.registroFaenas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "direccion-service", url = "http://localhost:8087/api/direcciones")
public interface DireccionClient {

    @GetMapping("/{id}")
    String getDireccionCompleta(@PathVariable("id") Integer id);
}
