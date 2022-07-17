package com.linketinder.MSCadastro.repository;

import com.linketinder.MSCadastro.model.CandidatoCompetencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoCompetenciaRepository extends JpaRepository<CandidatoCompetencia, Long> {

}
