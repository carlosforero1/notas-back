package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.modelo.Libro;
import com.sistemaNotas.Notas.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;

    // Obtener todos los libros
    public List<Libro> obtenerTodosLosLibros() {
        return libroRepositorio.findAll();
    }

    // Guardar un nuevo libro
    public Libro guardarLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    // Obtener un libro por ID
    public Libro obtenerLibroPorId(int id) {
        Optional<Libro> libro = libroRepositorio.findById(id);
        return libro.orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    // Actualizar un libro
    public Libro actualizarLibro(int id, Libro libro) {
        if (!libroRepositorio.existsById(id)) {
            throw new RuntimeException("Libro no encontrado");
        }
        libro.setId(id);
        return libroRepositorio.save(libro);
    }

    // Eliminar un libro
    public void eliminarLibro(int id) {
        if (!libroRepositorio.existsById(id)) {
            throw new RuntimeException("Libro no encontrado");
        }
        libroRepositorio.deleteById(id);
    }
}

