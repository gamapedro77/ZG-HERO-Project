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

    private CandidatoRepository candidatoRepository = Mock(CandidatoRepository);

    def "Quando é feito get para /candidatos a resposta deve ser status 200 e media type deve ser application json"() {
        when:
        def result = mvc.perform(MockMvcRequestBuilders.get("/candidatos")).andReturn()
        then: "Status é 200 e media type é application json"
        result.response.status == HttpStatus.OK.value()
        result.response.contentType == MediaType.APPLICATION_JSON
    }

}
