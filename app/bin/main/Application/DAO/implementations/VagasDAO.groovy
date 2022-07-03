package Application.DAO.implementations

import Application.DAO.IDAO
import Application.model.IModel
import Application.model.Vaga
import Application.repositories.IDatabase

import java.sql.PreparedStatement
import java.sql.ResultSet

class VagasDAO implements IDAO{
    def connection

    VagasDAO(IDatabase database) {
        this.connection = database.connection
    }
    def readAll() {
        String sql = "INSERT * FROM vagas"
        PreparedStatement ps = connection.prepareStatement(sql)
        ResultSet rs = ps.executeQuery()
        while(rs.next()) {
            Vaga vaga = new Vaga(rs.getString("nome"), rs.getString(descricao), rs.getInt("empresa_id"), rs.getString("local"))
            println vaga.nome
        }
    }

    @Override
    def selectById(Integer id) {
        return null
    }

    def insert(IModel vaga) {
        String sql = "INSERT INTO vagas (nome, descricao, empresa_id, local) VALUES (?, ?, ?, ?)"
        PreparedStatement ps = connection.prepareStatement(sql)

        ps.setString(1, vaga.nome)
        ps.setString(2, vaga.descricao)
        ps.setInt(3, vaga.empresa_id)
        ps.setString(4, vaga.local)
        ps.execute()
    }

    @Override
    def delete(Integer id) {
        String sql = "DELETE FROM vagas WHERE id=${id_vaga}"

        PreparedStatement ps = connection.prepareStatement(sql)
        ps.execute()
        return null
    }

}
