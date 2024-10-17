package com.sistemaNotas.Notas.controlador;

import com.sistemaNotas.Notas.excepciones.UserNotFoundException;
import com.sistemaNotas.Notas.modelo.Usuario;
import com.sistemaNotas.Notas.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UsuarioControlador {

    @Autowired
    private UsuarioRepositorio userRepositorio;

    @PostMapping("/Usuario")
    Usuario newUser(@RequestBody Usuario newUser) {
        return userRepositorio.save(newUser);
    }

    @GetMapping("/Usuarios")
    List<Usuario> getAllUsers() {
        return userRepositorio.findAll();
    }

    @GetMapping("/Usuario/{id}")
    Usuario getUserById(@PathVariable Long id) {
        return userRepositorio.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/Usuario/{id}")
    Usuario updateUser(@RequestBody Usuario newUser, @PathVariable Long id) {
        return userRepositorio.findById(id)
                .map(Usuario -> {
                    Usuario.setNombre(newUser.getNombre());
                    Usuario.setApellido(newUser.getApellido());
                    Usuario.setCorreo(newUser.getCorreo());
                    Usuario.setContrasena(newUser.getContrasena());
                    Usuario.setTipo_usuario(newUser.getTipo_usuario());
                    Usuario.setCodigo(newUser.getCodigo());
                    return userRepositorio.save(Usuario);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/Usuario/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!userRepositorio.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepositorio.deleteById(id);
        return "el usuario con el id: " + id + " se ha eliminado correctamente.";
    }
}
