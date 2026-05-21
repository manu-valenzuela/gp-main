package com.gp.contratosPersonal.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ContratoResponseDto {

    private Integer id;

    private String rut;
    private String dv;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String estadoCivil;

    private String afpNombre;
    private BigDecimal afpPorcentaje;

    private String isapreNombre;
    private BigDecimal isaprePorcentaje;

    private String tipoContrato;

    private BigDecimal cotizacionCesantia;

    private String direccionCompleta;

    private String faenaNombre;
    private String faenaDescripcion;

    private BigDecimal salario;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
