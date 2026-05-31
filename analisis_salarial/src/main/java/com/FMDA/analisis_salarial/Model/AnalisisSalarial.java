package com.FMDA.analisis_salarial.Model;

import AngelYMilton.FMDataAnalisis.Contratos.Model.Contrato;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "analisis_salarial")
@Getter
@Setter
public class AnalisisSalarial {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        // Jugador con menor jerarquia
        @ManyToOne
        @JoinColumn(name = "jugador_menor_jerarquia_id", nullable = false)
        private Contrato contratoMenorJerarquia;

        // Jugador con mayor jerarquia
        @ManyToOne
        @JoinColumn(name = "jugador_mayor_jerarquia_id", nullable = false)
        private Contrato contratoMayorJerarquia;

        // Diferencia salarial
        private Integer diferenciaSalarial;

        // Mensaje generado automaticamente
        @Column(length = 1000)
        private String mensaje;

        // Tipo de inconsistencia
        private String tipoProblema;
}