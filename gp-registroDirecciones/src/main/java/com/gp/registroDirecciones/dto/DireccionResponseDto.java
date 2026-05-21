package com.gp.registroDirecciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionResponseDto {
    private Long idDireccion;
    private String calle;
    private Long numero;
    private String nombreComuna;
    private String nombreRegion;
}
