package com.sistemaNotas.Notas.excepciones;

public class EstudianteNotFoundException extends RuntimeException{

    public EstudianteNotFoundException(Long id){
        super("No se puede encontrar el curso con id: "+ id);
    }
}
