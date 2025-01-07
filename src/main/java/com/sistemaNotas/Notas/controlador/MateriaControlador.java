package com.sistemaNotas.Notas.controlador;


import com.sistemaNotas.Notas.modelo.Materia;
import com.sistemaNotas.Notas.modelo.Nota;
import com.sistemaNotas.Notas.servicio.MateriaServicio;
import com.sistemaNotas.Notas.servicio.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materia")
@CrossOrigin(origins = "http://localhost:3000")
public class MateriaControlador {
    @Autowired
    private MateriaServicio servicio;

    @GetMapping
    public List<Materia> getAll() {
        return servicio.getAll();
    }

    @PostMapping
    public Materia createNota(@RequestBody Materia materia) {
        return servicio.save(materia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> updateNota(@PathVariable Long id, @RequestBody Materia materia) {
        Materia materiaActual = servicio.update(id, materia);
        return ResponseEntity.ok(materiaActual);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNota(@PathVariable Long id) {
        servicio.delete(id);
        return ResponseEntity.ok().build();
    }

}
