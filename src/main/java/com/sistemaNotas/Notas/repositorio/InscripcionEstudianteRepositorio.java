package com.sistemaNotas.Notas.repositorio;

import com.sistemaNotas.Notas.modelo.InscripcionEstudiante;
import com.sistemaNotas.Notas.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionEstudianteRepositorio extends JpaRepository<InscripcionEstudiante, Long> {
    long countByEstudiante(Usuario estudiante);
}
