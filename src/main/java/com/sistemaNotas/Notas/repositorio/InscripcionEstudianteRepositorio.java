package com.sistemaNotas.Notas.repositorio;

import com.sistemaNotas.Notas.modelo.Estudiante;
import com.sistemaNotas.Notas.modelo.InscripcionEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionEstudianteRepositorio extends JpaRepository<InscripcionEstudiante, Long> {
    long countByEstudiante(Estudiante estudiante);
}
