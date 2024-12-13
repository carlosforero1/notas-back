package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.Excepciones.ResourceNotFoundException;
import com.sistemaNotas.Notas.modelo.Nota;
import com.sistemaNotas.Notas.repositorio.NotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServicio {

    @Autowired
    private NotaRepositorio notaRepository;

    public List<Nota> getAllNotas() {
        return notaRepository.findAll();
    }

    public Nota saveNota(Nota nota) {
        return notaRepository.save(nota);
    }

    public Nota updateNota(Long id, Nota nota) {
        nota.setId(id);
        return notaRepository.save(nota);
    }

    public void deleteNota(Long id) {
        notaRepository.deleteById(id);
    }

}
