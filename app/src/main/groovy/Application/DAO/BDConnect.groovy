package Application.DAO

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.text.SimpleDateFormat

class BDConnect {
    public static String DATABASE_URL = "jdbc:postgresql://localhost:5432/aczg"
    public static String usuario = "aczg"
    public static String senha = "aczg"
    public static Connection connection = DriverManager.getConnection(DATABASE_URL, usuario, senha)


}
