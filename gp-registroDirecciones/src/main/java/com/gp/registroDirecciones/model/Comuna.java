package com.gp.registroDirecciones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Comuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comuna")
    private int id;
    @Column(name = "nombre_comuna")
    private String nombreComuna;

    @ManyToOne
    @JoinColumn(name = "id_region")
    private Region region;

}
