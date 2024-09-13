package com.upc.ejpc1jpa.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private String publicoObjetivo;
    private Integer duracion;
    private LocalDate fechaPublicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agencia")
    private Agencia agencia; //AEA


    public Anuncio(String nombre, Double precio, String publicoObjetivo, Integer duracion, LocalDate fechaPublicacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.publicoObjetivo = publicoObjetivo;
        this.duracion = duracion;
        this.fechaPublicacion = fechaPublicacion;
        this.agencia =  agencia;
    }
}
