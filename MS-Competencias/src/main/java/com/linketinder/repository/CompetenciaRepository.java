package com.linketinder.repository;


import com.linketinder.model.Competencia;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.ArrayList;

@Repository
public interface CompetenciaRepository extends CrudRepository<Competencia, Integer> {

    @Override
    public ArrayList<Competencia> findAll();
}
