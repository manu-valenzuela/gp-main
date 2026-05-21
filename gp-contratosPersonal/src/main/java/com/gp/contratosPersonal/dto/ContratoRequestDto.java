package com.gp.contratosPersonal.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ContratoRequestDto {

    @NotNull
    private Integer idPersona;
    @NotNull
    private Integer idAfp;
    @NotNull
    private Integer idIsapre;
    @NotNull
    private Integer idTipoContrato;
    @NotNull
    private Integer idSeguroCesantia;
    @NotNull
    private Integer idDireccion;
    @NotNull
    private Integer idFaena;
    @NotNull
    @Positive
    private BigDecimal salario;
    @NotNull
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
