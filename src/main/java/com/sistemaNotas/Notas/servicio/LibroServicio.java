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

    public List<Libro> obtenerTodosLosLibros() {
        return libroRepositorio.findAll();
    }

    public Libro guardarLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    public Libro obtenerLibroPorId(int id) {
        Optional<Libro> libro = libroRepositorio.findById(id);
        return libro.orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }
    public void eliminarLibro(int id) {
        if (!libroRepositorio.existsById(id)) {
            throw new RuntimeException("Libro no encontrado");
        }
        libroRepositorio.deleteById(id);
    }
}

