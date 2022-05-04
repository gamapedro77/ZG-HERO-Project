package Application.DAO.implementations

import Application.DAO.IDAO
import Application.model.Empresa
import Application.model.IModel
import Application.repositories.IDatabase

import java.sql.PreparedStatement
import java.sql.ResultSet

class EmpresasDAO implements IDAO {
    def connection

    EmpresasDAO(IDatabase database) {
        this.connection = database.connection
    }

    def readAll() {
        String sql = "SELECT * FROM empresas"
        PreparedStatement ps = connection.prepareStatement(sql)
        ResultSet rs = ps.executeQuery()

        while(rs.next()) {
            Empresa empresa = new Empresa(rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("CNPJ"),
                    rs.getString("pais"),
                    rs.getString("CEP"),
                    rs.getString("descricao")
            )
            println empresa.nome
        }
    }

    def insert(IModel empresa) {
        String sql = "INSERT INTO empresas (nome, cnpj, email, descricao, pais, cep, senha) VALUES (?, ?, ?, ?, ?, ?, ?)"

        PreparedStatement ps = connection.prepareStatement(sql)

        ps.setString(1, empresa.nome)
        ps.setString(2, empresa.CNPJ)
        ps.setString(3, empresa.email)
        ps.setString(4, empresa.descricao)
        ps.setString(5, empresa.pais)
        ps.setString(6, empresa.CEP)
        ps.setString(7, "senhaTemplate")
        ps.execute()
    }



    @Override
    def delete(Integer id) {
        return null
    }

    @Override
    def selectById(Integer id) {
        return null
    }
}
