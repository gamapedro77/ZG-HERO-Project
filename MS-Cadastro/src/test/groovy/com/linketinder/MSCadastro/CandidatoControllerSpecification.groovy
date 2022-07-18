package com.linketinder.MSCadastro

import com.linketinder.MSCadastro.CustomExceptions.EmailAlreadyRegisteredException
import com.linketinder.MSCadastro.CustomExceptions.MissingRequiredFieldException
import com.linketinder.MSCadastro.model.Candidato
import com.linketinder.MSCadastro.repository.CandidatoRepository
import com.linketinder.MSCadastro.service.CandidatoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import javax.ws.rs.core.MediaType

@ComponentScan(basePackages = ["com.linketinder.MSCadastro"])
@AutoConfigureMockMvc
@SpringBootTest
class CandidatoControllerSpecification extends Specification {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private CandidatoService candidatoService;

    def "Quando é feito post para /candidatos registra um candidato corretamente no banco"() {
        given:
        def request = "{\"nome\": \"teste\", \"email\": \"teste@email.com\", \"cpf\": \"12345678901\", \"senha\": \"123456Abc\"}"
        when:
        def result = mvc.perform(MockMvcRequestBuilders
                .post("/candidatos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)).andReturn()
        and:
        def candidato = candidatoService.findByEmail("teste@email.com")
        then:
        candidato.getId() != null
        cleanup:
        candidatoService.deleteByEmail("teste@email.com")
    }

    def "Get para /candidatos sem authorization header deve ter resposta status 403"() {
        when:
        def result = mvc.perform(MockMvcRequestBuilders.get("/candidatos")).andReturn()
        then: "Status é 403"
        result.response.status == HttpStatus.FORBIDDEN.value()

    }




}
