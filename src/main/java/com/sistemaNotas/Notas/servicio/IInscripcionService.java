package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.modelo.InscripcionEstudiante;
import com.sistemaNotas.Notas.modelo.Materia;
import com.sistemaNotas.Notas.modelo.Usuario;

import java.util.List;

public interface IInscripcionService {
    public void inscribirEstudiante(Usuario estudiante, Materia materia);

    public List<InscripcionEstudiante> listarInscripciones();
}
