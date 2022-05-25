package Application.DAO.implementations

import Application.DAO.IDAO
import Application.model.Candidato
import Application.model.IModel
import Application.repositories.IDatabase

import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement
import java.text.SimpleDateFormat

class CandidatosDAO implements IDAO {

    def connection
    CandidatosDAO(IDatabase database){
        this.connection = database.connection
    }

    def insert(IModel pessoa) {
        String sql = "INSERT INTO candidatos (nome, sobrenome, data_nascimento, email, cpf, pais, cep, descricao, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"

        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)

        ps.setString(1, pessoa.nome)
        ps.setString(2, pessoa.sobrenome)
        ps.setDate(3, pessoa.data_nascimento)
        ps.setString(4, pessoa.email)
        ps.setString(5, pessoa.CPF)
        ps.setString(6, pessoa.pais)
        ps.setString(7, pessoa.CEP)
        ps.setString(8, pessoa.descricao)
        ps.setString(9, pessoa.senha)
        ps.executeUpdate()

        ResultSet generatedKey = ps.getGeneratedKeys()
        if (generatedKey.next()) {
            return generatedKey.getLong(1)
        }
        return "Erro ao inserir candidato"
    }
    def delete(Integer id) {}

    def readAll() {
        String sql = "SELECT * FROM candidatos"
        PreparedStatement ps = connection.prepareStatement(sql)
        ResultSet rs = ps.executeQuery()
        def listaPessoas = []
        while(rs.next()) {
            Candidato candidato = new Candidato(
                    nome: rs.getString("nome"),
                    sobrenome: rs.getString("sobrenome"),
                    email: rs.getString("email"),
                    CPF: rs.getString("CPF"),
                    data_nascimento: rs.getString("data_nascimento"),
                    pais: rs.getString("pais"),
                    CEP: rs.getString("CEP"),
                    descricao: rs.getString("descricao")

            )

            listaPessoas.add(candidato)
        }
        return listaPessoas
    }

    def selectById(Integer id) {}
}
