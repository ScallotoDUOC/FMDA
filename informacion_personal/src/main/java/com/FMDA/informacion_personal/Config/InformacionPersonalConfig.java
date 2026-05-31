package com.FMDA.informacion_personal.Config;

import AngelYMilton.FMDataAnalisis.Enums.Nacionalidad;
import AngelYMilton.FMDataAnalisis.Enums.Personalidad;
import AngelYMilton.FMDataAnalisis.Enums.PiernaHabil;
import AngelYMilton.FMDataAnalisis.InformacionPersonal.Model.InformacionPersonal;
import AngelYMilton.FMDataAnalisis.InformacionPersonal.Repository.InformacionPersonalRepository;
import AngelYMilton.FMDataAnalisis.Jugador.Model.Jugador;
import AngelYMilton.FMDataAnalisis.Jugador.Repository.JugadorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InformacionPersonalConfig implements CommandLineRunner {

    private final InformacionPersonalRepository informacionPersonalRepository;
    private final JugadorRepository jugadorRepository;

    public InformacionPersonalConfig(
            InformacionPersonalRepository informacionPersonalRepository,
            JugadorRepository jugadorRepository) {

        this.informacionPersonalRepository = informacionPersonalRepository;
        this.jugadorRepository = jugadorRepository;
    }

    @Override
    public void run(String... args) {

        Jugador darwin = jugadorRepository.findByIu(29108068L)
                .orElse(null);

        if (darwin != null &&
                informacionPersonalRepository.findByJugador(darwin).isEmpty()) {

            InformacionPersonal info = new InformacionPersonal();

            info.setEdad(25);
            info.setNacionalidad(Nacionalidad.URUGUAYA);
            info.setAltura(187);
            info.setPeso(81);
            info.setPiernaHabil(PiernaHabil.DIESTRO);
            info.setPersonalidad(Personalidad.PROFESIONAL);
            info.setMediaDescription(
                    "Delantero uruguayo potente y veloz, con gran movilidad, desmarques y presión ofensiva.");

            info.setJugador(darwin);

            informacionPersonalRepository.save(info);
        }
        Jugador fede = jugadorRepository.findByIu(29108067L)
                .orElse(null);

        if (fede != null &&
                informacionPersonalRepository.findByJugador(fede).isEmpty()) {

            InformacionPersonal info = new InformacionPersonal();

            info.setEdad(26);
            info.setNacionalidad(Nacionalidad.URUGUAYA);
            info.setAltura(182);
            info.setPeso(78);
            info.setPiernaHabil(PiernaHabil.DIESTRO);
            info.setPersonalidad(Personalidad.PROFESIONAL);
            info.setMediaDescription("Centrocampista, incansable box to box");

            info.setJugador(fede);

            informacionPersonalRepository.save(info);
        }
        Jugador facundo = jugadorRepository.findByIu(29108067L)
                .orElse(null);

        if (facundo != null &&
                informacionPersonalRepository.findByJugador(facundo).isEmpty()) {

            InformacionPersonal info = new InformacionPersonal();

            info.setEdad(25);
            info.setNacionalidad(Nacionalidad.URUGUAYA);
            info.setAltura(178);
            info.setPeso(71);
            info.setPiernaHabil(PiernaHabil.ZURDO);
            info.setPersonalidad(Personalidad.ALEGRE);
            info.setMediaDescription("Prolifico extremo");

            info.setJugador(facundo);

            informacionPersonalRepository.save(info);
        }
    }

}