package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.modelo.Estudiante;
import com.sistemaNotas.Notas.modelo.Profesor;
import com.sistemaNotas.Notas.modelo.Usuario;
import com.sistemaNotas.Notas.repositorio.EstudianteRepositorio;
import com.sistemaNotas.Notas.repositorio.ProfesorRepositorio;
import com.sistemaNotas.Notas.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
@Service
public class UsuarioServicio implements IUsuarioServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Autowired
    private ProfesorRepositorio profesorRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> listarUsuario() {
       return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario buscarEmpeladoPorId(Long idUsuario) {
        Usuario usuario = usuarioRepositorio.findById(idUsuario).orElse(null);
        return usuario;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioRepositorio.delete(usuario);
    }

    public Estudiante registroEstudiante(String nombre, String apellido, String correo, String contrasena, int tipo_usuario) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setCorreo(correo);
        estudiante.setTipo_usuario(1);
        estudiante.setContrasena(passwordEncoder.encode(contrasena));
        return estudianteRepositorio.save(estudiante);
    }

    @Override
    public Profesor registroProfesor(String nombre, String apellido, String correo, String contrasena, int tipo_usuario) {
        Profesor profesor = new Profesor();
        profesor.setNombre(nombre);
        profesor.setApellido(apellido);
        profesor.setCorreo(correo);
        profesor.setContrasena(passwordEncoder.encode(contrasena));
        profesor.setTipo_usuario(2);
        return profesorRepositorio.save(profesor);
    }
}
