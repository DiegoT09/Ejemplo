package com.upc.pruebapc.controller;

import com.upc.pruebapc.dto.CantidadCursosPorDocentesDto;
import com.upc.pruebapc.dto.CursoDto;
import com.upc.pruebapc.dto.DocenteDto;
import com.upc.pruebapc.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Curso")
public class CursoController {
    final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    @PostMapping
    public ResponseEntity<CursoDto> create(@RequestBody CursoDto cursoDto) {
        return new ResponseEntity<>(cursoService.save(cursoDto), HttpStatus.CREATED);
    }

    @GetMapping("/cursos-ciclo2")
    public ResponseEntity<List<CantidadCursosPorDocentesDto>> getCursosPorDocenteCiclo2() {
        return ResponseEntity.ok(cursoService.CursosPorDocenteCiclo2());
    }

    @GetMapping("/cursos-semestre")
    public ResponseEntity<List<CantidadCursosPorDocentesDto>> getCursosPorDocenteSemestre202301() {
        return ResponseEntity.ok(cursoService.CursosPorDocenteSem202301());
    }

}
