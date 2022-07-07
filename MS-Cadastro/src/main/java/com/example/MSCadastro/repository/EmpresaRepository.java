package com.example.MSCadastro.repository;

import com.example.MSCadastro.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
