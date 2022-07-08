package com.example.MSCadastro.service;


import com.example.MSCadastro.CustomExceptions.EmailAlreadyRegisteredException;
import com.example.MSCadastro.model.Candidato;
import com.example.MSCadastro.repository.CandidatoRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {
    public CandidatoService(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    CandidatoRepository candidatoRepository;
    public Candidato save(Candidato candidato) throws EmailAlreadyRegisteredException {
        if (candidatoRepository.findByEmail(candidato.getEmail()).isEmpty()) {
            return candidatoRepository.save(candidato);
        } else {
            throw new EmailAlreadyRegisteredException();
        }
    }
}
