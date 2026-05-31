package com.FMDA.mejor_posicion.MejorPosicionService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AngelYMilton.FMDataAnalisis.Atributos.Model.Atributos;
import AngelYMilton.FMDataAnalisis.Atributos.Repository.AtributosRepository;
import AngelYMilton.FMDataAnalisis.Enums.Posiciones;
import AngelYMilton.FMDataAnalisis.InformacionPersonal.Model.InformacionPersonal;
import AngelYMilton.FMDataAnalisis.InformacionPersonal.Repository.InformacionPersonalRepository;
import AngelYMilton.FMDataAnalisis.Jugador.Model.Jugador;
import AngelYMilton.FMDataAnalisis.Jugador.Repository.JugadorRepository;
import AngelYMilton.FMDataAnalisis.MejorPosicion.dto.MejorPosicionResponseDTO;

@Service
public class MejorPosicionService {

        @Autowired
        private JugadorRepository jugadorRepository;

        @Autowired
        private AtributosRepository atributosRepository;

        @Autowired
        private InformacionPersonalRepository informacionPersonalRepository;

        public MejorPosicionResponseDTO calcularMejorPosicion(Long iu) {

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
                // MAP DE PUNTUACIONES
                // =========================

                Map<Posiciones, Double> rankingPosiciones = new HashMap<>();

                // =========================
                // CALCULOS
                // =========================

                rankingPosiciones.put(
                                Posiciones.EXTREMO_BANDA,
                                calcularExtremoBanda(atributos));

                rankingPosiciones.put(
                                Posiciones.EXTREMO_INVERSO,
                                calcularExtremoInverso(atributos));

                rankingPosiciones.put(
                                Posiciones.CENTRAL_TRADICIONAL,
                                calcularCentralTradicional(atributos));

                rankingPosiciones.put(
                                Posiciones.PIVOTE_DEFENSIVO,
                                calcularPivoteDefensivo(atributos));

                rankingPosiciones.put(
                                Posiciones.DELANTERO_AVANZADO,
                                calcularDelanteroAvanzado(atributos));

                rankingPosiciones.put(
                                Posiciones.BOX_TO_BOX,
                                calcularBoxToBox(atributos));

                rankingPosiciones.put(
                                Posiciones.ORGANIZADOR_OFENSIVO,
                                calcularOrganizadorOfensivo(atributos));
                // =========================
                // CALCULOS
                // =========================

                // ======================================
                // DEFENSAS CENTRALES
                // ======================================

                rankingPosiciones.put(
                                Posiciones.CENTRAL_TRADICIONAL,
                                calcularCentralTradicional(atributos));

                rankingPosiciones.put(
                                Posiciones.CENTRAL_MODERNO,
                                calcularCentralModerno(atributos));

                rankingPosiciones.put(
                                Posiciones.CENTRAL_LIBERO,
                                calcularCentralLibero(atributos));

                rankingPosiciones.put(
                                Posiciones.CENTRAL_LATERAL,
                                calcularCentralLateral(atributos));

                // ======================================
                // LATERALES
                // ======================================

                rankingPosiciones.put(
                                Posiciones.LATERAL,
                                calcularLateral(atributos));

                rankingPosiciones.put(
                                Posiciones.CARRILERO,
                                calcularCarrilero(atributos));

                rankingPosiciones.put(
                                Posiciones.CARILLERO_INVERSO,
                                calcularCarrileroInverso(atributos));

                // ======================================
                // EXTREMOS
                // ======================================

                rankingPosiciones.put(
                                Posiciones.EXTREMO_BANDA,
                                calcularExtremoBanda(atributos));

                rankingPosiciones.put(
                                Posiciones.EXTREMO_INVERSO,
                                calcularExtremoInverso(atributos));

                rankingPosiciones.put(
                                Posiciones.ORGANIZADOR_BANDA,
                                calcularOrganizadorBanda(atributos));

                // ======================================
                // CENTROCAMPISTAS
                // ======================================

                rankingPosiciones.put(
                                Posiciones.PIVOTE_ORGANIZADOR,
                                calcularPivoteOrganizador(atributos));

                rankingPosiciones.put(
                                Posiciones.ORGANIZADOR_OFENSIVO,
                                calcularOrganizadorOfensivo(atributos));

                rankingPosiciones.put(
                                Posiciones.CENTROCAMPISTA_RECUPERADOR,
                                calcularCentrocampistaRecuperador(atributos));

                rankingPosiciones.put(
                                Posiciones.PIVOTE_DEFENSIVO,
                                calcularPivoteDefensivo(atributos));

                rankingPosiciones.put(
                                Posiciones.BOX_TO_BOX,
                                calcularBoxToBox(atributos));

                rankingPosiciones.put(
                                Posiciones.CENTROCAMPISTA_OFENSIVO,
                                calcularCentrocampistaOfensivo(atributos));

                // ======================================
                // ATAQUE
                // ======================================

                rankingPosiciones.put(
                                Posiciones.DELANTERO_INTERIOR,
                                calcularDelanteroInterior(atributos));

                rankingPosiciones.put(
                                Posiciones.MEDIAPUNTA,
                                calcularMediapunta(atributos));

                rankingPosiciones.put(
                                Posiciones.DELANTERO_RATON,
                                calcularDelanteroRaton(atributos));

                rankingPosiciones.put(
                                Posiciones.DELANTERO_APOYO,
                                calcularDelanteroApoyo(atributos));

                rankingPosiciones.put(
                                Posiciones.DELANTERO_OBJETIVO,
                                calcularDelanteroObjetivo(atributos));

                rankingPosiciones.put(
                                Posiciones.DELANTERO_AVANZADO,
                                calcularDelanteroAvanzado(atributos));

                rankingPosiciones.put(
                                Posiciones.FALSO_9,
                                calcularFalso9(atributos));

                rankingPosiciones.put(
                                Posiciones.DELANTERO_PRESION,
                                calcularDelanteroPresion(atributos));

                rankingPosiciones.put(
                                Posiciones.ARIETE,
                                calcularAriete(atributos));

                rankingPosiciones.put(
                                Posiciones.DELANTERO_COMPLETO,
                                calcularDelanteroCompleto(atributos));

                // =========================
                // BUSCAR MEJOR POSICION
                // =========================

                Posiciones mejorPosicion = null;

                double mejorPuntuacion = 0;

                for (Map.Entry<Posiciones, Double> entry : rankingPosiciones.entrySet()) {

                        if (entry.getValue() > mejorPuntuacion) {

                                mejorPuntuacion = entry.getValue();

                                mejorPosicion = entry.getKey();
                        }
                }

                // =========================
                // CREAR RESPONSE
                // =========================

                MejorPosicionResponseDTO response = new MejorPosicionResponseDTO();

                response.setFullName(
                                jugador.getFullName());

                response.setEdad(
                                info.getEdad());

                response.setPersonalidad(
                                info.getPersonalidad());

                response.setMejorRol(
                                mejorPosicion);

                response.setPuntuacionMejorRol(
                                mejorPuntuacion);

                response.setRankingRoles(
                                rankingPosiciones);

                return response;
        }

        // =====================================================
        // FORMULAS
        // =====================================================

        private double calcularExtremoBanda(Atributos a) {

                return ((a.getVelocidad() * 3)
                                +
                                (a.getAceleracion() * 3)
                                +
                                (a.getRegate() * 3)
                                +
                                (a.getCentro() * 3)
                                +
                                (a.getTecnica() * 2)
                                +
                                (a.getDesmarques() * 2)) / 16.0;
        }

        private double calcularExtremoInverso(Atributos a) {

                return ((a.getVelocidad() * 3)
                                +
                                (a.getAceleracion() * 3)
                                +
                                (a.getRegate() * 3)
                                +
                                (a.getRemate() * 3)
                                +
                                (a.getTecnica() * 2)
                                +
                                (a.getTirosLejanos() * 2)) / 16.0;
        }

        private double calcularCentralTradicional(Atributos a) {

                return ((a.getMarcaje() * 3)
                                +
                                (a.getEntradas() * 3)
                                +
                                (a.getCabeceo() * 3)
                                +
                                (a.getFuerza() * 2)
                                +
                                (a.getColocacion() * 2)
                                +
                                (a.getConcentracion() * 2)
                                +
                                (a.getValentia() * 2)) / 17.0;
        }

        private double calcularPivoteDefensivo(Atributos a) {

                return ((a.getMarcaje() * 3)
                                +
                                (a.getEntradas() * 3)
                                +
                                (a.getColocacion() * 3)
                                +
                                (a.getConcentracion() * 2)
                                +
                                (a.getPases() * 2)
                                +
                                (a.getJuegoEnEquipo() * 2)
                                +
                                (a.getDecisiones() * 2)) / 17.0;
        }

        private double calcularDelanteroAvanzado(Atributos a) {

                return ((a.getRemate() * 3)
                                +
                                (a.getDesmarques() * 3)
                                +
                                (a.getVelocidad() * 3)
                                +
                                (a.getAceleracion() * 3)
                                +
                                (a.getSerenidad() * 2)
                                +
                                (a.getTecnica() * 2)) / 16.0;
        }

        private double calcularBoxToBox(Atributos a) {

                return ((a.getResistencia() * 3)
                                +
                                (a.getJuegoEnEquipo() * 3)
                                +
                                (a.getPases() * 2)
                                +
                                (a.getEntradas() * 2)
                                +
                                (a.getDecisiones() * 2)
                                +
                                (a.getTecnica() * 2)
                                +
                                (a.getSacrificio() * 2)) / 16.0;
        }

        private double calcularOrganizadorOfensivo(Atributos a) {

                return ((a.getVision() * 3)
                                +
                                (a.getPases() * 3)
                                +
                                (a.getTecnica() * 3)
                                +
                                (a.getTalento() * 3)
                                +
                                (a.getDecisiones() * 2)
                                +
                                (a.getSerenidad() * 2)) / 16.0;
        }
        // =====================================================
        // NUEVAS FORMULAS
        // =====================================================

        private double calcularCentralModerno(Atributos a) {

                return ((a.getMarcaje() * 3)
                                +
                                (a.getEntradas() * 3)
                                +
                                (a.getPases() * 2)
                                +
                                (a.getTecnica() * 2)
                                +
                                (a.getColocacion() * 2)
                                +
                                (a.getConcentracion() * 2)
                                +
                                (a.getVision() * 2)) / 16.0;
        }

        private double calcularCentralLibero(Atributos a) {

                return ((a.getMarcaje() * 2)
                                +
                                (a.getEntradas() * 2)
                                +
                                (a.getPases() * 3)
                                +
                                (a.getVision() * 3)
                                +
                                (a.getTecnica() * 2)
                                +
                                (a.getDecisiones() * 2)
                                +
                                (a.getControl() * 2)) / 16.0;
        }

        private double calcularCentralLateral(Atributos a) {

                return ((a.getVelocidad() * 2)
                                +
                                (a.getAceleracion() * 2)
                                +
                                (a.getMarcaje() * 3)
                                +
                                (a.getEntradas() * 3)
                                +
                                (a.getCentro() * 2)
                                +
                                (a.getResistencia() * 2)) / 14.0;
        }

        private double calcularLateral(Atributos a) {

                return ((a.getVelocidad() * 3)
                                +
                                (a.getAceleracion() * 3)
                                +
                                (a.getCentro() * 3)
                                +
                                (a.getEntradas() * 2)
                                +
                                (a.getResistencia() * 2)
                                +
                                (a.getJuegoEnEquipo() * 2)) / 15.0;
        }

        private double calcularCarrilero(Atributos a) {

                return ((a.getVelocidad() * 3)
                                +
                                (a.getAceleracion() * 3)
                                +
                                (a.getCentro() * 3)
                                +
                                (a.getRegate() * 2)
                                +
                                (a.getTecnica() * 2)
                                +
                                (a.getResistencia() * 3)) / 16.0;
        }

        private double calcularCarrileroInverso(Atributos a) {

                return ((a.getPases() * 3)
                                +
                                (a.getVision() * 3)
                                +
                                (a.getTecnica() * 3)
                                +
                                (a.getControl() * 3)
                                +
                                (a.getDecisiones() * 2)
                                +
                                (a.getJuegoEnEquipo() * 2)) / 16.0;
        }

        private double calcularOrganizadorBanda(Atributos a) {

                return ((a.getPases() * 3)
                                +
                                (a.getVision() * 3)
                                +
                                (a.getTecnica() * 3)
                                +
                                (a.getRegate() * 2)
                                +
                                (a.getControl() * 2)
                                +
                                (a.getDecisiones() * 2)) / 15.0;
        }

        private double calcularPivoteOrganizador(Atributos a) {

                return ((a.getPases() * 3)
                                +
                                (a.getVision() * 3)
                                +
                                (a.getDecisiones() * 3)
                                +
                                (a.getTecnica() * 2)
                                +
                                (a.getColocacion() * 2)
                                +
                                (a.getConcentracion() * 2)) / 15.0;
        }

        private double calcularCentrocampistaRecuperador(Atributos a) {

                return ((a.getEntradas() * 3)
                                +
                                (a.getMarcaje() * 3)
                                +
                                (a.getAgresividad() * 3)
                                +
                                (a.getResistencia() * 2)
                                +
                                (a.getSacrificio() * 2)
                                +
                                (a.getConcentracion() * 2)) / 15.0;
        }

        private double calcularCentrocampistaOfensivo(Atributos a) {

                return ((a.getVision() * 3)
                                +
                                (a.getPases() * 3)
                                +
                                (a.getTecnica() * 3)
                                +
                                (a.getControl() * 3)
                                +
                                (a.getTalento() * 2)
                                +
                                (a.getDesmarques() * 2)) / 16.0;
        }

        private double calcularDelanteroInterior(Atributos a) {

                return ((a.getRegate() * 3)
                                +
                                (a.getRemate() * 3)
                                +
                                (a.getAceleracion() * 3)
                                +
                                (a.getVelocidad() * 2)
                                +
                                (a.getTecnica() * 2)
                                +
                                (a.getDesmarques() * 2)) / 15.0;
        }

        private double calcularMediapunta(Atributos a) {

                return ((a.getVision() * 3)
                                +
                                (a.getPases() * 3)
                                +
                                (a.getTecnica() * 3)
                                +
                                (a.getControl() * 3)
                                +
                                (a.getTalento() * 2)
                                +
                                (a.getSerenidad() * 2)) / 16.0;
        }

        private double calcularDelanteroRaton(Atributos a) {

                return ((a.getAceleracion() * 3)
                                +
                                (a.getVelocidad() * 3)
                                +
                                (a.getDesmarques() * 3)
                                +
                                (a.getRemate() * 2)
                                +
                                (a.getAgilidad() * 2)) / 13.0;
        }

        private double calcularDelanteroApoyo(Atributos a) {

                return ((a.getPases() * 2)
                                +
                                (a.getVision() * 2)
                                +
                                (a.getTecnica() * 3)
                                +
                                (a.getControl() * 3)
                                +
                                (a.getJuegoEnEquipo() * 2)
                                +
                                (a.getFuerza() * 2)) / 14.0;
        }

        private double calcularDelanteroObjetivo(Atributos a) {

                return ((a.getCabeceo() * 3)
                                +
                                (a.getFuerza() * 3)
                                +
                                (a.getAlcanceDeSalto() * 3)
                                +
                                (a.getRemate() * 2)
                                +
                                (a.getValentia() * 2)) / 13.0;
        }

        private double calcularFalso9(Atributos a) {

                return ((a.getPases() * 3)
                                +
                                (a.getVision() * 3)
                                +
                                (a.getTecnica() * 3)
                                +
                                (a.getControl() * 3)
                                +
                                (a.getDesmarques() * 2)
                                +
                                (a.getDecisiones() * 2)) / 16.0;
        }

        private double calcularDelanteroPresion(Atributos a) {

                return ((a.getResistencia() * 3)
                                +
                                (a.getAgresividad() * 3)
                                +
                                (a.getSacrificio() * 3)
                                +
                                (a.getAceleracion() * 2)
                                +
                                (a.getVelocidad() * 2)
                                +
                                (a.getJuegoEnEquipo() * 2)) / 15.0;
        }

        private double calcularAriete(Atributos a) {

                return ((a.getFuerza() * 3)
                                +
                                (a.getRemate() * 3)
                                +
                                (a.getCabeceo() * 3)
                                +
                                (a.getValentia() * 2)
                                +
                                (a.getAlcanceDeSalto() * 2)) / 13.0;
        }

        private double calcularDelanteroCompleto(Atributos a) {

                return ((a.getRemate() * 3)
                                +
                                (a.getTecnica() * 3)
                                +
                                (a.getPases() * 2)
                                +
                                (a.getControl() * 2)
                                +
                                (a.getVelocidad() * 2)
                                +
                                (a.getFuerza() * 2)
                                +
                                (a.getVision() * 2)) / 16.0;
        }

}