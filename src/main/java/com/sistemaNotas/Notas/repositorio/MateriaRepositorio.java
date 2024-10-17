package com.sistemaNotas.Notas.repositorio;

import com.sistemaNotas.Notas.modelo.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepositorio extends JpaRepository<Materia, Long> {
}
