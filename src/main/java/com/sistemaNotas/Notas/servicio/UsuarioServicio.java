package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.Excepciones.ResourceNotFoundException;
import com.sistemaNotas.Notas.modelo.Usuario;
import com.sistemaNotas.Notas.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class UsuarioServicio implements IUsuarioServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarUsuario(long id) {
        usuarioRepositorio.deleteById(id);
    }

    @Override
    public Usuario actualizarUsuario(long id, Usuario usuario) {
            Usuario usuarioExistente = usuarioRepositorio.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el ID: " + id));
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setApellido(usuario.getApellido());
            usuarioExistente.setCorreo(usuario.getCorreo());
            usuarioExistente.setCodigo(usuario.getCodigo());
            usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
            usuarioExistente.setActivo(usuario.isActivo());
            usuarioExistente.setRol(usuario.getRol());
        return usuarioRepositorio.save(usuarioExistente);

    }
}

