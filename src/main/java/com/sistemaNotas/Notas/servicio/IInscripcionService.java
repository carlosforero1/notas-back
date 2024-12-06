package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.modelo.Estudiante;
import com.sistemaNotas.Notas.modelo.Materia;

public interface IInscripcionService {
    public void inscribirEstudiante(Estudiante estudiante, Materia materia);
}
