package com.gp.registroDirecciones.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Region {

    @Id
    @Column(name = "id_region")
    private int id;
    @Column(name = "nombre_region")
    private String nombreRegion;

}
