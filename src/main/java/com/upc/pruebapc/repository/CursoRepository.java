package com.upc.pruebapc.repository;

import com.upc.pruebapc.model.Curso;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Cantidad de Cursos del Ciclo 2
public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query(value = "SELECT d.nombre AS nombreDocente, COUNT(c.id) AS cantidadCursos " +
            "FROM curso c " +
            "JOIN docente d ON c.id_docente = d.id " +
            "WHERE c.ciclo = 2 " +
            "GROUP BY d.nombre", nativeQuery = true)
    List<Tuple> CursosDictadosPorDocentes();

}
