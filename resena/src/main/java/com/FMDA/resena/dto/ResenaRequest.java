package com.FMDA.resena.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ResenaRequest {

    @NotBlank(message = "Usuario es obligatorio")
    @Size(min = 3, max = 20, message = "Usuario debe tener entre 3 y 20 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Usuario solo permite letras, numeros y guion bajo")
    private String Usuario;

    @Size(max = 500, message = "Comentario no puede exceder 500 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 .,!?\"'()\\-]*$", message = "Comentario contiene caracteres no permitidos")
    private String Comentario;

    @NotBlank(message = "Calificacion es obligatoria")
    @Pattern(regexp = "^[1-5]$", message = "Calificacion debe ser un numero entre 1 y 5")
    private String Calificacion;

    public ResenaRequest() {
    }

    public ResenaRequest(String Usuario, String Comentario, int Calificacion) {
        this.Usuario = Usuario;
        this.Comentario = Comentario;
        this.Calificacion = String.valueOf(Calificacion);
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public String getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(int Calificacion) {
        this.Calificacion = String.valueOf(Calificacion);
    }

    @Override
    public String toString() {
        return "{" +
                " Usuario='" + getUsuario() + "'" +
                ", Comentario='" + getComentario() + "'" +
                ", Calificacion='" + getCalificacion() + "'" +
                "}";
    }

}
