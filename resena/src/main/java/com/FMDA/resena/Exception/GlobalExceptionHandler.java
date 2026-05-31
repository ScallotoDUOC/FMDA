package com.FMDA.resena.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(ResenaNotFoundException.class)
    public String handleResenaNotFound(ResenaNotFoundException ex) {
        return ex.getMessage();
    }

}
