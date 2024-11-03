package com.sistemaNotas.Notas.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException(Long id){
        super("No se puede encontrar el usuario con id:"+ id);
    }
}
