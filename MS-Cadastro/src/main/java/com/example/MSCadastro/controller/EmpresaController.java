package com.example.MSCadastro.controller;

import com.example.MSCadastro.DTO.EmpresaDto;
import com.example.MSCadastro.Mapper.EmpresaMapper;
import com.example.MSCadastro.model.Empresa;
import com.example.MSCadastro.repository.EmpresaRepository;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Api(value="API REST Empresas")
@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    EmpresaRepository empresaRepository;


    public EmpresaController(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @GetMapping
    public @ResponseBody List<Empresa> list() {
        return empresaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Empresa> save(@RequestBody Empresa empresa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(empresa));
    }

    @Transactional
    @PatchMapping("/{empresaId}")
    public ResponseEntity<Empresa> update(@RequestBody EmpresaDto empresadto, @PathVariable Long empresaId) {
        Empresa empresa = EmpresaMapper.INSTANCE.toEmpresa(empresadto);
        Empresa empresaNoBd = empresaRepository.findById(empresaId).get();
        if (empresa.getNome() != null) {
            empresaNoBd.setNome(empresa.getNome());
        }
        if (empresa.getDescricao() != null) {
            empresaNoBd.setDescricao(empresa.getDescricao());
        }
        if (empresa.getEmail() != null) {
            empresaNoBd.setEmail(empresa.getEmail());
        }
        return ResponseEntity.status(HttpStatus.OK).body(empresaNoBd);
    }

}
