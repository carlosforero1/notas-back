package com.sistemaNotas.Notas.repositorio;

import com.sistemaNotas.Notas.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepositorio extends JpaRepository<Profesor, Long> {
}
