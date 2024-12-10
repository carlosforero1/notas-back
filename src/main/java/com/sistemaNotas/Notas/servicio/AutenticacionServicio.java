package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.modelo.Usuario;
import com.sistemaNotas.Notas.repositorio.RoleRepositorio;
import com.sistemaNotas.Notas.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionServicio {
    @Autowired
    private UsuarioRepositorio userRepository;


    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepositorio rolRepository;

    public String authenticateUser(String correo, String password) {
        Usuario user = userRepository.findByCorreo(correo);
        if (user != null && passwordEncoder.matches(password, user.getContrasena())) {
            return user.getRol().getNombre();
        } else {
            throw new RuntimeException("Credenciales incorrectas");
        }
    }
}


