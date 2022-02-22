package Application

import Application.model.PessoaFisica
import Application.model.PessoaJuridica
import groovy.json.JsonBuilder

class Application {
    static void main(String[] args){
        List candidatos = [
                new PessoaFisica("Joao",
                    "joao@gmail.com",
                    "111-222-444-55",
                    24,  "RJ",
                    "25000-000",
                    "descricao sample do Joao",
                    ["Python" : "Avançado", "Java": "Avançado", "Spring Framework" : "Básico", "Angular" : "Intermediario"]),
                new PessoaFisica("Carlos",
                    "carlos@gmail.com",
                    "111-222-444-55",
                    24,  "RJ",
                    "25000-000",
                    "descricao sample do Carlos",
                    ["Python" : "Avançado", "Java": "Avançado", "Spring Framework" : "Básico", "Angular" : "Intermediario"]),
                new PessoaFisica("Maria",
                    "maria@gmail.com",
                    "111-222-444-55",
                    24,  "RJ",
                    "25000-000",
                    "descricao sample da Maria",
                    ["Python" : "Avançado", "Java": "Avançado", "Spring Framework" : "Básico", "Angular" : "Intermediario"]),
                new PessoaFisica("Fernanda",
                    "fernanda@gmail.com",
                    "111-222-444-55",
                    24,  "RJ",
                    "25000-000",
                    "descricao sample da Fernanda",
                    ["Python" : "Avançado", "Java": "Avançado", "Spring Framework" : "Básico", "Angular" : "Intermediario"]),
                new PessoaFisica("Liana",
                    "liana@gmail.com",
                    "111-222-444-55",
                    24,  "RJ",
                    "25000-000",
                    "descricao sample da Liana",
                    ["Python" : "Avançado", "Java": "Avançado", "Spring Framework" : "Básico", "Angular" : "Intermediario"]),
        ]

        List empresas = [
                new PessoaJuridica("Farmacia",
                        "farmacia@empresa.com",
                        "11.222.333/0001-32",
                        "Brasil", "SP", "44000-000",
                        "descricao sample de farmacia",
                        ["Python" : "Avançado", "Java": "Avançado", "Spring Framework" : "Básico", "Angular" : "Intermediario"]
                ),
                new PessoaJuridica("Farmacia",
                        "farmacia@empresa.com",
                        "11.222.333/0001-32",
                        "Brasil", "SP", "44000-000",
                        "descricao sample de farmacia",
                        ["Python" : "Avançado", "Java": "Avançado", "Spring Framework" : "Básico", "Angular" : "Intermediario"]
                ),
                new PessoaJuridica("Farmacia",
                        "farmacia@empresa.com",
                        "11.222.333/0001-32",
                        "Brasil", "SP", "44000-000",
                        "descricao sample de farmacia",
                        ["Python" : "Avançado", "Java": "Avançado", "Spring Framework" : "Básico", "Angular" : "Intermediario"]
                ),
                new PessoaJuridica("Farmacia",
                        "farmacia@empresa.com",
                        "11.222.333/0001-32",
                        "Brasil", "SP", "44000-000",
                        "descricao sample de farmacia",
                        ["Python" : "Avançado", "Java": "Avançado", "Spring Framework" : "Básico", "Angular" : "Intermediario"]
                ),
                new PessoaJuridica("Farmacia",
                        "farmacia@empresa.com",
                        "11.222.333/0001-32",
                        "Brasil", "SP", "44000-000",
                        "descricao sample de farmacia",
                        ["Python" : "Avançado", "Java": "Avançado", "Spring Framework" : "Básico", "Angular" : "Intermediario"]
                ),
        ]
        println 'Insira qual instrução deseja realizar: LC - Listar todos candidatos || LE - Listar todas as empresas'
        String instrucao = System.in.newReader().readLine()
        JsonBuilder builder = new JsonBuilder()
        switch(instrucao){
            case 'LC':
                builder.candidatos candidatos, {PessoaFisica candidato ->
                        nome candidato.nome
                        email candidato.email
                        cpf candidato.CPF
                        idade candidato.idade
                        uf candidato.UF
                        cep candidato.CEP
                        descricao candidato.descricao
                    }

                println builder.toPrettyString()
                break
            case 'LE':
                builder.empresas empresas, {PessoaJuridica empresa ->
                    nome empresa.nome
                    email empresa.email
                    cnpj empresa.CNPJ
                    pais empresa.pais
                    uf empresa.UF
                    cep empresa.CEP
                    descricao empresa.descricao
                }

                println builder.toPrettyString()
                break
            default:
                println "comando não reconhecido"
                break
        }

    }

}
