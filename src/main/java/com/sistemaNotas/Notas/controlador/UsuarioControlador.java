package com.sistemaNotas.Notas.controlador;

import com.sistemaNotas.Notas.modelo.Usuario;
import com.sistemaNotas.Notas.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sn-app")
@CrossOrigin("http://localhost:3000")
public class UsuarioControlador {
    @Autowired
    private IUsuarioServicio usuarioServicio;

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuario() {
        List<Usuario> usuario = usuarioServicio.listarUsuario();
        return usuario;
    }

    @PostMapping("/usuarios")
    public Usuario agregarUsuario(@RequestBody Usuario usuario) {
        return usuarioServicio.guardarUsuario(usuario);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorID(@PathVariable Long id) {
        var empleado = usuarioServicio.buscarEmpeladoPorId(id);

        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminar(@PathVariable Long id) {
        Usuario usuario = usuarioServicio.buscarEmpeladoPorId(id);
            usuarioServicio.eliminarUsuario(usuario);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Elimnado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }


}
