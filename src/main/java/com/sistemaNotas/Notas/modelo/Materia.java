package com.sistemaNotas.Notas.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Integer creditos;

    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = false)
    private Usuario profesor;

    @OneToMany(mappedBy = "materia")
    private List<InscripcionEstudiante> inscripciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Usuario getProfesor() {
        return profesor;
    }

    public void setProfesor(Usuario profesor) {
        this.profesor = profesor;
    }

    public List<InscripcionEstudiante> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<InscripcionEstudiante> inscripciones) {
        this.inscripciones = inscripciones;
    }
}
