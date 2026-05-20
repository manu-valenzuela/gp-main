package com.gp.registroDirecciones.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RegionResponseDto {

    @NotNull
    private int id;
    @NotBlank
    private String nombreRegion;
}
