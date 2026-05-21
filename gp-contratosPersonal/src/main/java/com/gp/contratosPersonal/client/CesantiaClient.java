package com.gp.contratosPersonal.client;

import com.gp.contratosPersonal.dto.CesantiaResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cesantia-service", url = "http://localhost:8083/api/cesantia")
public interface CesantiaClient {

    @GetMapping("/{id}")
    CesantiaResponseDto getSeguroCesantia(@PathVariable("id") Integer id);
}
