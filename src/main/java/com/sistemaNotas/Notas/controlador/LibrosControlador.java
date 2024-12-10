package com.sistemaNotas.Notas.controlador;

import com.sistemaNotas.Notas.modelo.Libro;
import com.sistemaNotas.Notas.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibrosControlador {

    @Autowired
    private LibroServicio libroServicio;

    // Obtener todos los libros
    @GetMapping
    public List<Libro> obtenerTodosLosLibros() {
        return libroServicio.obtenerTodosLosLibros();
    }

    // Crear un nuevo libro
    @PostMapping
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroServicio.guardarLibro(libro));
    }

    // Obtener un libro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable int id) {
        return ResponseEntity.ok(libroServicio.obtenerLibroPorId(id));
    }

    // Actualizar un libro
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable int id, @RequestBody Libro libro) {
        return ResponseEntity.ok(libroServicio.actualizarLibro(id, libro));
    }

    // Eliminar un libro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable int id) {
        libroServicio.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }
}

