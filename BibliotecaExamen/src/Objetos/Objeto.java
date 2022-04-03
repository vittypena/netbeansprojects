/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author EDU
 */
public class Objeto implements Serializable {

    static File f = new File("C:\\Users\\EDU\\Documents\\NetBeansProjects\\BibliotecaExamen\\Archivos\\Objetos.obj");

    public static void escribirObjeto() throws IOException, FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream ois = new ObjectOutputStream(fos);
        Cuenta c = new Cuenta("Jose", "Palestina");
        Cuenta d = new Cuenta("Paquito", "Francia");
        ois.writeUnshared(c);
        ois.writeUnshared(d);
        ois.close();
        fos.close();
    }

    public static void leerObjeto() throws IOException, ClassNotFoundException, EOFException {
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        System.out.println(ois.readUnshared());
        System.out.println(ois.readUnshared());
        ois.close();
        fis.close();
    }

    public static void main(String[] args) {
        try {
            escribirObjeto();
            leerObjeto();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException eee) {
            eee.printStackTrace();
        }
    }
}
