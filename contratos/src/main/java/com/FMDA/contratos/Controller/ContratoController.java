package com.FMDA.contratos.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import AngelYMilton.FMDataAnalisis.Contratos.Dto.ContratoDTO;
import AngelYMilton.FMDataAnalisis.Contratos.Model.Contrato;
import AngelYMilton.FMDataAnalisis.Contratos.Service.ContratoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/contratos")
@RequiredArgsConstructor
@Validated
public class ContratoController {

    private final ContratoService contratoService;

    // CREAR CONTRATO
    @PostMapping
    public ResponseEntity<Contrato> crearContrato(
            @Valid @RequestBody ContratoDTO dto) {

        Contrato contratoCreado = contratoService.crearContrato(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(contratoCreado);
    }

    // OBTENER TODOS LOS CONTRATOS
    @GetMapping
    public ResponseEntity<List<Contrato>> obtenerTodos() {

        return ResponseEntity.ok(
                contratoService.obtenerTodos());
    }

    // BUSCAR CONTRATO POR IU
    @GetMapping("/iu/{iu}")
    public ResponseEntity<Contrato> buscarPorIU(
            @PathVariable Long iu) {

        return ResponseEntity.ok(
                contratoService.buscarPorIU(iu));
    }

    // ACTUALIZAR CONTRATO
    @PutMapping("/{id}")
    public ResponseEntity<Contrato> actualizarContrato(
            @PathVariable Long id,
            @Valid @RequestBody ContratoDTO dto) {

        Contrato contratoActualizado = contratoService.actualizarContrato(id, dto);

        return ResponseEntity.ok(contratoActualizado);
    }

    // ELIMINAR CONTRATO
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarContrato(
            @PathVariable Long id) {

        contratoService.eliminarContrato(id);

        return ResponseEntity.ok("Contrato eliminado correctamente");
    }
}