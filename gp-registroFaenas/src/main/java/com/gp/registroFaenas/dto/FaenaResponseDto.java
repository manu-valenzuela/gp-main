package com.gp.registroFaenas.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FaenaResponseDto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer idDireccion;
    private String direccionCompleta; // obtenido vía microservicio de direcciones
}
