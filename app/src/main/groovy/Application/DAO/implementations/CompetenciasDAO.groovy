package Application.DAO.implementations

import Application.DAO.IDAO
import Application.model.IModel
import Application.repositories.IDatabase

import java.sql.PreparedStatement
import java.sql.ResultSet

class CompetenciasDAO implements IDAO{
    def connection

    CompetenciasDAO(IDatabase database) {
        this.connection = database.connection
    }

    def selectAllCompetencias() {
        String sql = "SELECT * FROM competencias"

        PreparedStatement ps = connection.prepareStatement(sql)

        ResultSet rs = ps.executeQuery()
        while(rs.next()) {
            println rs.getString("nome")
        }
    }

    def insert(IModel competencia) {
        String sql = "INSERT INTO competencias (nome) VALUES (?)"

        PreparedStatement ps = connection.prepareStatement(sql)

        ps.setString(1, competencia.nome)
        ps.execute()
    }

    def searchCompetencia(String nome) {
        String sql = "SELECT * FROM competencias WHERE nome=(?)"
        PreparedStatement ps = connection.prepareStatement(sql)
        ps.setString(1, nome)

        ResultSet rs = ps.executeQuery()
        if(rs.next()) {
            return [rs.getInt("id"), rs.getString("nome")]
        }
        return []
    }


    @Override
    def delete(Integer id) {
        return null
    }

    @Override
    def readAll() {
        return null
    }

    @Override
    def selectById(Integer id) {
        return null
    }
}
