package Gestores;

import Datos.Conexion;
import Datos.GestorBaseDatos;
import Excepciones.Excepciones;
import domain.CuentasDTO;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import modelos.Usuarios;

public class GestorArchivos {

    public static void leerFichero(File fichero) throws Excepciones{
        try {
            DataInputStream entrada = new DataInputStream(new FileInputStream(fichero));
            while(true){
                CuentasDTO c = new CuentasDTO(entrada.readUTF(), entrada.readDouble());
                //A la coleccion de hacienda
                if(Math.abs(c.getSaldo()) > 3000){
                    gestores.GestorCuentas.hacienda.add(c);
                }
                //Actualizar en la base de datos con c
                Connection conexion = null;
                conexion = Conexion.getConnection();
                if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);//Si es verdadero lo ponemos en false
                }
                GestorBaseDatos cuentaDao = new GestorBaseDatos(conexion);
                if(cuentaDao.existeRegistro(conexion, c.getId_cc())){//Si existe se actualiza
                    CuentasDTO cambiarCuenta = cuentaDao.seleccionarEspecifico(c.getId_cc());
                    CuentasDTO updateCuenta = new CuentasDTO();
                    updateCuenta.setId_cc(c.getId_cc());   
                    c.aumentarSaldo(cambiarCuenta.getSaldo());
                    updateCuenta.setSaldo(c.getSaldo());
                    cuentaDao.actualizar(updateCuenta);
                    conexion.commit();
                }else{//Se crea;
                    cuentaDao.insertar(c);
                }                
            }
        } catch(EOFException ex){
            
        } catch (FileNotFoundException ex) {
            throw new Excepciones("El fichero no existe");
        } catch (IOException ex) {
            throw new Excepciones("Error al leer el archivo");
        } catch (SQLException ex) {
            throw new Excepciones("Error de sql");
        }
    }
    
    public static void crearFicheroObjectOutputStream() throws Excepciones{
            FileOutputStream fichero = null;
        try {
            fichero = new FileOutputStream("src\\ficheros\\hacienda.obj");        
            ObjectOutputStream entrada;        
            entrada = new ObjectOutputStream(fichero);        
            for (CuentasDTO cuentasDTO : gestores.GestorCuentas.hacienda) {
                entrada.writeObject(cuentasDTO);
            }
        }catch(FileNotFoundException ex){
            throw new Excepciones("Fichero no encontrado");
        }catch(IOException ex){
            throw new Excepciones("Error");
        }finally{
            try{
                fichero.close();
            }catch(IOException ex){
                
            }
        }
    }
}
