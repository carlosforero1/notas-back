package com.sistemaNotas.Notas.controlador;

import com.sistemaNotas.Notas.modelo.Libro;
import com.sistemaNotas.Notas.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibrosControlador {

    @Autowired
    private LibroServicio libroServicio;


    @GetMapping("/api/libros")
    public List<Libro> obtenerTodosLosLibros() {
        return libroServicio.obtenerTodosLosLibros();
    }

    @PostMapping
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroServicio.guardarLibro(libro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroServicio.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }
}

