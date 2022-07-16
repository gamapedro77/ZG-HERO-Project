package com.linketinder.repository;


import com.linketinder.model.CompetenciaCandidato;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface CompetenciaCandidatoRepository extends CrudRepository<CompetenciaCandidato, Integer> {
}
