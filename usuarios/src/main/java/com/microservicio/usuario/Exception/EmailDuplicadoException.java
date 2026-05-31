package com.microservicio.usuario.Exception;

public class EmailDuplicadoException extends RuntimeException {
    public EmailDuplicadoException(String email) {
        super("Email " + email + " ya está registrado");
    }
}