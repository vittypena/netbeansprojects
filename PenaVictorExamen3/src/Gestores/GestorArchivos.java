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
import java.util.ArrayList;
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
                
                CuentasDTO updateCuenta = new CuentasDTO();
                updateCuenta.setId_cc(c.getId_cc());   
                updateCuenta.setSaldo(c.getSaldo());
                cuentaDao.actualizar(updateCuenta);
                conexion.commit();                             
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
    
private static ArrayList<String> lista = new ArrayList<String>();        
    public static void obtenerNombreFicherosRuta(File carpeta){
	File[] contenido = carpeta.listFiles();
	for(File file : contenido){
		if(file.isDirectory()){
                    obtenerNombreFicherosRuta(file);
		}else{
                    lista.add(file.getName());
		}
	}
    }

    public static ArrayList<String> getLista() {
        return lista;
    }

    public static void main(String[] args) {
        File carpeta = new File("F:\\dudasResueltas");
        obtenerNombreFicherosRuta(carpeta);
        for (Object string : getLista()) {
            System.out.println(string);
        }
    }
    
}
