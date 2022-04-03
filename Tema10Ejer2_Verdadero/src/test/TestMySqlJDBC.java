package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        //Para conectarnos a la BD de MySql , escribimos la cadena de conexion a MySql, dependiendo de la BD tiene una cadena u otra y habria que buscarla
        String url = "jdbc:mysql://localhost:3306/primerabase?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";//test es el nombre de la BD. con UseSSL usamos el puerto no seguro para evitar errores, en las ultimas versiones se ha mejorado la seguridad y hay que especificar más
        try {
            //El siguiente paso ya no es requerido pero se puede encontrar a dia de hoy
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,"root", "");//Para conectarse
            Statement instruccion = conexion.createStatement();//Instanciamos el objeto
            String sql = "SELECT idpersona, nombre, apellido, email, telefono FROM usuarios";
            ResultSet resultado = instruccion.executeQuery(sql);//Esta sentencia puede dar más de un registro por lo tanto tenemos que iterar
            while(resultado.next()){
                System.out.print("Id Persona:" + resultado.getInt("idpersona"));
                System.out.print("   Nombre:" + resultado.getString("nombre"));
                System.out.print("   Apellido:" + resultado.getString("apellido"));
                System.out.print("   Email:" + resultado.getString("email"));
                System.out.print("   Telefono:" + resultado.getString("telefono"));
                System.out.println("");
            }
            //Ahora debemos cerrar todos los objetos
            resultado.close();
            instruccion.close();
            conexion.close();
        //} catch (ClassNotFoundException ex) {
        //    ex.printStackTrace(System.out);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
