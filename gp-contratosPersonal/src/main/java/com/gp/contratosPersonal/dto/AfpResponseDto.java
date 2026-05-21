// AfpResponseDto
package com.gp.contratosPersonal.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class AfpResponseDto {
    private String nombre;
    private BigDecimal porcentaje;
}
