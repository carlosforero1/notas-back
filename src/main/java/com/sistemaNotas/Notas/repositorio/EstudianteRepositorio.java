package com.sistemaNotas.Notas.repositorio;

import com.sistemaNotas.Notas.modelo.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {
}
