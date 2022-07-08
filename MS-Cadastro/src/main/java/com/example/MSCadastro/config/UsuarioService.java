package com.example.MSCadastro.config;

import com.example.MSCadastro.exceptions.SenhaInvalidaException;
import com.example.MSCadastro.model.Candidato;
import com.example.MSCadastro.model.Empresa;
import com.example.MSCadastro.model.Usuario;
import com.example.MSCadastro.repository.CandidatoRepository;
import com.example.MSCadastro.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    CandidatoRepository candidatoRepository;
    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    Encoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Candidato> candidato = candidatoRepository.findByEmail(username);
        List<Empresa> empresa = empresaRepository.findByEmail(username);

        if(candidato.isEmpty() && empresa.isEmpty()) {
            throw new UsernameNotFoundException("Usuario nao encontrado!");
        }

        if(!candidato.isEmpty()) {
            return getUserDetails(candidato.get(0));
        } else {
            return getUserDetails(empresa.get(0));
        }

    }

    public UserDetails autenticar( Usuario usuario) throws SenhaInvalidaException {
        UserDetails user = loadUserByUsername(usuario.getEmail());
        boolean pwdEquals = encoder.passwordEncoder().matches(usuario.getSenha(), user.getPassword());
        if (pwdEquals) {
            return user;
        }
        throw new SenhaInvalidaException();
    }
    public UserDetails getUserDetails(Usuario usuario) {
        UserDetails user = User
                .builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .roles("USER")
                .build();

        return user;
    }
}
