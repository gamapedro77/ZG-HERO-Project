package com.linketinder.MSCadastro.config;

import com.linketinder.MSCadastro.repository.CandidatoRepository;
import com.linketinder.MSCadastro.repository.EmpresaRepository;
import com.linketinder.MSCadastro.security.jwt.JwtAuthFilter;
import com.linketinder.MSCadastro.security.jwt.JwtService;
import com.linketinder.MSCadastro.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private JwtService jwtService;

    private CandidatoRepository candidatoRepository;

    private EmpresaRepository empresaRepository;


    private UsuarioService usuarioService;


    private Encoder encoder;

    public SecurityConfig(JwtService jwtService, CandidatoRepository candidatoRepository, EmpresaRepository empresaRepository, UsuarioService usuarioService, Encoder encoder) {
        this.jwtService = jwtService;
        this.candidatoRepository = candidatoRepository;
        this.empresaRepository = empresaRepository;
        this.usuarioService = usuarioService;
        this.encoder = encoder;
    }


    @Bean
    public OncePerRequestFilter jwtFilter() {
        return new JwtAuthFilter(jwtService, candidatoRepository, empresaRepository);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService)
                .passwordEncoder(encoder.passwordEncoder());
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/candidatos/**")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/empresas/**")
                .permitAll()
                .anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
