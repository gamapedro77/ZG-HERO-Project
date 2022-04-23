package Application.model

class PessoaJuridica extends Pessoa{
    String CNPJ
    String pais

    PessoaJuridica(String nome, String email, String CNPJ, String pais, String CEP, String descricao) {
        this.nome = nome
        this.email = email
        this.CNPJ = CNPJ
        this.pais = pais

        this.CEP = CEP
        this.descricao = descricao
    }
}
