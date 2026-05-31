package com.microservicio.usuario.Exception;

public class CredencialesInvalidasException extends RuntimeException {
    public CredencialesInvalidasException() {
        super("Username o password incorrectos");
    }
}