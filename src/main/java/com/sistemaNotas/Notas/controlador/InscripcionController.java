package com.sistemaNotas.Notas.controlador;

import com.sistemaNotas.Notas.modelo.Estudiante;
import com.sistemaNotas.Notas.modelo.InscripcionEstudiante;
import com.sistemaNotas.Notas.modelo.Materia;
import com.sistemaNotas.Notas.repositorio.EstudianteRepositorio;
import com.sistemaNotas.Notas.repositorio.MateriaRepositorio;
import com.sistemaNotas.Notas.servicio.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sn-app")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Autowired
    private MateriaRepositorio materiaRepositorio;

  @GetMapping("/inscripciones")
  public List<InscripcionEstudiante> obtenerInscripcion(){
      List<InscripcionEstudiante> inscripcionEstudiantes = inscripcionService.listarInscripciones();
      return inscripcionEstudiantes;
  }

    @PostMapping("/{estudianteId}/materias/{materiaId}")
    public ResponseEntity<?> inscribirEstudiante(
            @PathVariable Long estudianteId,
            @PathVariable Long materiaId) {

        Estudiante estudiante = estudianteRepositorio.findById(estudianteId)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado con ID: " + estudianteId));

        Materia materia = materiaRepositorio.findById(materiaId)
                .orElseThrow(() -> new IllegalArgumentException("Materia no encontrada con ID: " + materiaId));

        inscripcionService.inscribirEstudiante(estudiante, materia);

        return ResponseEntity.ok("Inscripción realizada con éxito.");
    }
}
