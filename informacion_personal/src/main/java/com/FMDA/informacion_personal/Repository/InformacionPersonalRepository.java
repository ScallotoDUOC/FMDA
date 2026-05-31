package com.FMDA.informacion_personal.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AngelYMilton.FMDataAnalisis.Enums.Nacionalidad;
import AngelYMilton.FMDataAnalisis.Enums.Personalidad;
import AngelYMilton.FMDataAnalisis.InformacionPersonal.Model.InformacionPersonal;
import AngelYMilton.FMDataAnalisis.Jugador.Model.Jugador;

import java.util.List;

@Repository
public interface InformacionPersonalRepository
                extends JpaRepository<InformacionPersonal, Long> {

        // Buscar informacion personal por IU del jugador
        Optional<InformacionPersonal> findByJugadorIu(Long iu);

        // Verificar si un jugador ya tiene informacion personal
        boolean existsByJugadorId(Long jugadorId);

        // Buscar por nacionalidad
        List<InformacionPersonal> findByNacionalidad(
                        Nacionalidad nacionalidad);

        // Buscar por personalidad
        List<InformacionPersonal> findByPersonalidad(
                        Personalidad personalidad);

        // buscar por jugador
        Optional<InformacionPersonal> findByJugador(
                        Jugador jugador);
}