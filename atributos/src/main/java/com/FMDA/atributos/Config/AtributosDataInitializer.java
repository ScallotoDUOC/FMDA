package com.FMDA.atributos.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import AngelYMilton.FMDataAnalisis.Atributos.Model.Atributos;
import AngelYMilton.FMDataAnalisis.Atributos.Repository.AtributosRepository;
import AngelYMilton.FMDataAnalisis.Jugador.Model.Jugador;
import AngelYMilton.FMDataAnalisis.Jugador.Repository.JugadorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(2)
@RequiredArgsConstructor
public class AtributosDataInitializer implements CommandLineRunner {

        private final AtributosRepository atributosRepository;
        private final JugadorRepository jugadorRepository;

        @Override
        public void run(String... args) {

                if (atributosRepository.count() > 0) {

                        log.info(
                                        ">>> Ya existen atributos, se omite carga.");

                        return;
                }

                // =====================================
                // FACUNDO TORRES
                // =====================================

                Jugador facundo = jugadorRepository.findByIu(29108066L)
                                .orElseThrow();

                Atributos a1 = new Atributos();

                a1.setJugador(facundo);

                // Fisicos
                a1.setAceleracion(16);
                a1.setAgilidad(15);
                a1.setAlcanceDeSalto(12);
                a1.setEquilibrio(14);
                a1.setFuerza(11);
                a1.setRecuperacionFisica(15);
                a1.setResistencia(16);
                a1.setVelocidad(16);

                // Mental
                a1.setAgresividad(10);
                a1.setAnticipacion(13);
                a1.setColocacion(11);
                a1.setConcentracion(14);
                a1.setDecisiones(15);
                a1.setDesmarques(16);
                a1.setDeterminacion(14);
                a1.setJuegoEnEquipo(15);
                a1.setLiderazgo(10);
                a1.setSacrificio(13);
                a1.setSerenidad(14);
                a1.setTalento(15);
                a1.setValentia(11);
                a1.setVision(15);

                // Tecnicos
                a1.setCabeceo(9);
                a1.setCentro(14);
                a1.setControl(16);
                a1.setEntradas(8);
                a1.setMarcaje(7);
                a1.setPases(15);
                a1.setPenaltis(10);
                a1.setRegate(16);
                a1.setRemate(13);
                a1.setSaquesDeEsquina(12);
                a1.setSaquesLargos(9);
                a1.setTecnica(16);
                a1.setTirosLejanos(13);
                a1.setTirosLibres(12);

                atributosRepository.save(a1);

                // =====================================
                // FEDERICO VALVERDE
                // =====================================

                Jugador fede = jugadorRepository.findByIu(29108067L)
                                .orElseThrow();

                Atributos a2 = new Atributos();

                a2.setJugador(fede);

                a2.setAceleracion(16);
                a2.setAgilidad(15);
                a2.setAlcanceDeSalto(13);
                a2.setEquilibrio(16);
                a2.setFuerza(15);
                a2.setRecuperacionFisica(17);
                a2.setResistencia(18);
                a2.setVelocidad(16);

                a2.setAgresividad(14);
                a2.setAnticipacion(15);
                a2.setColocacion(14);
                a2.setConcentracion(15);
                a2.setDecisiones(16);
                a2.setDesmarques(15);
                a2.setDeterminacion(17);
                a2.setJuegoEnEquipo(16);
                a2.setLiderazgo(13);
                a2.setSacrificio(17);
                a2.setSerenidad(15);
                a2.setTalento(15);
                a2.setValentia(16);
                a2.setVision(15);

                a2.setCabeceo(12);
                a2.setCentro(13);
                a2.setControl(15);
                a2.setEntradas(14);
                a2.setMarcaje(13);
                a2.setPases(16);
                a2.setPenaltis(12);
                a2.setRegate(14);
                a2.setRemate(13);
                a2.setSaquesDeEsquina(10);
                a2.setSaquesLargos(11);
                a2.setTecnica(15);
                a2.setTirosLejanos(16);
                a2.setTirosLibres(13);

                atributosRepository.save(a2);

                Jugador darwi = jugadorRepository.findByIu(29108068L)
                                .orElseThrow();

                Atributos a3 = new Atributos();

                a3.setJugador(darwi);

                a3.setAceleracion(18);
                a3.setAgilidad(15);
                a3.setAlcanceDeSalto(16);
                a3.setEquilibrio(16);
                a3.setFuerza(14);
                a3.setRecuperacionFisica(15);
                a3.setResistencia(14);
                a3.setVelocidad(17);

                a3.setAgresividad(14);
                a3.setAnticipacion(15);
                a3.setColocacion(14);
                a3.setConcentracion(11);
                a3.setDecisiones(18);
                a3.setDesmarques(18);
                a3.setDeterminacion(14);
                a3.setJuegoEnEquipo(11);
                a3.setLiderazgo(10);
                a3.setSacrificio(12);
                a3.setSerenidad(11);
                a3.setTalento(16);
                a3.setValentia(18);
                a3.setVision(12);

                a3.setCabeceo(14);
                a3.setCentro(9);
                a3.setControl(12);
                a3.setEntradas(7);
                a3.setMarcaje(8);
                a3.setPases(13);
                a3.setPenaltis(16);
                a3.setRegate(14);
                a3.setRemate(15);
                a3.setSaquesDeEsquina(8);
                a3.setSaquesLargos(12);
                a3.setTecnica(14);
                a3.setTirosLejanos(14);
                a3.setTirosLibres(10);

                atributosRepository.save(a3);

                log.info(
                                ">>> {} atributos insertados",
                                atributosRepository.count());
        }
}