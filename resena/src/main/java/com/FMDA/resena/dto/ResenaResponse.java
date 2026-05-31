package com.FMDA.resena.dto;

import java.time.LocalDateTime;

public class ResenaResponse {

    private Long id;
    private String usuario;
    private int calificacion;
    private String comentario;
    private LocalDateTime fecharesena;

    public ResenaResponse() {
    }

    public ResenaResponse(Long id, String usuario, int calificacion, String comentario, LocalDateTime fecharesena) {
        this.id = id;
        this.usuario = usuario;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecharesena = fecharesena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFecharesena() {
        return fecharesena;
    }

    public void setFecharesena(LocalDateTime fecharesena) {
        this.fecharesena = fecharesena;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", usuario='" + getUsuario() + "'" +
                ", calificacion='" + getCalificacion() + "'" +
                ", comentario='" + getComentario() + "'" +
                ", fecharesena='" + getFecharesena() + "'" +
                "}";
    }
}
