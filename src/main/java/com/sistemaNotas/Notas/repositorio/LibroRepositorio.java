package com.sistemaNotas.Notas.repositorio;

import com.sistemaNotas.Notas.modelo.Estudiante;
import com.sistemaNotas.Notas.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LibroRepositorio extends JpaRepository<Libro, Integer> {
}

