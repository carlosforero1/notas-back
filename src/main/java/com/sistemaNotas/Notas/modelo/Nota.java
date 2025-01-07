package com.sistemaNotas.Notas.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inscripcion_id", nullable = false)
    private InscripcionEstudiante inscripcionEstudiante;

    private BigDecimal nota;
    private LocalDate fecha;

    private String tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InscripcionEstudiante getInscripcionEstudiante() {
        return inscripcionEstudiante;
    }

    public void setInscripcionEstudiante(InscripcionEstudiante inscripcionEstudiante) {
        this.inscripcionEstudiante = inscripcionEstudiante;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
