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
}
