package datos;

import domain.PersonaDTO;
import java.sql.*;
import java.util.*;

public class GestorBaseDatos implements PersonaDao {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT idpersona, nombre, apellido, email, telefono FROM usuarios";
    private static final String SQL_INSERT = "INSERT INTO usuarios(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";//Las interrogaciones indican que va a ser el parametro nombre, apellido, email y telefono en ese orden
    private static final String SQL_UPDATE = "UPDATE usuarios SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idpersona = ?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE idpersona = ?";
    private static final String SQL_CreateTable= "CREATE TABLE articulos (cod_art INT NOT NULL AUTO_INCREMENT,descripcion VARCHAR(25) NULL, precio FLOAT NOT NULL, stock INT NULL , PRIMARY KEY (cod_art))";
    public GestorBaseDatos() {
        Connection conn = null;
        PreparedStatement stmt = null;
    }

    public GestorBaseDatos(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public void crearBaseDatosNueva(String bd) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        stmt = conn.prepareStatement("CREATE DATABASE "+bd);
        stmt.executeUpdate();
        Conexion.closeConnection(stmt);
    }
    
    public void crearTablaNueva()throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_CreateTable);
        stmt.executeUpdate();
        Conexion.closeConnection(stmt);
        
    }
    
    public List<PersonaDTO> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO persona = null;
        List<PersonaDTO> personas = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("idpersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                persona = new PersonaDTO(idPersona, nombre, apellido, email, telefono);//Construimos objetos de tipo persona
                personas.add(persona);
            }
        } finally {//Cerramos los objetos con finally ya que a diferencia de catch siempre se ejecuta
            try {//Se cierran en el orden inverso al que se han abierto
                Conexion.closeConnection(rs);
                Conexion.closeConnection(stmt);
                if (this.conexionTransaccional == null) {//Si el objeto conexionTransaccional es diferente de nulo, no se debe de cerrar
                    Conexion.closeConnection(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return personas;
    }

    public int insertar(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);//Llenamos todos los parametros ? ? ? ? de la consulta SQLINSERT con el objeto persona que recibimos como parametro
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            registros = stmt.executeUpdate();//Regresa el numero de registros afectados
        } finally {
            try {
                Conexion.closeConnection(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.closeConnection(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int actualizar(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);//Llenamos todos los parametros ? ? ? ? de la consulta SQLINSERT con el objeto persona que recibimos como parametro
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());
            registros = stmt.executeUpdate();//Regresa el numero de registros afectados
        } finally {
            try {
                Conexion.closeConnection(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.closeConnection(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int eliminar(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);//Llenamos todos los parametros ? ? ? ? de la consulta SQLINSERT con el objeto persona que recibimos como parametro
            stmt.setInt(1, persona.getIdPersona());
            registros = stmt.executeUpdate();//Regresa el numero de registros afectados
        } finally {
            try {
                Conexion.closeConnection(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.closeConnection(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
