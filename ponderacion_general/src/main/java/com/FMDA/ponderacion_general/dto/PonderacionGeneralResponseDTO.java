package com.FMDA.ponderacion_general.dto;

import com.FMDA.Enums.Personalidad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PonderacionGeneralResponseDTO {

    private String nombreJugador;

    private Double promedioFisico;

    private Double promedioMental;

    private Double promedioTecnico;

    private Double promedioGeneral;

    private Integer edad;

    private Personalidad personalidad;

    public PonderacionGeneralResponseDTO() {
    }
}