package com.FMDA.ponderacion_general.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.ponderacionGeneral.dto.PonderacionGeneralResponseDTO;
import com.microservicio.jugador.Model.Jugador;

@Service
public class PonderacionGeneralService {

        @Autowired
        private JugadorRepository jugadorRepository;

        @Autowired
        private AtributosRepository atributosRepository;

        @Autowired
        private InformacionPersonalRepository informacionPersonalRepository;

        public PonderacionGeneralResponseDTO calcularPonderacionGeneral(Long iu) {

                // Buscar jugador
                Jugador jugador = jugadorRepository.findByIu(iu)
                                .orElseThrow(() -> new RuntimeException(
                                                "Jugador no encontrado"));

                // Buscar atributos
                Atributos atributos = atributosRepository.findByJugadorIu(iu)
                                .orElseThrow(() -> new RuntimeException(
                                                "Atributos no encontrados"));

                // Buscar informacion personal
                InformacionPersonal info = informacionPersonalRepository
                                .findByJugadorIu(iu)
                                .orElseThrow(() -> new RuntimeException(
                                                "Información personal no encontrada"));

                // =========================
                // PROMEDIO FISICO
                // =========================

                double promedioFisico = (atributos.getAceleracion()
                                + atributos.getAgilidad()
                                + atributos.getAlcanceDeSalto()
                                + atributos.getEquilibrio()
                                + atributos.getFuerza()
                                + atributos.getRecuperacionFisica()
                                + atributos.getResistencia()
                                + atributos.getVelocidad()) / 8.0;

                // =========================
                // PROMEDIO MENTAL
                // =========================

                double promedioMental = (atributos.getAgresividad()
                                + atributos.getAnticipacion()
                                + atributos.getColocacion()
                                + atributos.getConcentracion()
                                + atributos.getDecisiones()
                                + atributos.getDesmarques()
                                + atributos.getDeterminacion()
                                + atributos.getJuegoEnEquipo()
                                + atributos.getLiderazgo()
                                + atributos.getSacrificio()
                                + atributos.getSerenidad()
                                + atributos.getTalento()
                                + atributos.getValentia()
                                + atributos.getVision()) / 14.0;

                // =========================
                // PROMEDIO TECNICO
                // =========================

                double promedioTecnico = (atributos.getCabeceo()
                                + atributos.getCentro()
                                + atributos.getEntradas()
                                + atributos.getMarcaje()
                                + atributos.getPases()
                                + atributos.getControl()
                                + atributos.getPenaltis()
                                + atributos.getRegate()
                                + atributos.getRemate()
                                + atributos.getSaquesDeEsquina()
                                + atributos.getSaquesLargos()
                                + atributos.getTecnica()
                                + atributos.getTirosLejanos()
                                + atributos.getTirosLibres()) / 14.0;

                // =========================
                // PROMEDIO GENERAL
                // =========================

                double promedioGeneral = (promedioFisico
                                + promedioMental
                                + promedioTecnico) / 3.0;

                // =========================
                // CREAR RESPONSE DTO
                // =========================

                PonderacionGeneralResponseDTO response = new PonderacionGeneralResponseDTO();

                response.setNombreJugador(
                                jugador.getFullName());

                response.setPromedioFisico(
                                promedioFisico);

                response.setPromedioMental(
                                promedioMental);

                response.setPromedioTecnico(
                                promedioTecnico);

                response.setPromedioGeneral(
                                promedioGeneral);

                response.setEdad(
                                info.getEdad());

                response.setPersonalidad(
                                info.getPersonalidad());

                return response;
        }
}