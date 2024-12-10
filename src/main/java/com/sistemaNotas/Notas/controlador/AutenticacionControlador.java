package com.sistemaNotas.Notas.controlador;


import com.sistemaNotas.Notas.LoginRequest;
import com.sistemaNotas.Notas.servicio.AutenticacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AutenticacionControlador {

    @Autowired
    private AutenticacionServicio authService;

    // Endpoint de login
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        try {
            String role = authService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
            return role;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
