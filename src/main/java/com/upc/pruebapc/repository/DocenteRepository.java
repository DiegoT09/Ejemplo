package com.upc.pruebapc.repository;

import com.upc.pruebapc.model.Docente;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Cantidad de Cursos en el Semestre02
public interface DocenteRepository extends JpaRepository<Docente, Long> {
    @Query(value = "select d.nombre AS nombreDocente, count(c.id) AS cantidadCursos from curso c " +
            "join docente d ON c.id_docente = d.id where c.semestre = 202301 group by d.nombre" , nativeQuery = true)


            /*"SELECT d.nombre AS nombreDocente, COUNT(c.id) AS cantidadCursos " +
            "FROM curso c " +
            "JOIN docente d ON c.id_docente = d.id " +
            "WHERE c.semestre = 202301 " +
            "GROUP BY d.nombre", nativeQuery = true)*/
    List<Tuple> CantidadCursosPorDocente();

}
