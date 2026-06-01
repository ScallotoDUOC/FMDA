package com.FMDA.usuarios.controller;

import com.FMDA.usuarios.model.Usuario;
import com.FMDA.usuarios.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // crear usuario
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        return service.save(usuario);
    }

    // listar todos
    @GetMapping
    public List<Usuario> findAll() {
        return service.findAll();
    }

    // buscar por id
    @GetMapping("/{id}")
    public Optional<Usuario> findById(
            @PathVariable Long id
    ) {
        return service.findById(id);
    }

    // eliminar
    @DeleteMapping("/{id}")
    public void deleteById(
            @PathVariable Long id
    ) {
        service.deleteById(id);
    }

    // login
    @PostMapping("/login")
    public Optional<Usuario> login(
            @RequestParam String username,
            @RequestParam String password
    ) {
        return service.login(
                username,
                password
        );
    }

    // buscar email
    @GetMapping("/email/{email}")
    public Optional<Usuario> findByEmail(
            @PathVariable String email
    ) {
        return service.findByEmail(email);
    }

    // buscar username
    @GetMapping("/username/{username}")
    public Optional<Usuario> findByUsername(
            @PathVariable String username
    ) {
        return service.findByUsername(username);
    }

    // activos
    @GetMapping("/activo/{activo}")
    public List<Usuario> findByActivo(
            @PathVariable boolean activo
    ) {
        return service.findByActivo(activo);
    }

    // rol
    @GetMapping("/rol/{rol}")
    public List<Usuario> findByRol(
            @PathVariable String rol
    ) {
        return service.findByRol(rol);
    }

    // partida
    @GetMapping("/partida/{partidaName}")
    public List<Usuario> findByPartidaName(
            @PathVariable String partidaName
    ) {
        return service.findByPartidaName(partidaName);
    }

    // existe partida
    @GetMapping("/partida/existe/{partidaName}")
    public boolean existsByPartidaName(
            @PathVariable String partidaName
    ) {
        return service.existsByPartidaName(
                partidaName
        );
    }
}