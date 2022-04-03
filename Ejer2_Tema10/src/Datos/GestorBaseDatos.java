package Datos;

import Excepciones.Excepciones;
import Gestores.GestorArchivos;
import domain.articulos;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorBaseDatos {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT_ESPECIFICO = "SELECT * FROM articulos WHERE cod_art = ?";
    private static final String SQL_SELECT = "SELECT id_cc, saldo FROM cuentas";
    private static final String SQL_INSERT = "INSERT INTO articulos(cod_art, descripcion, precio, stock) VALUES(?, ?, ?, ?)";//Las interrogaciones indican que va a ser el parametro nombre, apellido, email y telefono en ese orden
    //private static final String SQL_UPDATE = "UPDATE articulos SET precio = precio + ? WHERE id_cc = ?";
    private static final String SQL_UPDATE = "UPDATE articulos SET descripcion = ?, precio =  ?, stock = stock + ? WHERE cod_art = ?";
    private static final String SQL_DELETE = "DELETE FROM articulos WHERE cod_art = ?";
    private static final String SQL_CreateTable= "CREATE TABLE articulos (cod_art INT NOT NULL AUTO_INCREMENT,descripcion VARCHAR(25) NULL, precio FLOAT NOT NULL, stock INT NULL , PRIMARY KEY (cod_art))";
    //private static final String SQL_UPDATE = "UPDATE usuarios SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idpersona = ?";
    //private static final String SQL_CreateTable= "CREATE TABLE articulos (cod_art INT NOT NULL AUTO_INCREMENT,descripcion VARCHAR(25) NULL, precio FLOAT NOT NULL, stock INT NULL , PRIMARY KEY (cod_art))";
    
    //--------------------------------------------------METODOS-----------------------------------------
    /*
        CrearBaseDatosNueva                 //Crea una nueva base de datos con el nombre que le pasemos
        CrearTablaNueva                     //Crea una nueva tabla con la consulta SQL_CreateTable
        SeleccionarDevuelveArray            //Devuelve la información de una tabla con la consulta SQL_Select en forma de array del modelo 
        SeleccionarEspecifico               //Devuelve la informacion de un solo registro con la consulta SQL_Select_Especifico en forma de objeto de modelo
        insertar                            //Inserta un registro en la tabla bd con la consulta SQL_Insert, debemos pasarle los valores en forma de modelo
        eliminar                            //Elimina un registro en la tabla de la bd con el id main, debemos pasarle un objeto con el contructor del id main del modelo
        eliminarGuardandoHistoricoBorrados  //Elimina un registro en la tabla y guarda el registro eliminado en un fichero de historicos
        actualizarInsertandoSiNoExiste      //Recibe un registro para actualizar y si no existe en vez de actualizarlo lo inserta directamente, debe recibir un objeto del modelo y tb suma la cantidad de saldo
        actualizar                          //Recibe un registro y lo actualiza
        existeRegistro                      //Comprueba si existe un registro, recibiendo un string en un campo y devuelve un booleano
    */
   
    public GestorBaseDatos() {
        Connection conn = null;
        PreparedStatement stmt = null;
    }

    public GestorBaseDatos(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    
//    public void crearBaseDatosNueva(String bd) throws SQLException, Excepciones{
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        try {
//            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
//        } catch (Excepciones ex) {
//            throw new Excepciones("Error al crear la tabla de la bd");
//        }
//        stmt = conn.prepareStatement("CREATE DATABASE "+bd);
//        stmt.executeUpdate();
//        Conexion.closeConnection(stmt);
//    }
    
//    public void crearTablaNueva()throws SQLException, Excepciones{
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        try {
//            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
//        } catch (Excepciones ex) {
//            throw new Excepciones("Error al crear la bd");
//        }
//        stmt = conn.prepareStatement(SQL_CreateTable);
//        stmt.executeUpdate();
//        Conexion.closeConnection(stmt);        
//    }
    
//    public List<PersonaDTO> seleccionarDevuelveArray() throws SQLException {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        PersonaDTO persona = null;
//        List<PersonaDTO> personas = new ArrayList<>();
//
//        try {
//            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
//            stmt = conn.prepareStatement(SQL_SELECT);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                int idPersona = rs.getInt("idpersona");
//                String nombre = rs.getString("nombre");
//                String apellido = rs.getString("apellido");
//                String email = rs.getString("email");
//                String telefono = rs.getString("telefono");
//                persona = new PersonaDTO(idPersona, nombre, apellido, email, telefono);//Construimos objetos de tipo persona
//                personas.add(persona);
//            }
//        } finally {//Cerramos los objetos con finally ya que a diferencia de catch siempre se ejecuta
//            try {//Se cierran en el orden inverso al que se han abierto
//                Conexion.closeConnection(rs);
//                Conexion.closeConnection(stmt);
//                if (this.conexionTransaccional == null) {//Si el objeto conexionTransaccional es diferente de nulo, no se debe de cerrar
//                    Conexion.closeConnection(conn);
//                }
//            } catch (SQLException ex) {
//                throw new Excepciones("Error al seleccionar la bd");
//            }
//        }
//        return personas;
//    }

    public articulos seleccionarEspecifico(String id) throws SQLException, Excepciones {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        articulos cuenta = null;

        try {
            
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ESPECIFICO);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String descripcion = rs.getString("descripcion");
                Float precio = rs.getFloat("precio");
                int stock = rs.getInt("stock");
                cuenta = new articulos(id, descripcion, precio, stock);//Construimos objetos de tipo cuenta
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
    
    public int insertar(articulos articulo) throws SQLException ,Excepciones{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);//Llenamos todos los parametros ? ? ? ? de la consulta SQLINSERT con el objeto persona que recibimos como parametro
            stmt.setString(1, articulo.getCod_art());
            stmt.setString(2, articulo.getDescripcion());
            stmt.setFloat(3, articulo.getPrecio());
            stmt.setInt(4, articulo.getStock());
            registros = stmt.executeUpdate();//Regresa el numero de registros afectados
        } catch (Excepciones ex) {
            throw new Excepciones("Error al insertar el articulo en la bd");
        } finally {
            try {
                Conexion.closeConnection(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.closeConnection(conn);
                }
            } catch (SQLException ex) {
                throw new Excepciones("Error al cerrar la conexion");
            }
        }
        return registros;
    }
    
    public int eliminar(articulos articulo) throws SQLException, Excepciones {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);//Llenamos todos los parametros ? ? ? ? de la consulta SQLINSERT con el objeto persona que recibimos como parametro
            stmt.setString(1, articulo.getCod_art());
            registros = stmt.executeUpdate();//Regresa el numero de registros afectados
        } catch (Excepciones ex) {
            throw new Excepciones("Error al eliminar un registro en la bd");
        } finally {
            try {
                Conexion.closeConnection(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.closeConnection(conn);
                }
            } catch (SQLException ex) {
                throw new Excepciones("Error al cerrar la conexion");
            }
        }
        return registros;
    }
    
    public int eliminarGuardandoHistoricoBorrados(articulos articulo) throws SQLException, Excepciones {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        articulos borrado = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            //Guardarlo en el fichero
            stmt = conn.prepareStatement(SQL_SELECT_ESPECIFICO);
            stmt.setString(1, articulo.getCod_art());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String descripcion = rs.getString("descripcion");
                Float precio = rs.getFloat("precio");
                int stock = rs.getInt("stock");
                borrado = new articulos(articulo.getCod_art(), descripcion, precio, stock);//Construimos objetos de tipo cuenta
            }            
            //Eliminarlo
            stmt = conn.prepareStatement(SQL_DELETE);//Llenamos todos los parametros ? ? ? ? de la consulta SQLINSERT con el objeto persona que recibimos como parametro
            stmt.setString(1, articulo.getCod_art());
            registros = stmt.executeUpdate();//Regresa el numero de registros afectados
            GestorArchivos.volcarModeloFileWriter(borrado);            
        } catch (Excepciones ex) {
            throw new Excepciones("Error al eliminar un registro en la bd");
        } finally {
            try {
                Conexion.closeConnection(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.closeConnection(conn);
                }
            } catch (SQLException ex) {
                throw new Excepciones("Error al cerrar la conexion");
            }
        }
        return registros;
    }
           
    public int actualizarInsertandoSiNoExiste(articulos articulo) throws SQLException, Excepciones {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);//Llenamos todos los parametros ? ? ? ? de la consulta SQLINSERT con el objeto persona que recibimos como parametro            
            stmt.setString(1, articulo.getDescripcion());
            stmt.setFloat(2, articulo.getPrecio());
            stmt.setInt(3, articulo.getStock());
            stmt.setString(4, articulo.getCod_art());
            registros = stmt.executeUpdate();//Regresa el numero de registros afectados
            if ( registros == 0){
                //no existe esa cuenta hay que dar de alta
                insertar(articulo);
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
    
//    public int actualizar(PersonaDTO persona) throws SQLException, Excepciones {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int registros = 0;
//        try {
//            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
//            stmt = conn.prepareStatement(SQL_UPDATE);//Llenamos todos los parametros ? ? ? ? de la consulta SQLINSERT con el objeto persona que recibimos como parametro
//            stmt.setString(1, persona.getNombre());
//            stmt.setString(2, persona.getApellido());
//            stmt.setString(3, persona.getEmail());
//            stmt.setString(4, persona.getTelefono());
//            stmt.setInt(5, persona.getIdPersona());
//            registros = stmt.executeUpdate();//Regresa el numero de registros afectados
//        } catch (Excepciones ex) {
//            throw new Excepciones("Error al actualizar la bd");
//        } finally {
//            try {
//                Conexion.closeConnection(stmt);
//                if (this.conexionTransaccional == null) {
//                    Conexion.closeConnection(conn);
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace(System.out);
//            }
//        }
//        return registros;
//    }
    
//    public boolean existeRegistro(Connection Conn, String id_a_buscar) {
//        Statement oSt = null;
//        ResultSet oRs = null;
//        String sSQL = " ";
//        boolean dbexisteRegistro = false;
//
//        try {
//            Conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
//            sSQL = "SELECT * FROM cuentas WHERE id_cc='" + id_a_buscar + "'";
//
//            oSt = Conn.createStatement();
//            oRs = oSt.executeQuery(sSQL);
//
//            if (oRs.next()) {
//                if (oRs.getRow() > 0) {
//                    dbexisteRegistro = true;
//                }
//            }
//
//            if (oSt != null) {
//                oSt.close();
//                oSt = null;
//            }
//            if (oRs != null) {
//                oRs.close();
//                oRs = null;
//            }
//        } catch (SQLException err) {
//            
//            oSt = null;
//            oRs = null;
//            sSQL = null;
//        } catch (Exception err) {
//
//            oSt = null;
//            oRs = null;
//            sSQL = null;
//        } finally {
//            oSt = null;
//            oRs = null;
//            sSQL = null;
//        }
//        return dbexisteRegistro;
//    }
}
