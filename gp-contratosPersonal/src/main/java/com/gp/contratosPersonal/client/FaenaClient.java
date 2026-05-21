package com.gp.contratosPersonal.client;

import com.gp.contratosPersonal.dto.FaenaResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "faenas-service", url = "http://localhost:8087/api/faenas")
public interface FaenaClient {

    @GetMapping("/{id}")
    FaenaResponseDto getFaena(@PathVariable("id") Integer id);
}
