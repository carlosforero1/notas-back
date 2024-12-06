package com.sistemaNotas.Notas.controlador;

import com.sistemaNotas.Notas.modelo.Profesor;
import com.sistemaNotas.Notas.repositorio.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProfesorControlador {
    @Autowired
    private ProfesorRepositorio repositorio;

    @PostMapping("/Profesor")
    Profesor newProfesor(@RequestBody Profesor newProfesor) {
        return repositorio.save(newProfesor);
    }

    @GetMapping("/Profesores")
    List<Profesor> getAllProfesores() {
        return repositorio.findAll();
    }

    @DeleteMapping("/Profesor/{id}")
    String deleteProfesor(@PathVariable Long id) {
        repositorio.deleteById(id);
        return "el Profesor con el id: " + id + " se ha eliminado correctamente.";
    }
}
