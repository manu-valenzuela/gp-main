package com.gp.contratosPersonal.client;

import com.gp.contratosPersonal.dto.TipoContratoResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "tipocontrato-service", url = "http://localhost:8084/api/tiposcontrato")
public interface TipoContratoClient {

    @GetMapping("/{id}")
    TipoContratoResponseDto getTipoContrato(@PathVariable("id") Integer id);
}
