package com.gp.registroPersonas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonaRequestDto {

    @NotBlank(message = "El RUT no puede estar vacío")
    @Size(min = 7, max = 8, message = "El RUT debe tener entre 7 y 8 dígitos")
    private String rut;

    @NotBlank(message = "El dígito verificador no puede estar vacío")
    @Size(min = 1, max = 1, message = "El dígito verificador debe tener un carácter")
    private String dv;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 50, message = "El apellido no puede superar los 50 caracteres")
    private String apellido;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    private LocalDate fechaNacimiento;

    @NotNull(message = "El estado civil no puede ser nulo")
    private Integer idEstadoCivil; // se recibe el ID de la tabla estado_civil
}
