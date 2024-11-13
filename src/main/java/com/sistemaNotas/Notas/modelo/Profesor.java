package com.sistemaNotas.Notas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profesor extends Usuario {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private int id_usuarios;

    private String departamento;

    private int materias;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
