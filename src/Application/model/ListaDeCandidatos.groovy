package Application.model

class ListaDeCandidatos {
    private List<PessoaFisica> candidatos;

    ListaDeCandidatos(List candidatos) {
        this.candidatos = candidatos;
    }

    public criarCandidato(PessoaFisica pessoa) {
        candidatos.add(pessoa)
        return candidatos[candidatos.size() - 1]
    }

    public getCandidato(String nomeCandidato) {
        PessoaFisica candidatoProcurado;
        candidatos.forEach{ candidato ->
            if(nomeCandidato == candidato.nome) {
                candidatoProcurado = candidato;
            }
        }

        if(candidatoProcurado) {
            return candidatoProcurado;
        }
    }
}
