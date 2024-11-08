package com.sistemaNotas.Notas.controlador;

import com.sistemaNotas.Notas.excepciones.CursoNotFoundException;
import com.sistemaNotas.Notas.excepciones.UsuarioNotFoundException;
import com.sistemaNotas.Notas.modelo.Curso;
import com.sistemaNotas.Notas.modelo.Estudiante;
import com.sistemaNotas.Notas.modelo.Usuario;
import com.sistemaNotas.Notas.repositorio.EstudianteRepositorio;
import com.sistemaNotas.Notas.servicio.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sn-app")
@CrossOrigin("http://localhost:3000")
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio servicio;
    @GetMapping("/estudiantes")
    public List<Estudiante> obtenerEstudiante(){
        List<Estudiante> estudiantes = servicio.listarEstudiante();
        return estudiantes;
    }

    @PostMapping("/estudiantes")
    public Estudiante agregarEstudiante(@RequestBody Estudiante estudiante){
        return servicio.guardarEstudiante(estudiante);
    }

    @GetMapping("/estudiantes/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorID(@PathVariable Long id){
        var empleado = servicio.buscarEstudiantePorId(id);
        if (empleado == null){
            throw new UsuarioNotFoundException(id);
        }
        return ResponseEntity.ok(empleado);
    }



}
