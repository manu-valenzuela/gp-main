package com.gp.registroPersonas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class EstadoCivil {
    @Id
    private int id;
    @Column(name= "estado_civil")
    private String estadoCivil;
}
