package com.FMDA.resena.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FMDA.resena.Service.ResenaService;
import com.FMDA.resena.dto.ResenaRequest;
import com.FMDA.resena.dto.ResenaResponse;
import jakarta.validation.Valid;

/*
 * Controlador REST encargado de gestionar las operaciones CRUD de reseñas.
 * Expone endpoints para listar, buscar, crear, actualizar y eliminar reseñas,
 * delegando la lógica de negocio al servicio ResenaService.
 */
@RestController
@RequestMapping("/api/resenas")
public class ResenaController {

    private final ResenaService service;

    public ResenaController(ResenaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ResenaResponse>> listarTodos() {
        List<ResenaResponse> resenas = service.listarTodos();
        return ResponseEntity.ok(resenas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResenaResponse> buscarPorId(@PathVariable Long id) {
        ResenaResponse resena = service.buscarPorId(id);
        return ResponseEntity.ok(resena);
    }

    @PostMapping
    public ResponseEntity<ResenaResponse> crear(@Valid @RequestBody ResenaRequest request) {
        ResenaResponse creado = service.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResenaResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ResenaRequest request) {
        ResenaResponse actualizado = service.actualizar(id, request);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.Eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
