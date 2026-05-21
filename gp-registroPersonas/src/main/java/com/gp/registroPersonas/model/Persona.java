package com.gp.registroPersonas.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Persona {

    @Id
    @Column(length = 8, nullable = false)
    private String rut;
    @Column(length = 1, nullable = false)
    private String dv;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String apellido;
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_estado_civil", referencedColumnName = "idEstadoCivil")
    private EstadoCivil estadoCivil;


}
