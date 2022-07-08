package com.example.MSCadastro.service;

import com.example.MSCadastro.CustomExceptions.EmailAlreadyRegisteredException;
import com.example.MSCadastro.model.Empresa;
import com.example.MSCadastro.repository.EmpresaRepository;
import org.springframework.stereotype.Service;


@Service
public class EmpresaService {

    EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa save(Empresa empresa) throws EmailAlreadyRegisteredException {
        if(empresaRepository.findByEmail(empresa.getEmail()).isEmpty()) {
            return empresaRepository.save(empresa);
        } else {
            throw new EmailAlreadyRegisteredException();
        }
    }
}
