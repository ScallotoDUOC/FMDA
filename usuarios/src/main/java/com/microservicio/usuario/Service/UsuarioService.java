package com.microservicio.usuario.Service;

import com.microservicio.usuario.Exception.EmailDuplicadoException;
import com.microservicio.usuario.Exception.CredencialesInvalidasException;
import com.microservicio.usuario.Exception.UsuarioNotFoundException;
import com.microservicio.usuario.Exception.UsernameDuplicadoException;
import com.microservicio.usuario.Model.Usuario;
import com.microservicio.usuario.Repository.UsuarioRepository;
import com.microservicio.usuario.dto.LoginRequest;
import com.microservicio.usuario.dto.UsuarioRequest;
import com.microservicio.usuario.dto.UsuarioResponse;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioResponse> listarTodos() {
        return repository.findAll().stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    public UsuarioResponse buscarPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
        return convertirAResponse(usuario);
    }

    public UsuarioResponse crear(UsuarioRequest request) {

        if (repository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailDuplicadoException(request.getEmail());
        }

        if (repository.findByUsername(request.getUsername()).isPresent()) {
            throw new UsernameDuplicadoException(request.getUsername());
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(request.getUsername());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(hashPassword(request.getPassword()));
        usuario.setRol(request.getRol());

        Usuario guardado = repository.save(usuario);

        return convertirAResponse(guardado);
    }

    public UsuarioResponse actualizar(Long id, UsuarioRequest request) {
        Usuario existente = repository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        repository.findByEmail(request.getEmail())
                .ifPresent(u -> {
                    if (!u.getId().equals(id)) {
                        throw new EmailDuplicadoException(request.getEmail());
                    }
                });

        repository.findByUsername(request.getUsername())
                .ifPresent(u -> {
                    if (!u.getId().equals(id)) {
                        throw new UsernameDuplicadoException(request.getUsername());
                    }
                });

        existente.setUsername(request.getUsername());
        existente.setEmail(request.getEmail());
        existente.setPassword(hashPassword(request.getPassword()));
        existente.setRol(request.getRol());

        Usuario actualizado = repository.save(existente);
        return convertirAResponse(actualizado);
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new UsuarioNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public UsuarioResponse login(LoginRequest request) {
        Usuario usuario = repository.findByUsernameAndPassword(
                request.getUsername(),
                hashPassword(request.getPassword())).orElseThrow(() -> new CredencialesInvalidasException());

        if (!usuario.isActivo()) {
            throw new CredencialesInvalidasException();
        }

        return convertirAResponse(usuario);
    }

    public UsuarioResponse activarDesactivar(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        usuario.setActivo(!usuario.isActivo());
        Usuario actualizado = repository.save(usuario);
        return convertirAResponse(actualizado);
    }

    public List<UsuarioResponse> listarActivos() {
        return repository.findByActivo(true).stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    public List<UsuarioResponse> buscarPorRol(String rol) {
        return repository.findByRol(rol).stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    private UsuarioResponse convertirAResponse(Usuario usuario) {
        UsuarioResponse response = new UsuarioResponse();
        response.setId(usuario.getId());
        response.setUsername(usuario.getUsername());
        response.setEmail(usuario.getEmail());
        response.setRol(usuario.getRol());
        response.setActivo(usuario.isActivo());
        response.setCreatedAt(usuario.getCreatedAt());
        return response;
    }

    private String hashPassword(String password) {
        return "HASH_" + password;
    }
}