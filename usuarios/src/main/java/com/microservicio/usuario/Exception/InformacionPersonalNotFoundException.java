package com.microservicio.usuario.Exception;

public class InformacionPersonalNotFoundException extends RuntimeException {

    public InformacionPersonalNotFoundException(String message) {
        super(message);
    }
}