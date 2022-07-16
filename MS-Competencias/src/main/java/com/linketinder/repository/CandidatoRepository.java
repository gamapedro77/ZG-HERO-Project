package com.linketinder.repository;

import com.linketinder.model.Candidato;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;


@Repository
public interface CandidatoRepository extends CrudRepository<Candidato, Long> {
    @Override
    public ArrayList<Candidato> findAll();

    @Override
    public Optional<Candidato> findById(Long id);
}
