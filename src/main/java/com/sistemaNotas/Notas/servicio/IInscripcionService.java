package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.modelo.Estudiante;
import com.sistemaNotas.Notas.modelo.InscripcionEstudiante;
import com.sistemaNotas.Notas.modelo.Materia;

import java.util.List;

public interface IInscripcionService {
    public void inscribirEstudiante(Estudiante estudiante, Materia materia);

    public List<InscripcionEstudiante> listarInscripciones();
}
