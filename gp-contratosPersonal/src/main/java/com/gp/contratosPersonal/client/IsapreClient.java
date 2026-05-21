package com.gp.contratosPersonal.client;

import com.gp.contratosPersonal.dto.IsapreResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "isapres-service", url = "http://localhost:8082/api/isapres")
public interface IsapreClient {

    @GetMapping("/{id}")
    IsapreResponseDto getIsapre(@PathVariable("id") Integer id);
}
