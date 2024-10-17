package com.sistemaNotas.Notas.controlador;

import com.sistemaNotas.Notas.excepciones.CursoNotFoundException;
import com.sistemaNotas.Notas.modelo.Curso;
import com.sistemaNotas.Notas.modelo.Materia;
import com.sistemaNotas.Notas.repositorio.MateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class MateriaControlador {
    @Autowired
    private MateriaRepositorio repositorio;


    @PostMapping("/Materia")
    Materia newMateria(@RequestBody Materia newMateria) {
        return repositorio.save(newMateria);
    }

    @GetMapping("/Materias")
    List<Materia> getAllMaterias() {
        return repositorio.findAll();
    }

    @GetMapping("/Materia/{id}")
    Materia getMateriaById(@PathVariable Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new CursoNotFoundException(id));
    }

    @PutMapping("/Materia/{id}")
    Materia updateMateria(@RequestBody Materia newMateria, @PathVariable Long id) {
        return repositorio.findById(id)
                .map(Materia -> {
                    Materia.setNombre(newMateria.getNombre());
                    Materia.setCreditos(newMateria.getCreditos());
                    return repositorio.save(Materia);
                }).orElseThrow(() -> new CursoNotFoundException(id));
    }

    @DeleteMapping("/Materia/{id}")
    String deleteMateria(@PathVariable Long id) {
        if (!repositorio.existsById(id)) {
            throw new CursoNotFoundException(id);
        }
        repositorio.deleteById(id);
        return "la Materia con el id: " + id + " se ha eliminado correctamente.";
    }
}
