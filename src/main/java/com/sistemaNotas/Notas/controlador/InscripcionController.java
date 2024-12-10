package com.sistemaNotas.Notas.controlador;

import com.sistemaNotas.Notas.modelo.InscripcionEstudiante;
import com.sistemaNotas.Notas.modelo.Materia;
import com.sistemaNotas.Notas.modelo.Usuario;
import com.sistemaNotas.Notas.repositorio.MateriaRepositorio;
import com.sistemaNotas.Notas.repositorio.UsuarioRepositorio;
import com.sistemaNotas.Notas.servicio.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;


  @GetMapping("/inscripciones")
  public List<InscripcionEstudiante> obtenerInscripcion(){
      List<InscripcionEstudiante> inscripcionEstudiantes = inscripcionService.listarInscripciones();
      return inscripcionEstudiantes;
  }

}
