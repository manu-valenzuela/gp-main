package com.gp.registroIndicadores.dto;

import lombok.*;
import jakarta.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class IsapreResponseDto {

    @NotNull(message = "El ID de la Isapre no puede ser nulo")
    private int idIsapre;

    @NotNull(message = "El nombre de la Isapre no puede ser nulo")
    private String nombreIsapre;

    @NotNull(message = "El porcentaje de cotización no puede ser nulo")
    private Double porcentajeCotizacion;
}
