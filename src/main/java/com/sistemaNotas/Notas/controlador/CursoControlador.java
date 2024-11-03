package com.sistemaNotas.Notas.controlador;

import com.sistemaNotas.Notas.excepciones.CursoNotFoundException;
import com.sistemaNotas.Notas.modelo.Curso;
import com.sistemaNotas.Notas.repositorio.CursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CursoControlador {

    @Autowired
    private CursoRepositorio repositorio;

    @PostMapping("/Curso")
    Curso newCurso(@RequestBody Curso newCurso) {
        return repositorio.save(newCurso);
    }

    @GetMapping("/Cursos")
    List<Curso> getAllCursos() {
        return repositorio.findAll();
    }

    @GetMapping("/Curso/{id}")
    Curso getCursoById(@PathVariable Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new CursoNotFoundException(id));
    }

    @PutMapping("/Curso/{id}")
    Curso updateCurso(@RequestBody Curso newCurso, @PathVariable Long id) {
        return repositorio.findById(id)
                .map(Curso -> {
                    Curso.setId_materia(newCurso.getId_materia());
                    Curso.setId_profesor(newCurso.getId_profesor());
                    Curso.setSemestre(newCurso.getSemestre());
                    return repositorio.save(Curso);
                }).orElseThrow(() -> new CursoNotFoundException(id));
    }

    @DeleteMapping("/Curso/{id}")
    String deleteCurso(@PathVariable Long id) {
        if (!repositorio.existsById(id)) {
            throw new CursoNotFoundException(id);
        }
        repositorio.deleteById(id);
        return "el Curso con el id: " + id + " se ha eliminado correctamente.";
    }
}
