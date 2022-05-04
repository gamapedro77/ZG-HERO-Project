package Application.repositories

import java.sql.Connection
import java.sql.DriverManager

interface IDatabase {
    public static String DATABASE_URL
    public static String usuario
    public static String senha
    public static Connection connection
}