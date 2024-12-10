package com.sistemaNotas.Notas.repositorio;

import com.sistemaNotas.Notas.modelo.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepositorio extends JpaRepository<Materia, Long> {
}
