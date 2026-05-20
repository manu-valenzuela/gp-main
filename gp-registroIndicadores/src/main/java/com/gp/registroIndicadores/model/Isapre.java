package com.gp.registroIndicadores.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "isapre")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Isapre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIsapre;

    @Column(nullable = false, unique = true, length = 100)
    private String nombreIsapre;

    @Column(nullable = false, precision = 5, scale = 2)
    private Double porcentajeCotizacion;
}
