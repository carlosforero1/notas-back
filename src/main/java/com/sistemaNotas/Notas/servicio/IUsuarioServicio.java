package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.modelo.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUsuarioServicio {
    List<Usuario> listarUsuario();

    Usuario guardarUsuario(Usuario usuario);

    Usuario buscarUsuarioPorId(Long id);

    void eliminarUsuario(long usuario);

    Usuario actualizarUsuario(long id, Usuario usuario);
}
