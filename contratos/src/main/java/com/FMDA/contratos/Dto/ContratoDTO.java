package com.FMDA.contratos.Dto;

import java.time.LocalDate;
import AngelYMilton.FMDataAnalisis.Enums.TiempoJuego;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContratoDTO {

    @NotNull(message = "El IU del jugador es obligatorio")
    private Long iu;

    @NotNull(message = "El salario semanal es obligatorio")
    @Min(value = 0, message = "El salario no puede ser negativo")
    private Integer salarioSemanal;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    private LocalDate fechaFin;

    @NotNull(message = "El tiempo de juego es obligatorio")
    private TiempoJuego tiempoJuego;

    @NotNull(message = "Debe indicar si el jugador está cedido")
    private Boolean cedido;

    @NotNull(message = "Debe indicar si existe opción de extensión")
    private Boolean opcionExtension;

    @NotNull(message = "Debe indicar si existe aumento programado")
    private Boolean aumentoProgramado;

    @Min(value = 0, message = "El nuevo salario no puede ser negativo")
    private Integer nuevoSalario;

    public ContratoDTO() {
    }
}