package com.sistemaNotas.Notas.repositorio;

import com.sistemaNotas.Notas.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
     Usuario findByNombreUsuario(String nombreUsuario);
     Usuario findByCorreo(String correo);
     Usuario findById(int id);

}
