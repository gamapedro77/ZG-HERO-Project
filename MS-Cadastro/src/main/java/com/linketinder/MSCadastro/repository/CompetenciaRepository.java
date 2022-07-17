package com.linketinder.MSCadastro.repository;

import com.linketinder.MSCadastro.model.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Long> {


    @Query(" select c from Competencia c where c.nome = :nome ")
    List<Competencia> findCompetenciaByNome(@Param("nome") String nome);
}
