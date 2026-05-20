package com.gp.registroSeguroCesantia.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seguro_cesantia_trabajador")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class SeguroCesantia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSeguro;

    @Column(nullable = false, unique = true, length = 100)
    private String nombreSeguro;

    @Column(nullable = false, precision = 5, scale = 2)
    private Double porcentajeCotizacion;
}
