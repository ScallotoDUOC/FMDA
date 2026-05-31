package com.FMDA.analisis_salarial.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AngelYMilton.FMDataAnalisis.AnalisisSalarial.Model.AnalisisSalarial;
import AngelYMilton.FMDataAnalisis.AnalisisSalarial.Repository.AnalisisSalarialRepository;
import AngelYMilton.FMDataAnalisis.Contratos.Model.Contrato;
import AngelYMilton.FMDataAnalisis.Contratos.Repository.ContratoRepository;

@Service
public class AnalisisSalarialService {

        @Autowired
        private AnalisisSalarialRepository analisisSalarialRepository;

        @Autowired
        private ContratoRepository contratoRepository;

        // GENERAR ANALISIS AUTOMATICO
        public List<AnalisisSalarial> analizarSalarios() {

                List<Contrato> contratos = contratoRepository.findAll();

                List<AnalisisSalarial> inconsistencias = new ArrayList<>();

                // Comparar todos los contratos
                for (Contrato contratoA : contratos) {

                        for (Contrato contratoB : contratos) {

                                // Evitar compararse consigo mismo
                                if (contratoA.getId().equals(
                                                contratoB.getId())) {
                                        continue;
                                }

                                // Prioridades
                                int prioridadA = contratoA.getTiempoJuego()
                                                .getPrioridad();

                                int prioridadB = contratoB.getTiempoJuego()
                                                .getPrioridad();

                                // Salarios
                                Integer salarioA = contratoA.getSalarioSemanal();

                                Integer salarioB = contratoB.getSalarioSemanal();

                                /*
                                 * Detectar inconsistencia:
                                 *
                                 * Jugador con MENOR jerarquia
                                 * cobra IGUAL o MAS
                                 * que jugador con MAYOR jerarquia
                                 */
                                if (prioridadA < prioridadB
                                                && salarioA >= salarioB) {

                                        AnalisisSalarial analisis = new AnalisisSalarial();

                                        analisis.setContratoMenorJerarquia(
                                                        contratoA);

                                        analisis.setContratoMayorJerarquia(
                                                        contratoB);

                                        analisis.setDiferenciaSalarial(
                                                        salarioA - salarioB);

                                        String nombreMenorJerarquia = contratoA.getJugador()
                                                        .getFullName();

                                        String nombreMayorJerarquia = contratoB.getJugador()
                                                        .getFullName();

                                        String mensaje = nombreMenorJerarquia
                                                        + " cobra "
                                                        + salarioA
                                                        + " y tiene menor jerarquía que "
                                                        + nombreMayorJerarquia
                                                        + " que cobra "
                                                        + salarioB;

                                        analisis.setMensaje(mensaje);

                                        analisis.setTipoProblema(
                                                        "INCONSISTENCIA_SALARIAL");

                                        inconsistencias.add(
                                                        analisisSalarialRepository
                                                                        .save(analisis));
                                }
                        }
                }

                return inconsistencias;
        }

        // OBTENER TODOS LOS ANALISIS
        public List<AnalisisSalarial> obtenerTodos() {

                return analisisSalarialRepository.findAll();
        }

        // BUSCAR POR ID
        public AnalisisSalarial buscarPorId(Long id) {

                return analisisSalarialRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException(
                                                "Análisis salarial no encontrado"));
        }

        // ELIMINAR ANALISIS
        public void eliminarAnalisis(Long id) {

                AnalisisSalarial analisis = analisisSalarialRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException(
                                                "Análisis salarial no encontrado"));

                analisisSalarialRepository.delete(analisis);
        }
}