package com.FMDA.analisis_salarial.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FMDA.analisis_salarial.Model.AnalisisSalarial;

@Repository
public interface AnalisisSalarialRepository
                extends JpaRepository<AnalisisSalarial, Long> {

        // Buscar por tipo de problema
        List<AnalisisSalarial> findByTipoProblema(
                        String tipoProblema);

        // Buscar inconsistencias donde participa
        // un contrato de menor jerarquia
        List<AnalisisSalarial> findByContratoMenorJerarquiaId(Long contratoId);

        // Buscar inconsistencias donde participa
        // un contrato de mayor jerarquia
        List<AnalisisSalarial> findByContratoMayorJerarquiaId(Long contratoId);
}