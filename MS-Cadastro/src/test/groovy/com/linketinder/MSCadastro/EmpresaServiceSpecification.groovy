package com.linketinder.MSCadastro

import com.linketinder.MSCadastro.CustomExceptions.EmailAlreadyRegisteredException
import com.linketinder.MSCadastro.CustomExceptions.MissingRequiredFieldException
import com.linketinder.MSCadastro.model.Candidato
import com.linketinder.MSCadastro.model.Empresa
import com.linketinder.MSCadastro.repository.CandidatoRepository
import com.linketinder.MSCadastro.repository.EmpresaRepository
import com.linketinder.MSCadastro.service.CandidatoService
import com.linketinder.MSCadastro.service.EmpresaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import spock.lang.Specification


@ComponentScan(basePackages = ["com.linketinder.MSCadastro"])
@SpringBootTest
class EmpresaServiceSpecification extends Specification{

    @Autowired
    EmpresaService empresaService;
    EmpresaRepository empresaRepository = Mock(EmpresaRepository)

    def "Empresa service save não aceita empresa sem email"() {
        given: "Uma empresa nova"
        Empresa empresa = new Empresa()
        empresa.setNome("teste")
        empresa.setSenha("senha123")
        and: "Um servico com repository injetado"
        empresaRepository.save(empresa) >> empresa
        EmpresaService empresaService = new EmpresaService(empresaRepository);
        when:
        empresaService.save(empresa)
        then:
        thrown(MissingRequiredFieldException)
    }

    def "Empresa service save não aceita empresa sem senha"() {
        given: "Uma empresa nova sem senha"
        Empresa empresa = new Empresa()
        empresa.setNome("teste")
        empresa.setEmail("email@email.com")
        and: "Um servico com repository injetado"
        empresaRepository.save(empresa) >> empresa
        EmpresaService empresaService = new EmpresaService(empresaRepository);
        when:
        empresaService.save(empresa);
        then:
        thrown(MissingRequiredFieldException)
    }

    def "Empresa service save não registra empresa com email repetido"() {
        given: "Uma empresa nova com email repetido"
        Empresa empresa = new Empresa()
        empresa.setNome("teste")
        empresa.setEmail("email@email.com")
        empresa.setSenha("a12346asbc")
        empresa.setCnpj("12345678901")
        and:
        empresaRepository.findByEmail(empresa.getEmail()) >> [empresa]
        EmpresaService empresaService = new EmpresaService(empresaRepository);
        when:
        empresaService.save(empresa);
        then:
        thrown(EmailAlreadyRegisteredException);
    }
    def "Empresa service save não registra empresa sem cnpj"() {
        given: "Uma empresa nova sem cnpj"
        Empresa empresa = new Empresa()
        empresa.setNome("teste")
        empresa.setEmail("email@email.com")
        empresa.setSenha("a12346asbc")
        and:
        empresaRepository.findByEmail(empresa.getEmail()) >> [empresa]
        EmpresaService empresaService = new EmpresaService(empresaRepository);
        when:
        empresaService.save(empresa);
        then:
        thrown(MissingRequiredFieldException);
    }
}
