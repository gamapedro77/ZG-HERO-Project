package com.linketinder.MSCadastro.repository;

import com.linketinder.MSCadastro.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    @Query("select e from Empresa e where e.email=?1")
    public List<Empresa> findByEmail(String email);
}
