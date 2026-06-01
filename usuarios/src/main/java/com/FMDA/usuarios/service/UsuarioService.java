package com.FMDA.usuarios.service;

import com.FMDA.usuarios.model.Usuario;
import com.FMDA.usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // crear usuario
    public Usuario save(Usuario usuario) {

        if (repository.existsByUsername(usuario.getUsername())) {
            throw new RuntimeException("Username ya existe");
        }

        if (repository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Email ya existe");
        }

        return repository.save(usuario);
    }

    // listar todos
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    // buscar por id
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    // eliminar
    public void deleteById(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }

        repository.deleteById(id);
    }

    // login
    public Optional<Usuario> login(
            String username,
            String password
    ) {
        return repository.findByUsernameAndPassword(
                username,
                password
        );
    }

    // buscar por email
    public Optional<Usuario> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    // buscar por username
    public Optional<Usuario> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    // usuarios activos/inactivos
    public List<Usuario> findByActivo(boolean activo) {
        return repository.findByActivo(activo);
    }

    // por rol
    public List<Usuario> findByRol(String rol) {
        return repository.findByRol(rol);
    }

    // por partida
    public List<Usuario> findByPartidaName(String partidaName) {
        return repository.findAllByPartidaName(partidaName);
    }

    // validar partida
    public boolean existsByPartidaName(String partidaName) {
        return repository.existsByPartidaName(partidaName);
    }
}