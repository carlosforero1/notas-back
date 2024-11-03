package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.modelo.Estudiante;
import com.sistemaNotas.Notas.modelo.Usuario;
import com.sistemaNotas.Notas.repositorio.EstudianteRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServicio implements IEstudianteServicio{

    public EstudianteRepositorio repositorio;

    @Override
    public List<Estudiante> listarUsuario() {
       return repositorio.findAll();
    }

    @Override
    public Estudiante buscarEstudiantePorId(Long id) {
        Estudiante estudiante = repositorio.findById(id).orElse(null);
        return estudiante;
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return repositorio.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        repositorio.delete(estudiante);
    }
}
