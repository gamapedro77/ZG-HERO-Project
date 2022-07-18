package com.linketinder.MSCadastro.controller;

import com.linketinder.MSCadastro.DTO.AutenticationDTO;
import com.linketinder.MSCadastro.DTO.TokenDTO;
import com.linketinder.MSCadastro.config.Encoder;
import com.linketinder.MSCadastro.service.UsuarioService;
import com.linketinder.MSCadastro.CustomExceptions.SenhaInvalidaException;
import com.linketinder.MSCadastro.model.Candidato;
import com.linketinder.MSCadastro.repository.CandidatoRepository;
import com.linketinder.MSCadastro.security.jwt.JwtService;
import com.linketinder.MSCadastro.service.CandidatoService;
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

@Api(tags="Rotas Candidatos", description = "Endpoints para lidar com Candidatos")
@RestController
@RequestMapping("/candidatos")
public class CandidatoController {


    private UsuarioService usuarioService;
    private JwtService jwtService;
    private CandidatoRepository candidatoRepository;
    private Encoder pwdEncoder;

    private CandidatoService candidatoService;

    public CandidatoController(CandidatoRepository candidatoRepository, Encoder passwordEncoder, UsuarioService usuarioService, JwtService jwtService, CandidatoService candidatoService) {
        this.candidatoRepository = candidatoRepository;
        this.pwdEncoder = passwordEncoder;
        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
        this.candidatoService = candidatoService;
    }
    @ApiOperation(value="Retorna uma lista contendo todos os candidatos")
    @GetMapping
    public @ResponseBody List<Candidato> list() {
        return candidatoRepository.findAll();
    }

    @ApiOperation(value="Busca um candidato por id")
    @GetMapping(params = "id")
    public @ResponseBody ResponseEntity<Object> findById(@RequestParam("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(candidatoRepository.findById(id));
    }

    @ApiOperation(value="Cadastra e retorna novo candidato")
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Candidato candidato) {
        String senhaCriptografa = pwdEncoder.passwordEncoder().encode(candidato.getSenha());
        candidato.setSenha(senhaCriptografa);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(candidatoService.save(candidato));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

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

    @ApiOperation(value = "Autenticar candidato")
    @PostMapping("/auth")
    public ResponseEntity autenticar(@RequestBody AutenticationDTO credenciais){
        try {
            Candidato candidato = new Candidato();
            candidato.setEmail(credenciais.getEmail());
            candidato.setSenha(credenciais.getSenha());
            UserDetails userDetails = usuarioService.autenticar(candidato);
            String token = jwtService.gerarToken(candidato);
            return ResponseEntity.status(HttpStatus.OK).body(new TokenDTO(candidato.getEmail(), token));
        } catch (UsernameNotFoundException | SenhaInvalidaException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

}
