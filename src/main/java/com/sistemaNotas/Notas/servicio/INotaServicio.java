package com.sistemaNotas.Notas.servicio;

import com.sistemaNotas.Notas.modelo.Nota;
import com.sistemaNotas.Notas.modelo.Usuario;

import java.util.List;

public interface INotaServicio {
    public List<Nota> listarNota();

    public Nota buscarNotaPorId(Long id);

    public Nota guardarNota(Nota nota);

    public void eliminarNota(Nota nota);
}
