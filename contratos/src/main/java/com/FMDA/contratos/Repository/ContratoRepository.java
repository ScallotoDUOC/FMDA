package com.FMDA.contratos.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AngelYMilton.FMDataAnalisis.Contratos.Model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

    // Buscar contrato por ID del jugador
    Optional<Contrato> findByJugadorId(Long jugadorId);

    // Buscar contrato por IU del jugador
    Optional<Contrato> findByJugadorIu(Long iu);

    // Verificar si un jugador ya tiene contrato registrado
    boolean existsByJugadorId(Long jugadorId);
}