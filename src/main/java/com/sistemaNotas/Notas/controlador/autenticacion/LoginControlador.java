package com.sistemaNotas.Notas.controlador.autenticacion;

import com.sistemaNotas.Notas.modelo.Role;
import com.sistemaNotas.Notas.modelo.Usuario;
import com.sistemaNotas.Notas.servicio.autenticacion.LoginServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginControlador {

    @Autowired
    private LoginServicio servicio;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        try {
            Role role = servicio.authenticate(usuario.getNombreUsuario(), usuario.getContrasena());
            return ResponseEntity.ok(role);  // Retornar el rol
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
