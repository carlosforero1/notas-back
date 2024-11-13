package com.sistemaNotas.Notas.repositorio;

import com.sistemaNotas.Notas.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
     Usuario findByNombreUsuario(String nombreUsuario);

}
