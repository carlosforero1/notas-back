package com.sistemaNotas.Notas.repositorio;

import com.sistemaNotas.Notas.modelo.Materia;
import com.sistemaNotas.Notas.modelo.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepositorio  extends JpaRepository<Nota, Long> {
}
