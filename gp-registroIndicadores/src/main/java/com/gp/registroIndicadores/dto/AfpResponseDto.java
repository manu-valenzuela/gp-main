package com.gp.registroIndicadores.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AfpResponseDto {

    @NotNull(message = "El ID de la AFP no puede ser nulo")
    private int idAfp;

    @NotNull(message = "El nombre de la AFP no puede ser nulo")
    private String nombreAfp;

    @NotNull(message = "El porcentaje de cotización no puede ser nulo")
    private Double porcentajeCotizacion;
}
