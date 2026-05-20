package com.gp.registroSeguroCesantia.dto;

import lombok.*;
import jakarta.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SeguroCesantiaResponseDto {

    @NotNull(message = "El ID del seguro no puede ser nulo")
    private int idSeguro;

    @NotNull(message = "El nombre del seguro no puede ser nulo")
    private String nombreSeguro;

    @NotNull(message = "El porcentaje de cotización no puede ser nulo")
    private Double porcentajeCotizacion;
}
