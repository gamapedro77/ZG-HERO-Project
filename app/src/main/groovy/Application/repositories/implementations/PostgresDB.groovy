package Application.repositories.implementations

import Application.repositories.IDatabase

import java.sql.Connection
import java.sql.DriverManager

class PostgresDB implements IDatabase {
    public static String DATABASE_URL = "jdbc:postgresql://localhost:5432/linketinder"
    public static String usuario = "aczg"
    public static String senha = "admin"
    public static Connection connection = DriverManager.getConnection(DATABASE_URL, usuario, senha)
}
