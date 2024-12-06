package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.modelo.Usuario;
import com.sistemaNotas.Notas.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String login(Usuario usuario) {
        Usuario existingUser = usuarioRepositorio.findByCorreo(usuario.getCorreo());
        if (existingUser != null && bCryptPasswordEncoder.matches(usuario.getContrasena(), existingUser.getContrasena())) {
            return "Login successful";
        }
        return "Invalid credentials";
    }

    public String register(Usuario usuario) {
        usuario.setContrasena(bCryptPasswordEncoder.encode(usuario.getContrasena()));
        usuarioRepositorio.save(usuario);
        return "User registered successfully";
    }
}
