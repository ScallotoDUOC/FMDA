package com.FMDA.ponderacion_general.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import AngelYMilton.FMDataAnalisis.PonderacionGeneral.Service.PonderacionGeneralService;
import AngelYMilton.FMDataAnalisis.PonderacionGeneral.dto.PonderacionGeneralResponseDTO;

@RestController
@RequestMapping("/api/ponderacion-general")
public class PonderacionGeneralController {

    @Autowired
    private PonderacionGeneralService ponderacionGeneralService;

    // OBTENER PONDERACION GENERAL POR IU
    @GetMapping("/{iu}")
    public ResponseEntity<PonderacionGeneralResponseDTO> obtenerPonderacionGeneral(
            @PathVariable Long iu) {

        PonderacionGeneralResponseDTO response = ponderacionGeneralService
                .calcularPonderacionGeneral(iu);

        return ResponseEntity.ok(response);
    }
}