package com.FMDA.usuarios.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String rol;

    // nombre de la partida asociada al usuario
    @Column(nullable = false)
    private String partidaName;

    @Column(nullable = false)
    private boolean activo;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Usuario() {
        this.activo = true;
        this.createdAt = LocalDateTime.now();
    }

    public Usuario(String username,
                   String email,
                   String password,
                   String rol,
                   String partidaName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.partidaName = partidaName;
        this.activo = true;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPartidaName() {
        return partidaName;
    }

    public void setPartidaName(String partidaName) {
        this.partidaName = partidaName;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", rol='" + rol + '\'' +
                ", partidaName='" + partidaName + '\'' +
                ", activo=" + activo +
                ", createdAt=" + createdAt +
                '}';
    }
}