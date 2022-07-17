package com.linketinder.MSCadastro.security.jwt;

import com.linketinder.MSCadastro.model.Candidato;
import com.linketinder.MSCadastro.model.Empresa;
import com.linketinder.MSCadastro.model.Usuario;
import com.linketinder.MSCadastro.repository.CandidatoRepository;
import com.linketinder.MSCadastro.repository.EmpresaRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JwtAuthFilter extends OncePerRequestFilter {

    private CandidatoRepository candidatoRepository;
    private EmpresaRepository empresaRepository;
    public JwtAuthFilter(JwtService jwtService, CandidatoRepository candidatoRepository, EmpresaRepository empresaRepository) {
        this.jwtService = jwtService;
        this.candidatoRepository = candidatoRepository;
        this.empresaRepository = empresaRepository;
    }

    private JwtService jwtService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String auth = request.getHeader("Authorization");
        if(auth != null && auth.startsWith("Bearer")) {
            String token = auth.split(" ")[1];

            boolean isValid = jwtService.tokenValido(token);
            if(isValid) {
                String loginUsuario = jwtService.obterLoginUsuario(token);
                List<Candidato> candidato = candidatoRepository.findByEmail(loginUsuario);
                List<Empresa> empresa = empresaRepository.findByEmail(loginUsuario);
                UsernamePasswordAuthenticationToken userAuth;
                if(candidato.isEmpty()) {
                    userAuth = createUserAuth(empresa.get(0));
                }
                else {
                    userAuth = createUserAuth(candidato.get(0));
                }
                userAuth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(userAuth);
            }
        }
        filterChain.doFilter(request, response);

    }

    public UsernamePasswordAuthenticationToken createUserAuth(Usuario usuario) {
        UserDetails user = User
                .builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .roles(new String[]{"USER"})
                .build();

        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }
}
