package com.sistemaNotas.Notas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private int id_usuarios;

    private String departamento;

    private int materias;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
