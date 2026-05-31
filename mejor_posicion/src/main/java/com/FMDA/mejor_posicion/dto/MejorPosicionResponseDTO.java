package com.FMDA.mejor_posicion.dto;

import java.util.Map;

import AngelYMilton.FMDataAnalisis.Enums.Personalidad;
import AngelYMilton.FMDataAnalisis.Enums.Posiciones;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MejorPosicionResponseDTO {

    // INFORMACION DEL JUGADOR
    private String fullName;

    private Integer edad;

    private Personalidad personalidad;

    // MEJOR POSICION
    private Posiciones mejorRol;

    private Double puntuacionMejorRol;

    // RANKING COMPLETO
    private Map<Posiciones, Double> rankingRoles;

    public MejorPosicionResponseDTO() {
    }
}