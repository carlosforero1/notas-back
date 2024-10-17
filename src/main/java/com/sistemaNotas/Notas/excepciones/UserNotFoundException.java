package com.sistemaNotas.Notas.excepciones;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("No se puede encontrar el usuario con id:"+ id);
    }
}
