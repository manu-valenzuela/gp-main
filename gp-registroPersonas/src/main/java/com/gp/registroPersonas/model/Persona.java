package com.gp.registroPersonas.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Persona {
    @Id
    private long rut;
    private int dv;
    private String nombre;
    private String apellido;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @ManyToOne
    @JoinColumn(name = "id_estado_civil")
    private EstadoCivil estadoCivil;


}
