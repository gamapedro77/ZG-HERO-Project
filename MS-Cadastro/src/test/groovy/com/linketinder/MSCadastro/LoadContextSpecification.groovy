package com.linketinder.MSCadastro

import com.linketinder.MSCadastro.config.SecurityConfig
import com.linketinder.MSCadastro.controller.CandidatoController
import com.linketinder.MSCadastro.security.jwt.JwtService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class LoadContextSpecification extends Specification{

    @Autowired
    private CandidatoController candidatoController;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private SecurityConfig securityConfig;

    def "Quando contexto é carregado então todos os beans são criados corretamente"() {
        expect: "Bean CandidatoController foi criado!"
        candidatoController
        jwtService
        securityConfig
    }

}
