package com.linketinder.MSCadastro.repository;

import com.linketinder.MSCadastro.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    @Query("select c from Candidato c where c.email=?1")
    public List<Candidato> findByEmail(String email);
}
