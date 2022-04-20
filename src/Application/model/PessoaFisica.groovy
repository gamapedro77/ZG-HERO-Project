package Application.model


class PessoaFisica extends Pessoa{
    String CPF
    String data_nascimento
    String sobrenome

    PessoaFisica(String nome, String sobrenome, String email, String CPF, String data_nascimento, String pais, String CEP, String descricao) {
        this.nome = nome
        this.sobrenome = sobrenome
        this.email = email
        this.CPF = CPF
        this.data_nascimento = data_nascimento
        this.pais = pais
        this.CEP = CEP
        this.descricao = descricao
    }

    PessoaFisica(String nome, String sobrenome, String email, String CPF, String data_nascimento, String pais, String CEP, String descricao, String senha) {
        this.nome = nome
        this.sobrenome = sobrenome
        this.email = email
        this.CPF = CPF
        this.data_nascimento = data_nascimento
        this.pais = pais
        this.CEP = CEP
        this.descricao = descricao
        this.senha = senha
    }



}
