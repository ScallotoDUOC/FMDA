package com.FMDA.informacion_personal.dto;

import AngelYMilton.FMDataAnalisis.Enums.Nacionalidad;
import AngelYMilton.FMDataAnalisis.Enums.Personalidad;
import AngelYMilton.FMDataAnalisis.Enums.PiernaHabil;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformacionPersonalDTO {

    @NotNull(message = "El IU del jugador es obligatorio")
    private Long iu;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 14, message = "La edad mínima es 14")
    @Max(value = 60, message = "La edad máxima es 60")
    private Integer edad;

    @NotNull(message = "La nacionalidad es obligatoria")
    private Nacionalidad nacionalidad;

    @NotNull(message = "La altura es obligatoria")
    @Min(value = 140, message = "La altura mínima es 140 cm")
    @Max(value = 230, message = "La altura máxima es 230 cm")
    private Integer altura;

    @NotNull(message = "El peso es obligatorio")
    @Min(value = 40, message = "El peso mínimo es 40 kg")
    @Max(value = 150, message = "El peso máximo es 150 kg")
    private Integer peso;

    @NotNull(message = "La pierna hábil es obligatoria")
    private PiernaHabil piernaHabil;

    @NotNull(message = "La personalidad es obligatoria")
    private Personalidad personalidad;

    private String mediaDescription;

    public InformacionPersonalDTO() {
    }
}