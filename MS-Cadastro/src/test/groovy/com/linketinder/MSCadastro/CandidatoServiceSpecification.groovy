package com.linketinder.MSCadastro

import com.linketinder.MSCadastro.CustomExceptions.EmailAlreadyRegisteredException
import com.linketinder.MSCadastro.CustomExceptions.MissingRequiredFieldException
import com.linketinder.MSCadastro.model.Candidato
import com.linketinder.MSCadastro.repository.CandidatoRepository
import com.linketinder.MSCadastro.service.CandidatoService
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import spock.lang.Specification


@ComponentScan(basePackages = ["com.linketinder.MSCadastro"])
@SpringBootTest
class CandidatoServiceSpecification extends Specification {

    private CandidatoRepository candidatoRepository = Mock()

    def "Candidato service save não aceita candidato sem email"() {
        given: "Um candidato novo"
        Candidato candidato = new Candidato()
        candidato.setNome("teste")
        candidato.setSenha("senha123")
        candidato.setCpf("12345678901")
        and: "Um servico com repository injetado"
        candidatoRepository.save(candidato) >> candidato
        CandidatoService candidatoService = new CandidatoService(candidatoRepository);
        when:
        candidatoService.save(candidato)
        then:
        thrown(MissingRequiredFieldException)
    }

    def "Candidato service save não aceita candidato sem senha"() {
        given: "Um candidato novo sem senha"
        Candidato candidato = new Candidato()
        candidato.setNome("teste")
        candidato.setEmail("email@email.com")
        candidato.setCpf("12345678901")
        and: "Um servico com repository injetado"
        candidatoRepository.save(candidato) >> candidato
        CandidatoService candidatoService = new CandidatoService(candidatoRepository);
        when:
        candidatoService.save(candidato);
        then:
        thrown(MissingRequiredFieldException)
    }

    def "Candidato service save não registra candidato com email repetido"() {
        given: "Um candidato novo com email repetido"
        Candidato candidato = new Candidato()
        candidato.setNome("teste")
        candidato.setEmail("email@email.com")
        candidato.setSenha("a12346asbc")
        candidato.setCpf("12345678901")
        and:
        candidatoRepository.findByEmail(candidato.getEmail()) >> [candidato]
        CandidatoService candidatoService = new CandidatoService(candidatoRepository);
        when:
        candidatoService.save(candidato);
        then:
        thrown(EmailAlreadyRegisteredException);
    }

    def "Candidato service save não registra candidato sem CPF"() {
        given: "Um candidato novo sem cpf"
        Candidato candidato = new Candidato()
        candidato.setNome("teste")
        candidato.setEmail("email@email.com")
        candidato.setSenha("12345678abc")
        and: "Um servico com repository injetado"
        candidatoRepository.save(candidato) >> candidato
        CandidatoService candidatoService = new CandidatoService(candidatoRepository);
        when:
        candidatoService.save(candidato);
        then:
        thrown(MissingRequiredFieldException)
    }
}
