// PersonaResponseDto
package com.gp.contratosPersonal.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PersonaResponseDto {
    private String rut;
    private String dv;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String estadoCivil;
}
