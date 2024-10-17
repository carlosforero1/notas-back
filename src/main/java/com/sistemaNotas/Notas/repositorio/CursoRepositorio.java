package com.sistemaNotas.Notas.repositorio;

import com.sistemaNotas.Notas.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepositorio extends JpaRepository<Curso, Long> {
}
