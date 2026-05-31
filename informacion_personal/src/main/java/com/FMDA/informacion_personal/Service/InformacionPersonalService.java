package com.FMDA.informacion_personal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AngelYMilton.FMDataAnalisis.InformacionPersonal.dto.InformacionPersonalDTO;
import AngelYMilton.FMDataAnalisis.InformacionPersonal.Model.InformacionPersonal;
import AngelYMilton.FMDataAnalisis.InformacionPersonal.Repository.InformacionPersonalRepository;
import AngelYMilton.FMDataAnalisis.Jugador.Model.Jugador;
import AngelYMilton.FMDataAnalisis.Jugador.Repository.JugadorRepository;

@Service
public class InformacionPersonalService {

        @Autowired
        private InformacionPersonalRepository informacionPersonalRepository;

        @Autowired
        private JugadorRepository jugadorRepository;

        // CREAR INFORMACION PERSONAL
        public InformacionPersonal crearInformacionPersonal(
                        InformacionPersonalDTO dto) {

                // Buscar jugador por IU
                Jugador jugador = jugadorRepository.findByIu(dto.getIu())
                                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));

                // Verificar si ya existe informacion personal
                if (informacionPersonalRepository.existsByJugadorId(jugador.getId())) {

                        throw new RuntimeException(
                                        "El jugador ya tiene información personal registrada");
                }

                // Crear entidad
                InformacionPersonal informacionPersonal = new InformacionPersonal();

                informacionPersonal.setJugador(jugador);
                informacionPersonal.setEdad(dto.getEdad());
                informacionPersonal.setNacionalidad(dto.getNacionalidad());
                informacionPersonal.setAltura(dto.getAltura());
                informacionPersonal.setPeso(dto.getPeso());
                informacionPersonal.setPiernaHabil(dto.getPiernaHabil());
                informacionPersonal.setPersonalidad(dto.getPersonalidad());
                informacionPersonal.setMediaDescription(
                                dto.getMediaDescription());

                return informacionPersonalRepository.save(
                                informacionPersonal);
        }

        // OBTENER TODOS
        public List<InformacionPersonal> obtenerTodos() {

                return informacionPersonalRepository.findAll();
        }

        // BUSCAR POR ID
        public InformacionPersonal buscarPorId(Long id) {

                return informacionPersonalRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException(
                                                "Información personal no encontrada"));
        }

        // BUSCAR POR IU
        public InformacionPersonal buscarPorIU(Long iu) {

                return informacionPersonalRepository.findByJugadorIu(iu)
                                .orElseThrow(() -> new RuntimeException(
                                                "Información personal no encontrada"));
        }

        // ACTUALIZAR
        public InformacionPersonal actualizarInformacionPersonal(
                        Long id,
                        InformacionPersonalDTO dto) {

                InformacionPersonal informacionPersonal = informacionPersonalRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException(
                                                "Información personal no encontrada"));

                informacionPersonal.setEdad(dto.getEdad());
                informacionPersonal.setNacionalidad(dto.getNacionalidad());
                informacionPersonal.setAltura(dto.getAltura());
                informacionPersonal.setPeso(dto.getPeso());
                informacionPersonal.setPiernaHabil(dto.getPiernaHabil());
                informacionPersonal.setPersonalidad(dto.getPersonalidad());
                informacionPersonal.setMediaDescription(
                                dto.getMediaDescription());

                return informacionPersonalRepository.save(
                                informacionPersonal);
        }

        // ELIMINAR
        public void eliminarInformacionPersonal(Long id) {

                InformacionPersonal informacionPersonal = informacionPersonalRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException(
                                                "Información personal no encontrada"));

                informacionPersonalRepository.delete(informacionPersonal);
        }
}