package com.FMDA.usuarios.dto;

import com.FMDA.usuarios.model.Usuario;

import java.time.LocalDateTime;

public class UsuarioDTO {

    private Long id;

    private String username;

    private String email;

    private String rol;

    private String partidaName;

    private boolean activo;

    private LocalDateTime createdAt;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.username = usuario.getUsername();
        this.email = usuario.getEmail();
        this.rol = usuario.getRol();
        this.partidaName = usuario.getPartidaName();
        this.activo = usuario.isActivo();
        this.createdAt = usuario.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }

    public String getPartidaName() {
        return partidaName;
    }

    public boolean isActivo() {
        return activo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}