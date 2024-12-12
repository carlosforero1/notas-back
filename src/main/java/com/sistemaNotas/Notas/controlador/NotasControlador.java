package com.sistemaNotas.Notas.controlador;

import com.sistemaNotas.Notas.modelo.Nota;
import com.sistemaNotas.Notas.servicio.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
@CrossOrigin(origins = "http://localhost:3000")
public class NotasControlador {

    @Autowired
    private NotaServicio notaService;

    @GetMapping
    public List<Nota> getAllNotas() {
        return notaService.getAllNotas();
    }

    @PostMapping
    public Nota createNota(@RequestBody Nota nota) {
        return notaService.saveNota(nota);
    }

    @PutMapping("/{id}")
    public Nota updateNota(@PathVariable Long id, @RequestBody Nota notaDetails) {
        return notaService.updateNota(id, notaDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNota(@PathVariable Long id) {
        notaService.deleteNota(id);
        return ResponseEntity.ok().build();
    }
}

