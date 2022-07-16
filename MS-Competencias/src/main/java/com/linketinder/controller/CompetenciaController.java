package com.linketinder.controller;

import com.linketinder.model.Competencia;
import com.linketinder.model.CompetenciaCandidato;
import com.linketinder.repository.CompetenciaCandidatoRepository;
import com.linketinder.repository.CompetenciaRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.ArrayList;

@Controller("/api/competencias")
public class CompetenciaController {

    private final CompetenciaRepository competenciaRepository;
    private final CompetenciaCandidatoRepository competenciaCandidatoRepository;
    public CompetenciaController(CompetenciaRepository competenciaRepository, CompetenciaCandidatoRepository competenciaCandidatoRepository) {
        this.competenciaRepository = competenciaRepository;
        this.competenciaCandidatoRepository = competenciaCandidatoRepository;
    }

    @Get
    public ArrayList<Competencia> getAll() {
        return competenciaRepository.findAll();
    }

    @Post
    public Competencia createCompetencia(@Body Competencia competencia) {
        return competenciaRepository.save(competencia);
    }

    @Post
    public HttpResponse attachCompetenciaCandidato(@Body CompetenciaCandidato competenciaCandidato) {
        return HttpResponse.created(competenciaCandidatoRepository.save(competenciaCandidato));
    }
}
