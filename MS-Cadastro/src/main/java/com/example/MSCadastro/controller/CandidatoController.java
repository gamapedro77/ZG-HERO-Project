package com.example.MSCadastro.controller;

import com.example.MSCadastro.model.Candidato;
import com.example.MSCadastro.repository.CandidatoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Api(value="API REST Candidatos")
@RestController
@RequestMapping("/candidatos")
public class CandidatoController {


    private CandidatoRepository candidatoRepository;

    public CandidatoController(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }
    @ApiOperation(value="Retorna uma lista contendo todos os candidatos")
    @GetMapping
    public @ResponseBody List<Candidato> list() {
        return candidatoRepository.findAll();
    }

    @ApiOperation(value="Cadastra e retorna novo candidato")
    @PostMapping
    public ResponseEntity<Candidato> save(@RequestBody Candidato candidato) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidatoRepository.save(candidato));

    }

    @ApiOperation(value="Atualiza o cadastro de um candidato")
    @Transactional
    @PutMapping("/{candidatoId}")
    public ResponseEntity<Candidato> update(@RequestBody Candidato candidato, @PathVariable Long candidatoId) {
        Candidato candidatoNoDB = candidatoRepository.findById(candidatoId).get();
        if(candidato.getNome() != null) {
            candidatoNoDB.setDescricao(candidato.getDescricao());
        }
        if (candidato.getDescricao() != null) {
            candidatoNoDB.setPais(candidato.getPais());
        }
        if (candidato.getDataNascimento() != null) {
            candidatoNoDB.setDataNascimento(candidato.getDataNascimento());
        }

        return ResponseEntity.status(HttpStatus.OK).body(candidatoNoDB);
    }

}
