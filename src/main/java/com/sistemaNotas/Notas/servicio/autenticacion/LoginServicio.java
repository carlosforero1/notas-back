package com.sistemaNotas.Notas.servicio.autenticacion;

import com.sistemaNotas.Notas.modelo.Role;
import com.sistemaNotas.Notas.modelo.Usuario;
import com.sistemaNotas.Notas.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Role authenticate(String nombreUsuario, String contrasena) {
        // Busca el usuario por nombre de usuario
       Usuario usu = usuarioRepositorio.findByNombreUsuario(nombreUsuario);

        // Verifica si el usuario existe y si la contraseña coincide
        if (usu != null && passwordEncoder.matches(contrasena, usu.getContrasena())) {
            return usu.getRole();  // Retorna el rol si la autenticación es exitosa
        }

        // Lanza una excepción si las credenciales son inválidas
        throw new RuntimeException("Credenciales inválidas");
    }
}
