package com.FMDA.informacion_personal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import AngelYMilton.FMDataAnalisis.InformacionPersonal.Model.InformacionPersonal;
import AngelYMilton.FMDataAnalisis.InformacionPersonal.Service.InformacionPersonalService;
import AngelYMilton.FMDataAnalisis.InformacionPersonal.dto.InformacionPersonalDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/informacion-personal")
@Validated
public class InformacionPersonalController {

        @Autowired
        private InformacionPersonalService informacionPersonalService;

        // CREAR INFORMACION PERSONAL
        @PostMapping
        public ResponseEntity<InformacionPersonal> crearInformacionPersonal(
                        @Valid @RequestBody InformacionPersonalDTO dto) {

                InformacionPersonal informacionCreada = informacionPersonalService
                                .crearInformacionPersonal(dto);

                return ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(informacionCreada);
        }

        // OBTENER TODOS
        @GetMapping
        public ResponseEntity<List<InformacionPersonal>> obtenerTodos() {

                return ResponseEntity.ok(
                                informacionPersonalService.obtenerTodos());
        }

        // BUSCAR POR ID
        @GetMapping("/{id}")
        public ResponseEntity<InformacionPersonal> buscarPorId(
                        @PathVariable Long id) {

                return ResponseEntity.ok(
                                informacionPersonalService.buscarPorId(id));
        }

        // BUSCAR POR IU
        @GetMapping("/iu/{iu}")
        public ResponseEntity<InformacionPersonal> buscarPorIU(
                        @PathVariable Long iu) {

                return ResponseEntity.ok(
                                informacionPersonalService.buscarPorIU(iu));
        }

        // ACTUALIZAR
        @PutMapping("/{id}")
        public ResponseEntity<InformacionPersonal> actualizarInformacionPersonal(
                        @PathVariable Long id,
                        @Valid @RequestBody InformacionPersonalDTO dto) {

                InformacionPersonal informacionActualizada = informacionPersonalService
                                .actualizarInformacionPersonal(id, dto);

                return ResponseEntity.ok(informacionActualizada);
        }

        // ELIMINAR
        @DeleteMapping("/{id}")
        public ResponseEntity<String> eliminarInformacionPersonal(
                        @PathVariable Long id) {

                informacionPersonalService
                                .eliminarInformacionPersonal(id);

                return ResponseEntity.ok(
                                "Información personal eliminada correctamente");
        }
}