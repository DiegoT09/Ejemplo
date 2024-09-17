package com.upc.pruebapc.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private String escuela;

    //Relaciones
    @OneToMany(mappedBy = "docente",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Curso> cursos;

    public Docente(String nombre, String direccion, String escuela) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.escuela = escuela;
    }
}
