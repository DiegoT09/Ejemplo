package com.upc.pruebapc.controller;

import com.upc.pruebapc.dto.DocenteDto;
import com.upc.pruebapc.service.DocenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Docente")
public class DocenteController {
    final DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @PostMapping
    public ResponseEntity<DocenteDto> create(@RequestBody DocenteDto docenteDto) {
        return new ResponseEntity<>(docenteService.save(docenteDto), HttpStatus.CREATED);
    }
}
