package com.upc.pruebapc.service;

import com.upc.pruebapc.dto.CantidadCursosPorDocentesDto;
import com.upc.pruebapc.dto.CursoDto;
import com.upc.pruebapc.model.Curso;
import com.upc.pruebapc.model.Docente;
import com.upc.pruebapc.repository.CursoRepository;
import com.upc.pruebapc.repository.DocenteRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {
    final CursoRepository cursoRepository;
    final DocenteRepository docenteRepository;

    public CursoService(CursoRepository cursoRepository, DocenteRepository docenteRepository) {
        this.cursoRepository = cursoRepository;
        this.docenteRepository = docenteRepository;
    }

    public CursoDto save(CursoDto cursoDto) {
        ModelMapper modelMapper = new ModelMapper();
        Curso curso = modelMapper.map(cursoDto, Curso.class);
        Docente docente = docenteRepository.findById(cursoDto.getIdDocente()).orElse(null);
        curso.setDocente(docente);
        curso = cursoRepository.save(curso);
        modelMapper.map(curso, cursoDto);
        cursoDto.setIdDocente(curso.getDocente().getId());
        return cursoDto;
    }

    public List<CantidadCursosPorDocentesDto> CursosPorDocenteCiclo2() {
        List<Tuple> tuplas = cursoRepository.CursosDictadosPorDocentes();
        List<CantidadCursosPorDocentesDto> listaDto = new ArrayList<>();
        for (Tuple tupla : tuplas) {
            CantidadCursosPorDocentesDto dto = new CantidadCursosPorDocentesDto(
                    tupla.get("nombreDocente", String.class),
                    tupla.get("cantidadCursos", Long.class)
            );
            listaDto.add(dto);
        }
        return listaDto;
    }

    public List<CantidadCursosPorDocentesDto> CursosPorDocenteSem202301() {
        List<Tuple> tuplas = docenteRepository.CantidadCursosPorDocente();
                List<CantidadCursosPorDocentesDto> listaDto = new ArrayList<>();
        for (Tuple tupla : tuplas) {
            CantidadCursosPorDocentesDto dto = new CantidadCursosPorDocentesDto(
                    tupla.get("nombreDocente", String.class),
                    tupla.get("cantidadCursos", Long.class)
            );
            listaDto.add(dto);
        }
        return listaDto;
    }

}
