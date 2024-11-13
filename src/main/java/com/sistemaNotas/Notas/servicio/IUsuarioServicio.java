package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.modelo.Estudiante;
import com.sistemaNotas.Notas.modelo.Profesor;
import com.sistemaNotas.Notas.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    public List<Usuario> listarUsuario();

    public Usuario buscarEmpeladoPorId(Long idUsuario);

    public Usuario guardarUsuario(Usuario usuario);

    public void eliminarUsuario(Usuario usuario);

    public Estudiante registroEstudiante(String nombre, String apellido, String correo, String contrasena, int tipo_usuario);

    public Profesor registroProfesor(String nombre, String apellido, String correo, String contrasena, int tipo_usuario);
}
