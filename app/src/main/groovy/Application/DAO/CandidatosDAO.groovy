package Application.DAO


import Application.model.PessoaFisica

import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement
import java.text.SimpleDateFormat

class CandidatosDAO extends BDConnect{

    def static insertCandidato(PessoaFisica pessoa) {
        String sql = "INSERT INTO candidatos (nome, sobrenome, data_nascimento, email, cpf, pais, cep, descricao, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"

        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        java.sql.Date date = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(pessoa.data_nascimento).getTime())

        ps.setString(1, pessoa.nome)
        ps.setString(2, pessoa.sobrenome)
        ps.setDate(3, date)
        ps.setString(4, pessoa.email)
        ps.setString(5, pessoa.CPF)
        ps.setString(6, pessoa.pais)
        ps.setString(7, pessoa.CEP)
        ps.setString(8, pessoa.descricao)
        ps.setString(9, "senhaTemplate")
        ps.executeUpdate()

        ResultSet generatedKey = ps.getGeneratedKeys()
        if (generatedKey.next()) {
            return generatedKey.getLong(1)
        }
        return "Erro ao inserir candidato"
    }

    def static selectAllCandidatos() {
        String sql = "SELECT * FROM candidatos"
        PreparedStatement ps = connection.prepareStatement(sql)
        ResultSet rs = ps.executeQuery()
        def listaPessoas = []
        while(rs.next()) {
            PessoaFisica candidato = new PessoaFisica(
                    rs.getString("nome"),
                    rs.getString("sobrenome"),
                    rs.getString("email"),
                    rs.getString("CPF"),
                    rs.getString("data_nascimento"),
                    rs.getString("pais"),
                    rs.getString("CEP"),
                    rs.getString("descricao")

            )

            listaPessoas.add(candidato)
        }
        return listaPessoas
    }
}
