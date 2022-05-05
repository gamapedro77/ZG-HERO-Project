package Application.DAO.implementations

import Application.DAO.IDAO
import Application.model.IModel
import Application.repositories.IDatabase

import java.sql.PreparedStatement

class CompetenciaCandidatoDAO implements IDAO{
    def connection

    CompetenciaCandidatoDAO(IDatabase database){
        this.connection = database.connection
    }

    def insert(IModel competencia) {
        String sql = "INSERT INTO candidatos_competencias (id_candidato, id_competencia, nivel) VALUES (?, ?, ?)"


        PreparedStatement ps = connection.prepareStatement(sql)

        ps.setLong(1, competencia.id_candidato)
        ps.setInt(2, competencia.id_competencia)
        ps.setString(3, competencia.nivel)
        ps.execute()
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
