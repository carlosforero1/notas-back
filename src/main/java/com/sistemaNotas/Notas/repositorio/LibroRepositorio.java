package com.sistemaNotas.Notas.repositorio;

import com.sistemaNotas.Notas.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Integer> {
}

