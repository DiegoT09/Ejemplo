package com.upc.pruebapc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocenteDto {
    private Long id;
    private String nombre;
    private String direccion;
    private String escuela;
}
