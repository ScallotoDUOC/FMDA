package com.FMDA.contratos.Config;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import AngelYMilton.FMDataAnalisis.Contratos.Model.Contrato;
import AngelYMilton.FMDataAnalisis.Contratos.Repository.ContratoRepository;
import AngelYMilton.FMDataAnalisis.Enums.TiempoJuego;
import AngelYMilton.FMDataAnalisis.Jugador.Model.Jugador;
import AngelYMilton.FMDataAnalisis.Jugador.Repository.JugadorRepository;

@Configuration
public class ContratoConfig {

    @Bean
    CommandLineRunner cargarContratos(
            ContratoRepository contratoRepository,
            JugadorRepository jugadorRepository) {

        return args -> {

            // Darwin Núñez
            Jugador darwin = jugadorRepository.findByIu(29108068L)
                    .orElseThrow(() -> new RuntimeException("Jugador Darwin Núñez no encontrado"));

            if (!contratoRepository.existsByJugadorId(darwin.getId())) {

                Contrato contratoDarwin = new Contrato();
                contratoDarwin.setSalarioSemanal(180000);
                contratoDarwin.setFechaInicio(LocalDate.of(2024, 7, 1));
                contratoDarwin.setFechaFin(LocalDate.of(2028, 6, 30));
                contratoDarwin.setTiempoJuego(TiempoJuego.TITULAR_HABITUAL);
                contratoDarwin.setCedido(false);
                contratoDarwin.setOpcionExtension(true);
                contratoDarwin.setAumentoProgramado(true);
                contratoDarwin.setNuevoSalario(210000);
                contratoDarwin.setJugador(darwin);

                contratoRepository.save(contratoDarwin);
            }

            // Federico Valverde
            Jugador fede = jugadorRepository.findByIu(29108067L)
                    .orElseThrow(() -> new RuntimeException("Jugador Federico Valverde no encontrado"));

            if (!contratoRepository.existsByJugadorId(fede.getId())) {

                Contrato contratoFede = new Contrato();
                contratoFede.setSalarioSemanal(200000);
                contratoFede.setFechaInicio(LocalDate.of(2024, 7, 1));
                contratoFede.setFechaFin(LocalDate.of(2029, 6, 30));
                contratoFede.setTiempoJuego(TiempoJuego.JUGADOR_ESTRELLA);
                contratoFede.setCedido(false);
                contratoFede.setOpcionExtension(true);
                contratoFede.setAumentoProgramado(true);
                contratoFede.setNuevoSalario(210000);
                contratoFede.setJugador(fede);

                contratoRepository.save(contratoFede);
            }

            // Facundo
            Jugador facundo = jugadorRepository.findByIu(29108066L)
                    .orElseThrow(() -> new RuntimeException("Jugador Facundo no encontrado"));

            if (!contratoRepository.existsByJugadorId(facundo.getId())) {

                Contrato contratoFacundo = new Contrato();
                contratoFacundo.setSalarioSemanal(30000);
                contratoFacundo.setFechaInicio(LocalDate.of(2025, 7, 1));
                contratoFacundo.setFechaFin(LocalDate.of(2030, 6, 30));
                contratoFacundo.setTiempoJuego(TiempoJuego.PROMESA_IMPORTANTE);
                contratoFacundo.setCedido(true);
                contratoFacundo.setOpcionExtension(true);
                contratoFacundo.setAumentoProgramado(null);
                contratoFacundo.setNuevoSalario(null);
                contratoFacundo.setJugador(facundo);

                contratoRepository.save(contratoFacundo);
            }
        };
    }
}