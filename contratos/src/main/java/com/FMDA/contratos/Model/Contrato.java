package com.FMDA.contratos.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contratos")
@Getter
@Setter
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // sueldo semanal
    @Column(nullable = false)
    private Integer salarioSemanal;

    // inicio del contrato
    @Column(nullable = false)
    private LocalDate fechaInicio;

    // fin del contrato
    @Column(nullable = false)
    private LocalDate fechaFin;

    // importancia/promesa de minutos
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TiempoJuego tiempoJuego;

    // cedido o no
    @Column(nullable = false)
    private Boolean cedido;

    // tiene extensión automática
    @Column(nullable = false)
    private Boolean opcionExtension;

    // aumento programado
    @Column(nullable = false)
    private Boolean aumentoProgramado;

    // nuevo salario tras aumento
    private Integer nuevoSalario;

    // relación con jugador
    @OneToOne
    @JoinColumn(name = "jugador_id", nullable = false, unique = true)
    private Jugador jugador;
}