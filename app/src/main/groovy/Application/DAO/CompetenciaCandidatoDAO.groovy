package Application.DAO

import java.sql.PreparedStatement

class CompetenciaCandidatoDAO extends BDConnect{

    def static insertCompetenciaDoCandidato(def id_candidato, def id_competencia, String nivel) {
        String sql = "INSERT INTO candidatos_competencias (id_candidato, id_competencia, nivel) VALUES (?, ?, ?)"


        PreparedStatement ps = connection.prepareStatement(sql)

        ps.setLong(1, id_candidato)
        ps.setInt(2, id_competencia)
        ps.setString(3, nivel)
        ps.execute()
    }
}
