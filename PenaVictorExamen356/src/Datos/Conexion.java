package Datos;

import Excepciones.Excepciones;
import java.sql.*;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/banco_central?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    //Esta conexion es para crear la base de datos si es necesario
    //private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String JDBC_USER = "examen";
    private static final String JDBC_PASSWORD = "examen";

    public static Connection getConnection() throws Excepciones {
        try {
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException ex) {
            throw new Excepciones("Error al conectar a la base de datos");
        }
    }

    //Sobrecargamos el metodo closeConnection
    public static void closeConnection(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void closeConnection(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }
}
