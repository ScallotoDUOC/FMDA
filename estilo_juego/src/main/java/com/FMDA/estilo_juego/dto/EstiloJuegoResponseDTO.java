package com.FMDA.estilo_juego.dto;

import java.util.Map;

import AngelYMilton.FMDataAnalisis.Enums.EstiloJuego;
import AngelYMilton.FMDataAnalisis.Enums.Personalidad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstiloJuegoResponseDTO {

    // INFORMACION DEL JUGADOR
    private String fullName;

    private Integer edad;

    private Personalidad personalidad;

    // MEJOR ESTILO
    private EstiloJuego mejorEstilo;

    private Double puntuacionMejorEstilo;

    // RANKING COMPLETO
    private Map<EstiloJuego, Double> rankingEstilos;

    public EstiloJuegoResponseDTO() {
    }
}