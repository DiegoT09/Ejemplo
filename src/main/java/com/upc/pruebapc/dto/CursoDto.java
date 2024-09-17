package com.upc.pruebapc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDto {
    private Long id;
    private String nombre;
    private String tipo;
    private Integer ciclo;
    private Integer creditos;
    private Integer semestre;
    private Long idDocente;
}
