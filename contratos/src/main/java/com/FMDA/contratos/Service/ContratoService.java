package com.FMDA.contratos.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import AngelYMilton.FMDataAnalisis.Contratos.Dto.ContratoDTO;
import AngelYMilton.FMDataAnalisis.Contratos.Model.Contrato;
import AngelYMilton.FMDataAnalisis.Contratos.Repository.ContratoRepository;
import AngelYMilton.FMDataAnalisis.Jugador.Model.Jugador;
import AngelYMilton.FMDataAnalisis.Jugador.Repository.JugadorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContratoService {

    private final ContratoRepository contratoRepository;
    private final JugadorRepository jugadorRepository;

    // CREAR CONTRATO
    public Contrato crearContrato(ContratoDTO dto) {

        // Buscar jugador por IU
        Jugador jugador = jugadorRepository.findByIu(dto.getIu())
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));

        // Verificar si ya tiene contrato
        if (contratoRepository.existsByJugadorId(jugador.getId())) {
            throw new RuntimeException("El jugador ya tiene contrato");
        }

        // Crear contrato
        Contrato contrato = new Contrato();

        contrato.setJugador(jugador);
        contrato.setSalarioSemanal(dto.getSalarioSemanal());
        contrato.setFechaInicio(dto.getFechaInicio());
        contrato.setFechaFin(dto.getFechaFin());
        contrato.setTiempoJuego(dto.getTiempoJuego());
        contrato.setCedido(dto.getCedido());
        contrato.setOpcionExtension(dto.getOpcionExtension());
        contrato.setAumentoProgramado(dto.getAumentoProgramado());
        contrato.setNuevoSalario(dto.getNuevoSalario());

        return contratoRepository.save(contrato);
    }

    // OBTENER TODOS LOS CONTRATOS
    public List<Contrato> obtenerTodos() {
        return contratoRepository.findAll();
    }

    // BUSCAR CONTRATO POR IU DEL JUGADOR
    public Contrato buscarPorIU(Long iu) {

        return contratoRepository.findByJugadorIu(iu)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
    }

    // ELIMINAR CONTRATO
    public void eliminarContrato(Long id) {

        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));

        contratoRepository.delete(contrato);
    }

    // ACTUALIZAR CONTRATO
    public Contrato actualizarContrato(Long id, ContratoDTO dto) {

        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));

        contrato.setSalarioSemanal(dto.getSalarioSemanal());
        contrato.setFechaInicio(dto.getFechaInicio());
        contrato.setFechaFin(dto.getFechaFin());
        contrato.setTiempoJuego(dto.getTiempoJuego());
        contrato.setCedido(dto.getCedido());
        contrato.setOpcionExtension(dto.getOpcionExtension());
        contrato.setAumentoProgramado(dto.getAumentoProgramado());
        contrato.setNuevoSalario(dto.getNuevoSalario());

        return contratoRepository.save(contrato);
    }
}