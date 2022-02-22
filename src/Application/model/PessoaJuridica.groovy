package Application.model

class PessoaJuridica extends Pessoa{
    String CNPJ
    String pais

    PessoaJuridica(String nome, String email, String CNPJ, String pais, String UF, String CEP, String descricao, LinkedHashMap competencias) {
        this.nome = nome
        this.email = email
        this.CNPJ = CNPJ
        this.pais = pais
        this.UF = UF
        this.CEP = CEP
        this.descricao = descricao
        this.competencias = competencias
    }
}
