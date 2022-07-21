package com.linketinder.repository;

import com.linketinder.model.Candidato;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface CandidatoRepository extends CrudRepository<Candidato, Long>{

}
