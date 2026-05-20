package com.gp.registroIndicadores.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "afp")
@Data
public class Afp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAfp;

    @Column(nullable = false, unique = true, length = 100)
    private String nombreAfp;

    @Column(nullable = false, precision = 5, scale = 2)
    private Double porcentajeCotizacion;
}
