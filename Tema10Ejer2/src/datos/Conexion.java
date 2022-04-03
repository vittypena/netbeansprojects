package datos;

import java.sql.*;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/primerabase?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
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
