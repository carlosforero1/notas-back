package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.modelo.Curso;
import com.sistemaNotas.Notas.repositorio.CursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CursoService {

    @Autowired
    private CursoRepositorio cursoRepository;

    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll();
    }

    public Curso obtenerCursoPorId(Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.orElse(null);
    }

    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso actualizarCurso(Long id, Curso curso) {
        Optional<Curso> cursoExistente = cursoRepository.findById(id);
        if (cursoExistente.isPresent()) {
            Curso cursoActualizado = cursoExistente.get();
            cursoActualizado.setSemestre(curso.getSemestre());
            cursoActualizado.setEstudiante(curso.getEstudiante());
            cursoActualizado.setMateria(curso.getMateria());
            cursoActualizado.setProfesor(curso.getProfesor());
            return cursoRepository.save(cursoActualizado);
        }
        return null;
    }

    public boolean eliminarCurso(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


