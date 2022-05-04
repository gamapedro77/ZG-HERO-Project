package Application.DAO


import Application.model.PessoaJuridicaRepository

import java.sql.PreparedStatement
import java.sql.ResultSet

class EmpresasDAO extends BDConnect{

    def selectAllEmpresas() {
        String sql = "SELECT * FROM empresas"
        PreparedStatement ps = connection.prepareStatement(sql)
        ResultSet rs = ps.executeQuery()

        while(rs.next()) {
            PessoaJuridicaRepository empresa = new PessoaJuridicaRepository(rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("CNPJ"),
                    rs.getString("pais"),
                    rs.getString("CEP"),
                    rs.getString("descricao")
            )
            println empresa.nome
        }
    }

    def insertEmpresa(PessoaJuridicaRepository pessoa) {
        String sql = "INSERT INTO empresas (nome, cnpj, email, descricao, pais, cep, senha) VALUES (?, ?, ?, ?, ?, ?, ?)"

        PreparedStatement ps = connection.prepareStatement(sql)

        ps.setString(1, pessoa.nome)
        ps.setString(2, pessoa.CNPJ)
        ps.setString(3, pessoa.email)
        ps.setString(4, pessoa.descricao)
        ps.setString(5, pessoa.pais)
        ps.setString(6, pessoa.CEP)
        ps.setString(7, "senhaTemplate")
        ps.execute()
    }
}
