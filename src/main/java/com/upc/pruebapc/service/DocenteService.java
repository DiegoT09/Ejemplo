package com.upc.pruebapc.service;

import com.upc.pruebapc.dto.CantidadCursosPorDocentesDto;
import com.upc.pruebapc.dto.DocenteDto;
import com.upc.pruebapc.model.Docente;
import com.upc.pruebapc.repository.DocenteRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocenteService {
    final DocenteRepository docenteRepository;

    public DocenteService(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    public DocenteDto save(DocenteDto docenteDto) {
        ModelMapper modelMapper = new ModelMapper();
        Docente docente = modelMapper.map(docenteDto, Docente.class);
        docente = docenteRepository.save(docente);
        return modelMapper.map(docente, DocenteDto.class);
    }



}
