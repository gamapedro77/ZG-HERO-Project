package Application

import Application.DAO.CandidatosDAO
import Application.DAO.CompetenciaCandidatoDAO
import Application.DAO.CompetenciasDAO
import Application.model.PessoaFisica
import Application.model.PessoaJuridica


class Application {
    static void main(String[] args){

        PessoaFisica pessoinha = new PessoaFisica("Rafael", "Borges", "rafael.borges@email.com", "11122233345", "1998-12-24", "Brasil", "12345678", "Descricao do rafael")
        PessoaJuridica pessoao = new PessoaJuridica("Fabrica de Treco LTDA", "fabrica@email.com", "11222333000145", "Brasil", "12345678", "Nos fabricamos coisas e trecos")
        List<String> listaCompetencias = ["java", "javascript", "typescript", "git", "react"]

        println 'Insira qual instrução deseja realizar: LC - Listar todos candidatos || LE - Listar todas as empresas || IC - Inserir Candidato || IE = Inserir Empresa'
        String instrucao = System.in.newReader().readLine()
        switch(instrucao){
            case "IC":
                CandidatosDAO candidatos = new CandidatosDAO()
                Long candidato_id = candidatos.insertCandidato(pessoinha)
                CompetenciasDAO competencias = new CompetenciasDAO()
                for(competencia in listaCompetencias) {
                    if(!competencias.searchCompetencia(competencia)) {
                        competencias.insertCompetencia(competencia)
                    }
                    List resultado = competencias.searchCompetencia(competencia)
                    CompetenciaCandidatoDAO competencia_candidato = new CompetenciaCandidatoDAO()
                    competencia_candidato.insertCompetenciaDoCandidato(candidato_id, resultado[0], "Avançado")
                }
                break
            case 'LC':

                break
            case 'LE':

                break
            case 'IC':

                break
            case "IE":

                break
            case "LV":

            default:
                println "comando não reconhecido"
                break
        }

    }

}
