package com.linketinder.controller;

import com.linketinder.DTO.CompetenciasList;
import com.linketinder.model.Candidato;

import com.linketinder.model.Competencia;

import com.linketinder.repository.CandidatoRepository;
import com.linketinder.repository.CompetenciaRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Controller("/api/competencias")
public class CompetenciaController {

    private final CompetenciaRepository competenciaRepository;
    private final CandidatoRepository candidatoRepository;

    public CompetenciaController(CompetenciaRepository competenciaRepository, CandidatoRepository candidatoRepository) {
        this.competenciaRepository = competenciaRepository;
        this.candidatoRepository = candidatoRepository;

    }

    @Get
    public ArrayList<Competencia> getAll() {
        return competenciaRepository.findAll();
    }

    @Post
    public Competencia createCompetencia(@Body Competencia competencia) {
        return competenciaRepository.save(competencia);
    }

    @Post("/candidato/{idCandidato}")
    @Transactional
    public HttpResponse attachCompetenciaCandidato(@Body ArrayList<Competencia> competencias, @PathVariable Long idCandidato) {
        if(candidatoRepository.existsById(idCandidato)) {
            System.out.println(competencias);
            Candidato candidato = candidatoRepository.findById(idCandidato).get();
            competencias.forEach(competencia -> {
                candidato.addCompetencia(competencia);
            });
            return HttpResponse.created(candidato);
        }

        return HttpResponse.badRequest("candidato não existe");
    }
}
