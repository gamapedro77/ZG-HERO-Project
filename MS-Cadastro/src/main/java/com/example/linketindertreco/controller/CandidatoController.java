package com.example.linketindertreco.controller;

import com.example.linketindertreco.model.Candidato;
import com.example.linketindertreco.repository.CandidatoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {


    private CandidatoRepository candidatoRepository;

    public CandidatoController(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    @GetMapping
    public @ResponseBody List<Candidato> list() {
        return candidatoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Candidato> save(@RequestBody Candidato candidato) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidatoRepository.save(candidato));

    }
}
