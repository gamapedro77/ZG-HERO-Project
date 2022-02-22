package Application.model

class PessoaFisica extends Pessoa{
    String CPF
    int idade

    PessoaFisica(String nome, String email, String CPF, int idade, String UF, String CEP, String descricao, LinkedHashMap competencias) {
        this.nome = nome
        this.email = email
        this.CPF = CPF
        this.idade = idade
        this.UF = UF
        this.CEP = CEP
        this.descricao = descricao
        this.competencias = competencias
    }
}
