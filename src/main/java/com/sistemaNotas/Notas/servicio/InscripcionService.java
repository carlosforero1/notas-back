package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.modelo.InscripcionEstudiante;
import com.sistemaNotas.Notas.modelo.Materia;
import com.sistemaNotas.Notas.modelo.Usuario;
import com.sistemaNotas.Notas.repositorio.InscripcionEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InscripcionService implements IInscripcionService {

    @Autowired
    private InscripcionEstudianteRepositorio inscripcionRepositorio;
    @Override
    public void inscribirEstudiante(Usuario estudiante, Materia materia) {
        long materiasInscritas = inscripcionRepositorio.countByEstudiante(estudiante);

        if (materiasInscritas >= 5) {
            throw new IllegalArgumentException("El estudiante no puede inscribirse en más de 5 materias.");
        }

        inscripcionRepositorio.save(new InscripcionEstudiante(estudiante, materia, LocalDate.now()));
    }

    @Override
    public List<InscripcionEstudiante> listarInscripciones() {
        return inscripcionRepositorio.findAll();
    }


}
