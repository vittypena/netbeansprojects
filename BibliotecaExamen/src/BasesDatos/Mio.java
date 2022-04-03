/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasesDatos;

import java.sql.*;

/**
 *
 * @author EDU
 */
public class Mio {

    static Statement st;
    static Connection conn;
    static PreparedStatement pst;

    public static void establecerConexion() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_central", "dani", "dani");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la Base de Datos");
        }
    }

    public static void prepararStatement() {
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error al preparar el Statement");
        }
    }

    public static void seleccionar() {
        try {
            String sql = "SELECT * FROM CUENTA";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String tabla1 = rs.getString(0);
                String tabla2 = rs.getString(1);
                System.out.println(tabla1);
                System.out.println(tabla2);
            }
        } catch (SQLException e) {
            System.out.println("Error en la seleccion de datos");
        }
    }

    public static void insertar() {
        try {
            String sql = "INSERT INTO TABLE VALUES(?,?,?)";
            String valor1 = "eyu1";
            String valor2 = "eyi2";
            String valor3 = "eyo3";
            pst.setString(1, valor1);
            pst.setString(2, valor2);
            pst.setString(3, valor3);
            pst.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error en la inserccion de datos");
        }
    }

    public static void borrar() {
        try {
            String sql = "DELETE FROM TABLA WHERE ID = ?";
            String valor1 = "eyi1";
            pst.setString(1, valor1);
            pst.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error en el borrado de datos");
        }
    }
}
