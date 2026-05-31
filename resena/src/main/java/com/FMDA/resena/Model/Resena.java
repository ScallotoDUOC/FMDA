package com.FMDA.resena.Model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Resena {

    private Long id;
    private String usuario;
    private int calificacion;
    private String comentario;
    private LocalDateTime fecharesena;

    public Resena() {
    }

    public Resena(Long id, String usuario, int calificacion, String comentario,
            LocalDateTime fecharesena) {
        this.id = id;
        this.usuario = usuario;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecharesena = fecharesena;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getCalificacion() {
        return this.calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFecharesena() {
        return this.fecharesena;
    }

    public void setFecharesena(LocalDateTime fecharesena) {
        this.fecharesena = fecharesena;
    }

    public Resena id(Long id) {
        setId(id);
        return this;
    }

    public Resena usuario(String usuario) {
        setUsuario(usuario);
        return this;
    }

    public Resena calificacion(int calificacion) {
        setCalificacion(calificacion);
        return this;
    }

    public Resena comentario(String comentario) {
        setComentario(comentario);
        return this;
    }

    public Resena fecharesena(LocalDateTime fecharesena) {
        setFecharesena(fecharesena);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, calificacion, comentario, fecharesena);
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
