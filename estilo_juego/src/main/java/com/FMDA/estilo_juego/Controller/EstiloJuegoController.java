package com.FMDA.estilo_juego.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import AngelYMilton.FMDataAnalisis.EstiloJuego.Service.EstiloJuegoService;
import AngelYMilton.FMDataAnalisis.EstiloJuego.dto.EstiloJuegoResponseDTO;

@RestController
@RequestMapping("/api/estilo-juego")
public class EstiloJuegoController {

    @Autowired
    private EstiloJuegoService estiloJuegoService;

    @GetMapping("/{iu}")
    public ResponseEntity<EstiloJuegoResponseDTO> calcularMejorEstilo(@PathVariable Long iu) {

        EstiloJuegoResponseDTO response = estiloJuegoService
                .calcularMejorEstilo(iu);

        return ResponseEntity.ok(response);
    }
}