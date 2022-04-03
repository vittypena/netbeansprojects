package Datos;

import Excepciones.Excepciones;
import Interfaces.JTableCuentas;
import domain.CuentasDTO;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorBaseDatos{

    private Connection conexionTransaccional;

    private static final String SQL_SELECT_ESPECIFICO = "SELECT id_cc, saldo FROM cuentas WHERE id_cc = ?";
    private static final String SQL_SELECT = "SELECT id_cc, saldo FROM cuentas";
    private static final String SQL_INSERT = "INSERT INTO cuentas(id_cc, saldo) VALUES(?, ?)";//Las interrogaciones indican que va a ser el parametro nombre, apellido, email y telefono en ese orden
    private static final String SQL_UPDATE = "UPDATE cuentas SET saldo = saldo + ? WHERE id_cc = ?";
    private static final String SQL_DELETE = "DELETE FROM cuentas WHERE id_cc = ?";
    //private static final String SQL_CreateTable= "CREATE TABLE articulos (cod_art INT NOT NULL AUTO_INCREMENT,descripcion VARCHAR(25) NULL, precio FLOAT NOT NULL, stock INT NULL , PRIMARY KEY (cod_art))";
    public GestorBaseDatos() {
        Connection conn = null;
        PreparedStatement stmt = null;
    }

    public GestorBaseDatos(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    
    public void seleccionar() throws SQLException, Excepciones {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CuentasDTO cuenta = null;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            JTableCuentas objeto = new JTableCuentas();
            while (rs.next()) {
                String idCuenta = rs.getString("id_cc");
                Double saldo = rs.getDouble("saldo");
                cuenta = new CuentasDTO(idCuenta, saldo);//Construimos objetos de tipo cuenta    
            }
        } finally {//Cerramos los objetos con finally ya que a diferencia de catch siempre se ejecuta
            try {//Se cierran en el orden inverso al que se han abierto
                Conexion.closeConnection(rs);
                Conexion.closeConnection(stmt);
                if (this.conexionTransaccional == null) {//Si el objeto conexionTransaccional es diferente de nulo, no se debe de cerrar
                    Conexion.closeConnection(conn);
                }
            } catch (SQLException ex) {
                throw new Excepciones("Error al seleccionar la bd");
            }
        }
    }
    
    public CuentasDTO seleccionarEspecifico(String id) throws SQLException, Excepciones {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CuentasDTO cuenta = null;

        try {
            
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ESPECIFICO);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Double saldo = rs.getDouble("saldo");
                cuenta = new CuentasDTO(id, saldo);//Construimos objetos de tipo cuenta
            }
        } finally {//Cerramos los objetos con finally ya que a diferencia de catch siempre se ejecuta
            try {//Se cierran en el orden inverso al que se han abierto
                Conexion.closeConnection(rs);
                Conexion.closeConnection(stmt);
                if (this.conexionTransaccional == null) {//Si el objeto conexionTransaccional es diferente de nulo, no se debe de cerrar
                    Conexion.closeConnection(conn);
                }
            } catch (SQLException ex) {
                throw new Excepciones("Error al seleccionar la bd");
            }
        }
        return cuenta;
    }

    public int insertar(CuentasDTO cuenta) throws SQLException ,Excepciones{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);//Llenamos todos los parametros ? ? ? ? de la consulta SQLINSERT con el objeto persona que recibimos como parametro
            stmt.setString(1, cuenta.getId_cc());
            stmt.setDouble(2, cuenta.getSaldo());
            registros = stmt.executeUpdate();//Regresa el numero de registros afectados
        } catch (Excepciones ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Conexion.closeConnection(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.closeConnection(conn);
                }
            } catch (SQLException ex) {
                throw new Excepciones("Error al insertar en la bd");
            }
        }
        return registros;
    }

    public int actualizar(CuentasDTO cuenta) throws SQLException, Excepciones {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);//Llenamos todos los parametros ? ? ? ? de la consulta SQLINSERT con el objeto persona que recibimos como parametro            
            stmt.setDouble(1, cuenta.getSaldo());
            stmt.setString(2, cuenta.getId_cc());
            registros = stmt.executeUpdate();//Regresa el numero de registros afectados
            if ( registros == 0){
                //no existe esa cuenta hay que dar de alta
                insertar(cuenta);
            }
        } catch (Excepciones ex) {
            Logger.getLogger(GestorBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Conexion.closeConnection(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.closeConnection(conn);
                }
            } catch (SQLException ex) {
                throw new Excepciones("Error al actualizar la bd");
            }
        }
        return registros;
    }
    
    public  boolean existeRegistro(Connection Conn, String id_a_buscar){
         Statement oSt = null;
         ResultSet oRs = null;
         String sSQL= " ";
         boolean dbexisteRegistro= false; 

         try{
             Conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
             sSQL = "SELECT * FROM cuentas WHERE id_cc='" + id_a_buscar + "'";


             oSt = Conn.createStatement();
             oRs = oSt.executeQuery(sSQL);

             if(oRs.next()){
                if(oRs.getRow() > 0){
                    dbexisteRegistro= true;
                }
             }

             if (oSt != null) {oSt.close();oSt = null;}
             if (oRs != null) {oRs.close();oRs = null;}
         }catch(SQLException err){

             oSt = null;
             oRs = null;
             sSQL=null;
         }catch(Exception err){

             oSt = null;
             oRs = null;
             sSQL=null;  
         }finally{
             oSt = null;
             oRs = null;
             sSQL=null;
         }
         return dbexisteRegistro;
 }
}
