package com.sistemaNotas.Notas.controlador;

import com.sistemaNotas.Notas.modelo.Estudiante;
import com.sistemaNotas.Notas.modelo.Materia;
import com.sistemaNotas.Notas.repositorio.EstudianteRepositorio;
import com.sistemaNotas.Notas.repositorio.MateriaRepositorio;
import com.sistemaNotas.Notas.servicio.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Autowired
    private MateriaRepositorio materiaRepositorio;

    @PostMapping("/{estudianteId}/materias/{materiaId}")
    public ResponseEntity<?> inscribirEstudiante(
            @PathVariable Long estudianteId,
            @PathVariable Long materiaId) {

        // Buscar el estudiante por ID
        Estudiante estudiante = estudianteRepositorio.findById(estudianteId)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado con ID: " + estudianteId));

        // Buscar la materia por ID
        Materia materia = materiaRepositorio.findById(materiaId)
                .orElseThrow(() -> new IllegalArgumentException("Materia no encontrada con ID: " + materiaId));

        // Llamar al servicio con los objetos encontrados
        inscripcionService.inscribirEstudiante(estudiante, materia);

        return ResponseEntity.ok("Inscripción realizada con éxito.");
    }
}
