package com.gp.registroPersonas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PersonaResponseDto {
    @NotBlank
    private String rut;
    @NotBlank
    private String dv;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private Date fechaNacimiento;
    private EstadoCivilResponseDto estadoCivil;
}
