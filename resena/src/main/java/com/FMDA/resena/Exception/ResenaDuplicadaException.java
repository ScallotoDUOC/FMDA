package com.FMDA.resena.Exception;

public class ResenaDuplicadaException extends RuntimeException {
    public ResenaDuplicadaException(String usuario) {
        super("Resena de el usuario " + usuario + " ya está registrada");
    }
}
