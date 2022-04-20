package Application.DAO


import Application.model.Vaga

import java.sql.PreparedStatement
import java.sql.ResultSet

class VagasDAO extends BDConnect{

    def selectAllVagas() {
        String sql = "INSERT * FROM vagas"
        PreparedStatement ps = connection.prepareStatement(sql)
        ResultSet rs = ps.executeQuery()
        while(rs.next()) {
            Vaga vaga = new Vaga(rs.getString("nome"), rs,getString(descricao), rs.getInt("empresa_id"), rs.getString("local"))
            println vaga.nome
        }
    }

    def insertVaga(Vaga vaga) {
        String sql = "INSERT INTO vagas (nome, descricao, empresa_id, local) VALUES (?, ?, ?, ?)"
        PreparedStatement ps = connection.prepareStatement(sql)

        ps.setString(1, vaga.nome)
        ps.setString(2, vaga.descricao)
        ps.setInt(3, vaga.empresa_id)
        ps.setString(4, vaga.local)
        ps.execute()
    }

    def removeVaga(int id_vaga) {
        String sql = "DELETE FROM vagas WHERE id=${id_vaga}"

        PreparedStatement ps = connection.prepareStatement(sql)
        ps.execute()
    }
}
