package com.FMDA.usuarios.exception;

public class UsuarioAlreadyExistsException
        extends RuntimeException {

    public UsuarioAlreadyExistsException(
            String mensaje
    ) {
        super(mensaje);
    }
}