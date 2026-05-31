package com.FMDA.analisis_salarial.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnalisisSalarialDTO {

        // Contrato del jugador con menor jerarquia
        @NotNull(message = "El ID del contrato de menor jerarquía es obligatorio")
        private Long contratoMenorJerarquiaId;

        // Contrato del jugador con mayor jerarquia
        @NotNull(message = "El ID del contrato de mayor jerarquía es obligatorio")
        private Long contratoMayorJerarquiaId;

        // Diferencia salarial
        @NotNull(message = "La diferencia salarial es obligatoria")
        private Integer diferenciaSalarial;

        // Mensaje generado automaticamente
        @NotBlank(message = "El mensaje no puede estar vacío")
        private String mensaje;

        // Tipo de inconsistencia
        @NotBlank(message = "El tipo de problema es obligatorio")
        private String tipoProblema;

        public AnalisisSalarialDTO() {
        }
}