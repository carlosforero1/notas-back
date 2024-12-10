package com.sistemaNotas.Notas.repositorio;

import com.sistemaNotas.Notas.modelo.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositorio extends JpaRepository<Rol, Long> {
    Rol findByNombre(String nombre);
}