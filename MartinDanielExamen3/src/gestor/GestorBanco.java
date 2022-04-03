/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.util.ArrayList;
import java.util.HashSet;
import modelo.Cuenta;
import myException.MyException;

/**
 *
 * @author Alumno
 */
public class GestorBanco {
    
    private static ArrayList<Cuenta> listaCuenta;
    private final static String NOMBRE_FILE = "hacienda.obg";
    private static GestorFichero f;
    
    public static ArrayList<Cuenta> leeDatos() throws MyException {
        //Inicializas y lees el fichero recogiendo los datos que pueda a ver en el fichero
        listaCuenta = new ArrayList<>();
        f = new GestorFichero(NOMBRE_FILE);
        listaCuenta = f.leoFichero();
        return listaCuenta;
    }
    
    public static void inicializar() {
        listaCuenta = new ArrayList<>();
    }
    
    public static int tamagno() {
        return listaCuenta.size();
    }
    
    
    public static boolean addPescado(Cuenta c) {
        return listaCuenta.add(c);
    }
    
    public static ArrayList<Cuenta> getListaPescados() {
        return listaCuenta;
    }
    
    public static void guardoDatos() throws MyException {
        f = new GestorFichero(NOMBRE_FILE);
        f.escriboFichero(listaCuenta);
    }
}
