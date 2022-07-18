package com.linketinder.MSCadastro.controller;

import com.linketinder.MSCadastro.DTO.AutenticationDTO;
import com.linketinder.MSCadastro.DTO.EmpresaDto;
import com.linketinder.MSCadastro.DTO.TokenDTO;
import com.linketinder.MSCadastro.Mapper.EmpresaMapper;
import com.linketinder.MSCadastro.service.UsuarioService;
import com.linketinder.MSCadastro.CustomExceptions.SenhaInvalidaException;
import com.linketinder.MSCadastro.model.Empresa;
import com.linketinder.MSCadastro.repository.EmpresaRepository;
import com.linketinder.MSCadastro.security.jwt.JwtService;
import com.linketinder.MSCadastro.service.EmpresaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;


@RestController
@RequestMapping("/empresas")
@Api(tags="Rotas Empresas", description = "Endpoints para lidar com Empresas")
public class EmpresaController {
    EmpresaRepository empresaRepository;
    UsuarioService usuarioService;
    JwtService jwtService;
    EmpresaService empresaService;
    public EmpresaController(EmpresaRepository empresaRepository, UsuarioService usuarioService, JwtService jwtService, EmpresaService empresaService) {
        this.usuarioService = usuarioService;
        this.empresaRepository = empresaRepository;
        this.jwtService = jwtService;
        this.empresaService = empresaService;
    }


    @ApiOperation(value="Retorna uma lista contendo todas as empresas")
    @GetMapping
    public @ResponseBody List<Empresa> list() {
        return empresaRepository.findAll();
    }

    @ApiOperation(value="Cadastrar empresa")
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Empresa empresa) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresa));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }


    @ApiOperation(value="Atualizar empresa")
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


    @ApiOperation(value="Autenticar Empresa")
    @PostMapping("/auth")
    public TokenDTO autenticar(@RequestBody AutenticationDTO credenciais){
        try {
                Empresa empresa = new Empresa();
                empresa.setEmail(credenciais.getEmail());
                empresa.setSenha(credenciais.getSenha());
                UserDetails userDetails =  usuarioService.autenticar(empresa);
                String token = jwtService.gerarToken(empresa);
                return new TokenDTO(empresa.getEmail(), token);

        } catch (UsernameNotFoundException | SenhaInvalidaException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

}
