package com.sistemaNotas.Notas.excepciones;

public class CursoNotFoundException extends RuntimeException{
    public CursoNotFoundException(Long id){
        super("No se puede encontrar el curso con id: "+ id);
    }
}
