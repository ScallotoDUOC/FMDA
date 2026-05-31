package com.FMDA.mejor_posicion.MejorPosicionController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import AngelYMilton.FMDataAnalisis.MejorPosicion.MejorPosicionService.MejorPosicionService;
import AngelYMilton.FMDataAnalisis.MejorPosicion.dto.MejorPosicionResponseDTO;

@RestController
@RequestMapping("/api/mejor-posicion")
public class MejorPosicionController {

    @Autowired
    private MejorPosicionService mejorPosicionService;

    @GetMapping("/{iu}")
    public ResponseEntity<MejorPosicionResponseDTO> calcularMejorPosicion(@PathVariable Long iu) {

        MejorPosicionResponseDTO response = mejorPosicionService
                .calcularMejorPosicion(iu);

        return ResponseEntity.ok(response);
    }
}