package com.linketinder.MSCadastro.service;

import com.linketinder.MSCadastro.CustomExceptions.CandidatoNaoEncontradoException;
import com.linketinder.MSCadastro.CustomExceptions.EmailAlreadyRegisteredException;
import com.linketinder.MSCadastro.CustomExceptions.MissingRequiredFieldException;
import com.linketinder.MSCadastro.model.Candidato;
import com.linketinder.MSCadastro.model.Empresa;
import com.linketinder.MSCadastro.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmpresaService {

    EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa save(Empresa empresa) throws Exception {
        try{
            checkRequiredParameters(empresa);
            if(empresaRepository.findByEmail(empresa.getEmail()).isEmpty()) {
                return empresaRepository.save(empresa);
            } else {
                throw new EmailAlreadyRegisteredException();
            }
        } catch (Exception e) {
            throw e;
        }

    }

    public ArrayList<String> checkRequiredParameters(Empresa empresa) throws MissingRequiredFieldException {
        //required parameters are senha, email, nome & cnpj
        ArrayList<String> parameters = new ArrayList<>();

        if(empresa.getEmail() == null) {
            parameters.add("email");
        }
        if(empresa.getSenha() == null) {
            parameters.add("senha");
        }
        if(empresa.getNome() == null) {
            parameters.add("nome");
        }
        if(empresa.getCnpj() == null) {
            parameters.add("cnpj");
        }

        if(!parameters.isEmpty()) {
            throw new MissingRequiredFieldException(parameters);
        }
        return parameters;
    }

    public Empresa findByEmail(String email) throws Exception {
        List<Empresa> empresa = empresaRepository.findByEmail(email);
        if(empresa.isEmpty()) {
            throw new CandidatoNaoEncontradoException();
        }
        return empresa.get(0);
    }

}
