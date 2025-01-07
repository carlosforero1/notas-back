package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.modelo.Materia;
import com.sistemaNotas.Notas.modelo.Nota;
import com.sistemaNotas.Notas.repositorio.MateriaRepositorio;
import com.sistemaNotas.Notas.repositorio.NotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaServicio {
    @Autowired
    private MateriaRepositorio repositorio;

    public List<Materia> getAll() {
        return repositorio.findAll();
    }

    public Materia save(Materia materia) {
        return repositorio.save(materia);
    }

    public Materia update(Long id, Materia materia) {
        materia.setId(id);
        return repositorio.save(materia);
    }

    public void delete(Long id) {
        repositorio.deleteById(id);
    }

}
