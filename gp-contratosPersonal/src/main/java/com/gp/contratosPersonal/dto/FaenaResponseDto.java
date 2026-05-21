// FaenaResponseDto
package com.gp.contratosPersonal.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FaenaResponseDto {
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
