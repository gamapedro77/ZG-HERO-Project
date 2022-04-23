package Application.DAO

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.text.SimpleDateFormat

class BDConnect {
    String DATABASE_URL = "jdbc:postgresql://localhost:5432/aczg"
    String usuario = "aczg"
    String senha = "aczg"
    Connection connection = DriverManager.getConnection(DATABASE_URL, usuario, senha)


}
