package com.gp.registroPersonas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class EstadoCivilResponseDto {
    @NotNull
    private Integer id;
    @NotBlank
    private String estadoCivil;
}

