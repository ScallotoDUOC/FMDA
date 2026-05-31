package com.microservicio.usuario.Controller;

import com.microservicio.usuario.dto.LoginRequest;
import com.microservicio.usuario.dto.UsuarioRequest;
import com.microservicio.usuario.dto.UsuarioResponse;
import com.microservicio.usuario.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarTodos() {
        List<UsuarioResponse> usuarios = service.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
        UsuarioResponse usuario = service.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> crear(@Valid @RequestBody UsuarioRequest request) {
        UsuarioResponse creado = service.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioRequest request) {
        UsuarioResponse actualizado = service.actualizar(id, request);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponse> login(@Valid @RequestBody LoginRequest request) {
        UsuarioResponse usuario = service.login(request);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}/activar")
    public ResponseEntity<UsuarioResponse> activarDesactivar(@PathVariable Long id) {
        UsuarioResponse usuario = service.activarDesactivar(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/activos")
    public ResponseEntity<List<UsuarioResponse>> listarActivos() {
        List<UsuarioResponse> activos = service.listarActivos();
        return ResponseEntity.ok(activos);
    }

    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<UsuarioResponse>> buscarPorRol(@PathVariable String rol) {
        List<UsuarioResponse> usuarios = service.buscarPorRol(rol);
        return ResponseEntity.ok(usuarios);
    }
}