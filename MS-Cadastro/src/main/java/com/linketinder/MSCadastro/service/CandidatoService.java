package com.linketinder.MSCadastro.service;


import com.linketinder.MSCadastro.CustomExceptions.CandidatoNaoEncontradoException;
import com.linketinder.MSCadastro.CustomExceptions.EmailAlreadyRegisteredException;
import com.linketinder.MSCadastro.CustomExceptions.MissingRequiredFieldException;
import com.linketinder.MSCadastro.model.Candidato;
import com.linketinder.MSCadastro.repository.CandidatoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidatoService {
    public CandidatoService(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    CandidatoRepository candidatoRepository;
    public Candidato save(Candidato candidato) throws Exception {
        ArrayList<String> parameters = checkRequiredParameters(candidato);
        if(!parameters.isEmpty()) {
            throw new MissingRequiredFieldException(parameters);
        }
        if (candidatoRepository.findByEmail(candidato.getEmail()).isEmpty()) {
            return candidatoRepository.save(candidato);
        } else {
            throw new EmailAlreadyRegisteredException();
        }
    }

    public ArrayList<String> checkRequiredParameters(Candidato candidato) {
        //required parameters are senha, email, nome & cpf
        ArrayList<String> parameters = new ArrayList<>();

        if(candidato.getEmail() == null) {
            parameters.add("email");
        }
        if(candidato.getSenha() == null) {
            parameters.add("senha");
        }
        if(candidato.getNome() == null) {
            parameters.add("nome");
        }
        if(candidato.getCpf() == null) {
            parameters.add("cpf");
        }

        return parameters;
    }

    public void deleteByEmail(String email) throws Exception{
        candidatoRepository.delete(findByEmail(email));
    }

    public Candidato findByEmail(String email) throws Exception {
        List<Candidato> candidato = candidatoRepository.findByEmail(email);
        if(candidato.isEmpty()) {
            throw new CandidatoNaoEncontradoException();
        }
        return candidato.get(0);
    }
}
