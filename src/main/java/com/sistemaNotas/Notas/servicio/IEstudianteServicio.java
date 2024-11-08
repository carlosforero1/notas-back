package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.modelo.Estudiante;
import java.util.List;

public interface IEstudianteServicio {

    public List<Estudiante> listarEstudiante();

    public Estudiante buscarEstudiantePorId(Long id);

    public Estudiante guardarEstudiante(Estudiante estudiante);

    public void eliminarEstudiante(Estudiante estudiante);
}
