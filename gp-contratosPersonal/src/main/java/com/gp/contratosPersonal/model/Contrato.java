package com.gp.contratosPersonal.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "contratos")
@Data
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Datos obtenidos con feignclient
    private Integer idPersona;
    private Integer idAfp;
    private Integer idIsapre;
    private Integer idTipoContrato;
    private Integer idSeguroCesantia;
    private Integer idDireccion;
    private Integer idFaena;

    //Salario (dato propio)
    @Column(nullable = false)
    private BigDecimal salario;

    //Fechas
    @Column(nullable = false)
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
