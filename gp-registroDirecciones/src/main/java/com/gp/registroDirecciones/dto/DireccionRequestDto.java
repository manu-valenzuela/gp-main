package com.gp.registroDirecciones.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionRequestDto {

    @NotBlank(message = "La calle no puede estar vacía")
    private String calle;

    @Min(value = 1, message = "El número debe ser mayor a 0")
    private long numero;

    @NotNull(message = "Debe especificar la comuna")
    private int idComuna;
}
