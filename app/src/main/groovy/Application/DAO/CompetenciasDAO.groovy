package Application.DAO


import java.sql.PreparedStatement
import java.sql.ResultSet

class CompetenciasDAO extends BDConnect{

    def static selectAllCompetencias() {
        String sql = "SELECT * FROM competencias"

        PreparedStatement ps = connection.prepareStatement(sql)

        ResultSet rs = ps.executeQuery()
        while(rs.next()) {
            println rs.getString("nome")
        }
    }

    def static insertCompetencia(String competencia) {
        String sql = "INSERT INTO competencias (nome) VALUES (?)"

        PreparedStatement ps = connection.prepareStatement(sql)

        ps.setString(1, competencia)
        ps.execute()
    }

    def static searchCompetencia(String nome) {
        String sql = "SELECT * FROM competencias WHERE nome=(?)"
        PreparedStatement ps = connection.prepareStatement(sql)
        ps.setString(1, nome)

        ResultSet rs = ps.executeQuery()
        if(rs.next()) {
            return [rs.getInt("id"), rs.getString("nome")]
        }
        return []
    }
}
