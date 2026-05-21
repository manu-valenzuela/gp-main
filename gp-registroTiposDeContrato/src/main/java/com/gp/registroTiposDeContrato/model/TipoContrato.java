package com.gp.registroTiposDeContrato.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tipos_contrato")
@Data
public class TipoContrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;
}
