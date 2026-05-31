package com.FMDA.resena.Config;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.FMDA.resena.Model.Resena;
import com.FMDA.resena.Repository.ResenaRepository;

@Configuration
public class ResenaConfig {

    @Bean
    CommandLineRunner cargarResenas(
            ResenaRepository resenaRepository) {

        return args -> {

            // Reseña de Angel
            if (resenaRepository.findByUsuario("angel") == null) {

                Resena resenaAngel = new Resena();
                resenaAngel.setUsuario("angel");
                resenaAngel.setCalificacion(5);
                resenaAngel.setComentario(
                        "Muy buena aplicación para analizar jugadores y administrar la partida.");
                resenaAngel.setFecharesena(LocalDateTime.now());

                resenaRepository.save(resenaAngel);
            }

            // Reseña de Milton
            if (resenaRepository.findByUsuario("milton") == null) {

                Resena resenaMilton = new Resena();
                resenaMilton.setUsuario("milton");
                resenaMilton.setCalificacion(4);
                resenaMilton.setComentario(
                        "Muy útil para seguir estadísticas y contratos de jugadores.");
                resenaMilton.setFecharesena(LocalDateTime.now());

                resenaRepository.save(resenaMilton);
            }

            // Reseña extra
            if (resenaRepository.findByUsuario("invitado") == null) {

                Resena resenaInvitado = new Resena();
                resenaInvitado.setUsuario("invitado");
                resenaInvitado.setCalificacion(5);
                resenaInvitado.setComentario(
                        "Interfaz clara y muy cómoda para gestionar el equipo.");
                resenaInvitado.setFecharesena(LocalDateTime.now());

                resenaRepository.save(resenaInvitado);
            }
        };
    }
}