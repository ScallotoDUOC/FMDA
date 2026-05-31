package com.FMDA.resena.Exception;

public class ResenaNotFoundException extends RuntimeException {

    public ResenaNotFoundException(Long id) {
        super("Resena con ID " + id + " no encontrada");
    }
}
