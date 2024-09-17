package com.upc.pruebapc.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String tipo;
    private Integer ciclo;
    private Integer creditos;
    private Integer semestre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDocente")
    private Docente docente;

    public Curso(String nombre, String tipo, Integer ciclo, Integer creditos, Integer semestre, Docente docente) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ciclo = ciclo;
        this.creditos = creditos;
        this.semestre = semestre;
        this.docente = docente;
    }
}
