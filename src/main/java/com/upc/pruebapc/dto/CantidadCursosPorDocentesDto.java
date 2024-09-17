package com.upc.pruebapc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CantidadCursosPorDocentesDto {
    private String nombreDocente;
    private Long cantidadCursos;
}
