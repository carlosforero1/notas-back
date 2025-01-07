package com.sistemaNotas.Notas.repositorio;

import com.sistemaNotas.Notas.modelo.Curso;
import com.sistemaNotas.Notas.modelo.InscripcionEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Long> {
}
