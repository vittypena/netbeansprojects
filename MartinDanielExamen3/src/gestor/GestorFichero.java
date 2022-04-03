/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.Cuenta;
import myException.MyException;

/**
 *
 * @author Alumno
 */
public class GestorFichero {

    private final File fichero;
    private final static String NOMBRE_CARPETA = "ficheros";
    private final static String NOMBRE_FILE = "hacienda.obg";
    private static GestorFichero f;
    private static ArrayList<Cuenta> listaCuenta;

    //----------------------------------------------------------------------------
    public GestorFichero(String nombreFichero) throws MyException {
        //Prepara la carpeta
        File carpeta = new File(NOMBRE_CARPETA);
        boolean crearCarpeta;
        if (!carpeta.exists()) {
            crearCarpeta = carpeta.mkdir();
            if (!crearCarpeta) {
                throw new MyException("Imposible crear la carpeta: " + carpeta.getAbsolutePath());
            }
        }
        fichero = new File(carpeta, nombreFichero);
    }

    //----------------------------------------------------------------------------
    public ArrayList<Cuenta> leoFicheroToArray(GestorDB con) throws MyException {
        DataInputStream fIn = null;
        if (fichero.exists()) {
            try {
                fIn = new DataInputStream(new FileInputStream(fichero));
                while (true) {
                    Cuenta p = new Cuenta(fIn.readUTF(), fIn.readDouble());
                    con.modificarCuentas(p);
                    if (Math.abs(p.getSaldo()) > 3000) {
                        listaCuenta.add(p);
                    }
                }
            } catch (EOFException ex) {
                return listaCuenta;
            } catch (FileNotFoundException ex) {
                throw new MyException("No se ha podido ENCONTRAR el fichero" + fichero.getAbsolutePath());
            } catch (IOException ex) {
                throw new MyException("No se ha terminar de leer el fichero" + fichero.getAbsolutePath());
            } finally {
                if (fIn != null) {
                    try {
                        fIn.close();
                    } catch (IOException e) {
                        throw new MyException("El fichero está dañado" + fichero.getAbsolutePath());
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<Cuenta> leoFichero() throws MyException {
        ObjectInputStream fIn = null;
        ArrayList<Cuenta> lista;
        if (fichero.exists()) {
            lista = new ArrayList<>();
            try {
                fIn = new ObjectInputStream(new FileInputStream(fichero));
                while (true) {
                    lista.add((Cuenta) fIn.readObject());
                }
            } catch (EOFException ex) {
                return lista;
            } catch (FileNotFoundException ex) {
                throw new MyException("Imposible abrir para lectura: " + fichero.getAbsolutePath());
            } catch (IOException ex) {
                throw new MyException("Imposible leer: " + fichero.getAbsolutePath());
            } catch (ClassNotFoundException ex) {
                throw new MyException("Datos no legibles: " + fichero.getAbsolutePath());
            } finally {
                if (fIn != null) {
                    try {
                        fIn.close();
                    } catch (IOException ex) {
                        throw new MyException("Imposible cerrar: " + fichero.getAbsolutePath());
                    }
                }

            }
        }
        return null;
    }

    public void escriboFichero(ArrayList<Cuenta> lista) throws MyException {
        ObjectOutputStream fOut = null;
        try {
            //abro el fichero para escritura
            fOut = new ObjectOutputStream(new FileOutputStream(fichero));
            if (fichero.exists()) {
                    fOut.writeObject(lista);
                }  
          
        } catch (FileNotFoundException ex) {
            throw new MyException("Imposible abrir en " + fichero.getAbsolutePath());
        } catch (IOException ex) {
            throw new MyException("Imposible escribrir en " + fichero.getAbsolutePath());
        } finally {
            try {
                if (fOut != null) {
                    fOut.close();
                }
            } catch (IOException ex) {
                throw new MyException("Imposible cerrar el archivo. Comprobar "
                        + "la validez de la informacion " + fichero.getAbsolutePath());
            }
        }
    }
    
     public static ArrayList<Cuenta> leeDatos() throws MyException {
        //Inicializas y lees el fichero recogiendo los datos que pueda a ver en el fichero
        listaCuenta = new ArrayList<>();
        f = new GestorFichero(NOMBRE_FILE);
        listaCuenta = f.leoFichero();
        return listaCuenta;
    }
     
    public static void guardoDatos() throws MyException {
        f = new GestorFichero(NOMBRE_FILE);
        f.escriboFichero(listaCuenta);
    }

    //----------------------------------------------------------------------------
}
