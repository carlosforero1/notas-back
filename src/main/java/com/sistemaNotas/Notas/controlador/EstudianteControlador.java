package com.sistemaNotas.Notas.controlador;

import com.sistemaNotas.Notas.excepciones.CursoNotFoundException;
import com.sistemaNotas.Notas.modelo.Curso;
import com.sistemaNotas.Notas.modelo.Estudiante;
import com.sistemaNotas.Notas.repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sn-app")
@CrossOrigin("http://localhost:3000")
public class EstudianteControlador {

    @Autowired
    private EstudianteRepositorio repositorio;

    @PostMapping("/Estudiante")
    Estudiante newEstudiante(@RequestBody Estudiante newEstudiante) {
        return repositorio.save(newEstudiante);
    }

    @GetMapping("/Estudiantes")
    List<Estudiante> getAllEstudiantes() {
        return repositorio.findAll();
    }

    @GetMapping("/Estudiante/{id}")
    Estudiante getEstudianteById(@PathVariable Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new CursoNotFoundException(id));
    }

    @PutMapping("/Estudiante/{id}")
    Estudiante updateEstudiante(@RequestBody Estudiante newEstudiante, @PathVariable Long id) {
        return repositorio.findById(id)
                .map(Estudiante -> {
                    Estudiante.setMatricula(newEstudiante.getMatricula());
                    return repositorio.save(Estudiante);
                }).orElseThrow(() -> new CursoNotFoundException(id));
    }

    @DeleteMapping("/Estudiante/{id}")
    String deleteEstudiante(@PathVariable Long id) {
        if (!repositorio.existsById(id)) {
            throw new CursoNotFoundException(id);
        }
        repositorio.deleteById(id);
        return "el Estudiante con el id: " + id + " se ha eliminado correctamente.";
    }

}
