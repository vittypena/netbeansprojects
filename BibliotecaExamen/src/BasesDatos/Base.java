/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasesDatos;
import java.sql.*;
import java.io.*;
/**
 *
 * @author EDU
 */
public class Base {
    
    private static final String SQL_SELECT_ESPECIFICO = "SELECT id_cc, saldo FROM cuentas WHERE id_cc = ?";
    private static final String SQL_SELECT = "SELECT id_cc, saldo FROM cuentas";
    private static final String SQL_INSERT = "INSERT INTO cuentas(id_cc, saldo) VALUES(?, ?)";//Las interrogaciones indican que va a ser el parametro nombre, apellido, email y telefono en ese orden
    private static final String SQL_UPDATE = "UPDATE cuentas SET saldo = saldo + ? WHERE id_cc = ?";
    private static final String SQL_DELETE = "DELETE FROM cuentas WHERE id_cc = ?";
    //private static final String SQL_CreateTable= "CREATE TABLE articulos (cod_art INT NOT NULL AUTO_INCREMENT,descripcion VARCHAR(25) NULL, precio FLOAT NOT NULL, stock INT NULL , PRIMARY KEY (cod_art))";
    
    public Base() {
        Connection conn = null;
        PreparedStatement stmt = null;
    }
    
    
}
