/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import myException.MyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cuenta;

/**
 *
 * @author Ismael
 */
public class GestorDB {
    // Atributos
    private String db;
    private String login;
    private String password;
    private String servidorMySql;
    private Connection conexion;

    public GestorDB(String db, String login, String password, String servidorMySql) {
        // paso los datos pero no la conexion
        this.db = db;
        this.login = login;
        this.password = password;
        this.servidorMySql = servidorMySql;
        this.conexion = null;
    }

    public void abrirConexion() throws MyException {// es lo primero que hara el programa
        try {
            Class.forName("com.mysql.jdbc.Driver");// carga el driver
            conexion = DriverManager.getConnection(servidorMySql + db, login, password);// crea la conexion
        } catch (ClassNotFoundException ex) {
            throw new MyException(ex.getMessage() + " Abriendo conexión");
        } catch (SQLException ex) {
            throw new MyException("No se puede establecer la conexion en : "
                    + servidorMySql + "  " + db + " con el usuario " + login + "Codigo: " + ex.getErrorCode());
        }
    }
    
    public void cerrarConexion() throws MyException {// cierra la conexion con el servidor y la base de datos
        // Muy importante que al cerrar la aplicación se muestre este mensaje
        try {
            if (conexion != null) {// es dificil que sea nulo, pero puede ocurrir
                conexion.close();
                System.out.println("Conexión Cerrada OK");// importante ponerlo de momento
            }
        } catch (SQLException ex) {
            throw new MyException(ex.getMessage() +
                    "Problema al cerrar la conexion, comprueba la integridad de los datos" 
                    + ex.getErrorCode());
        }
    }

    public int ejecutarUpdate(String sentencia) throws MyException {// le paso una cadena
        // solo sirve para modificar datos (está sin parametrizar--> es standard)
        // coge la cadena y ejecuta la cadena
        int n = 0;
        PreparedStatement st = null;
        try {
            st = conexion.prepareStatement(sentencia);// compilamos la sentencia (muy importante)
            n = st.executeUpdate();
            return n;// número de cambios en la base de datos
        } catch (SQLException ex) {
            throw new MyException(ex.getMessage() + "Codigo del error1: " + ex.getErrorCode());
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    throw new MyException(ex.getMessage() + "Codigo del error2: " + ex.getErrorCode());
                }
            }
        }
    }
    
    public int altaPescado(Cuenta c) throws MyException {// le paso un articulo (si tengo un articulo ha pasado por el constructor y los set estna bien)
        // lo unico que no he podido comprobar es el codigo del articulo, que puede estar repetido
        int n = 0;//Número de artículos que se han insertado.
        PreparedStatement ps = null;//Sentencia preparada
        try {
                ps = conexion.prepareStatement("INSERT INTO ? VALUES (?);");
                // tengo que añadir los valores para cada ? 
                ps.setString(1, c.getId_cc());
                ps.setDouble(2, c.getSaldo());
                return ps.executeUpdate();
            

        } catch (SQLException ex) {
            throw new MyException(ex.getMessage() + "Codigo del error3: " + ex.getErrorCode());
        } finally {//Las sentencias se deben dejar cerradas para ahorrar en recursos
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new MyException(ex.getMessage() + "Codigo del error4: " + ex.getErrorCode());
                }
            }
        }
    }
    
    public int modificarCuentas(Cuenta c) throws MyException {
        int n = 0;
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement("UPDATE id_cc SET saldo = saldo + ? WHERE id_cc = ?;");
            ps.setDouble(1, c.getSaldo());
            ps.setString(2, c.getId_cc());
            n = ps.executeUpdate();
            if (n == 0) {
                ps = conexion.prepareStatement("INSERT INTO ? VALUES (?);");
                ps.setString(1, c.getId_cc());
                ps.setDouble(2, c.getSaldo());
            }
            return n;
        } catch (SQLException ex) {
            throw new MyException("Error en la base de datos modificando" + ex.getMessage() + "" + ex.getErrorCode());
        } finally {
            // elimino la preparedStatement porque acapara muchos recuros
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new MyException(ex.getMessage() + " Error cerrando" + "" + ex.getErrorCode());
                }
            }
        }
    }
    
    public ResultSet listado() throws MyException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall("SELECT * FROM cuentas;");
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            throw new MyException("Error leyendo los datos " + ex.getMessage() + "Código: " + ex.getErrorCode());
        } finally {
            return rs;
        }
    }
    
}
