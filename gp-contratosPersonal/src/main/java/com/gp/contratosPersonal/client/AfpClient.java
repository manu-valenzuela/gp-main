package com.gp.contratosPersonal.client;

import com.gp.registroAfp.dto.AfpResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "afp-service", url = "http://localhost:8081/api/afp")
public interface AfpClient {

    @GetMapping("/{id}")
    AfpResponseDto getAfp(@PathVariable("id") Integer id);
}
