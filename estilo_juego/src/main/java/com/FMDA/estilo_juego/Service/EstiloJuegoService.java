package com.FMDA.estilo_juego.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AngelYMilton.FMDataAnalisis.Atributos.Model.Atributos;
import AngelYMilton.FMDataAnalisis.Atributos.Repository.AtributosRepository;
import AngelYMilton.FMDataAnalisis.Enums.EstiloJuego;
import AngelYMilton.FMDataAnalisis.InformacionPersonal.Model.InformacionPersonal;
import AngelYMilton.FMDataAnalisis.InformacionPersonal.Repository.InformacionPersonalRepository;
import AngelYMilton.FMDataAnalisis.Jugador.Model.Jugador;
import AngelYMilton.FMDataAnalisis.Jugador.Repository.JugadorRepository;
import AngelYMilton.FMDataAnalisis.EstiloJuego.dto.EstiloJuegoResponseDTO;

@Service
public class EstiloJuegoService {

        @Autowired
        private JugadorRepository jugadorRepository;

        @Autowired
        private AtributosRepository atributosRepository;

        @Autowired
        private InformacionPersonalRepository informacionPersonalRepository;

        public EstiloJuegoResponseDTO calcularMejorEstilo(Long iu) {

                // =========================
                // BUSCAR JUGADOR
                // =========================

                Jugador jugador = jugadorRepository
                                .findByIu(iu)
                                .orElseThrow(() -> new RuntimeException(
                                                "Jugador no encontrado"));

                // =========================
                // BUSCAR ATRIBUTOS
                // =========================

                Atributos atributos = atributosRepository
                                .findByJugadorIu(iu)
                                .orElseThrow(() -> new RuntimeException(
                                                "Atributos no encontrados"));

                // =========================
                // BUSCAR INFORMACION PERSONAL
                // =========================

                InformacionPersonal info = informacionPersonalRepository
                                .findByJugadorIu(iu)
                                .orElseThrow(() -> new RuntimeException(
                                                "Información personal no encontrada"));

                // =========================
                // MAP DE ESTILOS
                // =========================

                Map<EstiloJuego, Double> rankingEstilos = new HashMap<>();

                // =========================
                // CALCULOS
                // =========================

                rankingEstilos.put(
                                EstiloJuego.GEGENPRESSING,
                                calcularGegenpressing(atributos));

                rankingEstilos.put(
                                EstiloJuego.CONTROL_POSESION,
                                calcularControlPosesion(atributos));

                rankingEstilos.put(
                                EstiloJuego.BLOQUE_BAJO_DEFENSIVO,
                                calcularBloqueBajo(atributos));

                // =========================
                // BUSCAR MEJOR ESTILO
                // =========================

                EstiloJuego mejorEstilo = null;

                double mejorPuntuacion = 0;

                for (Map.Entry<EstiloJuego, Double> entry : rankingEstilos.entrySet()) {

                        if (entry.getValue() > mejorPuntuacion) {

                                mejorPuntuacion = entry.getValue();

                                mejorEstilo = entry.getKey();
                        }
                }

                // =========================
                // CREAR RESPONSE DTO
                // =========================

                EstiloJuegoResponseDTO response = new EstiloJuegoResponseDTO();

                response.setFullName(
                                jugador.getFullName());

                response.setEdad(
                                info.getEdad());

                response.setPersonalidad(
                                info.getPersonalidad());

                response.setMejorEstilo(
                                mejorEstilo);

                response.setPuntuacionMejorEstilo(
                                mejorPuntuacion);

                response.setRankingEstilos(
                                rankingEstilos);

                return response;
        }

        // =====================================================
        // FORMULAS
        // =====================================================

        private double calcularGegenpressing(Atributos a) {

                return ((a.getResistencia() * 3)
                                +
                                (a.getAceleracion() * 3)
                                +
                                (a.getVelocidad() * 2)
                                +
                                (a.getAgresividad() * 2)
                                +
                                (a.getSacrificio() * 3)
                                +
                                (a.getJuegoEnEquipo() * 2)
                                +
                                (a.getConcentracion() * 2)) / 17.0;
        }

        private double calcularControlPosesion(Atributos a) {

                return ((a.getPases() * 3)
                                +
                                (a.getTecnica() * 3)
                                +
                                (a.getControl() * 3)
                                +
                                (a.getVision() * 3)
                                +
                                (a.getDecisiones() * 2)
                                +
                                (a.getSerenidad() * 2)
                                +
                                (a.getJuegoEnEquipo() * 2)) / 18.0;
        }

        private double calcularBloqueBajo(Atributos a) {

                return ((a.getMarcaje() * 3)
                                +
                                (a.getEntradas() * 3)
                                +
                                (a.getColocacion() * 3)
                                +
                                (a.getConcentracion() * 2)
                                +
                                (a.getCabeceo() * 2)
                                +
                                (a.getFuerza() * 2)
                                +
                                (a.getPases() * 2)
                                +
                                (a.getValentia() * 2)) / 19.0;
        }
}