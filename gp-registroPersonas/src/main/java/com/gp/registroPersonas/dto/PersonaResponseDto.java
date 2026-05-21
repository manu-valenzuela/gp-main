package com.gp.registroPersonas.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PersonaResponseDto {

    private String rut;
    private String dv;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    private String estadoCivil;
}

