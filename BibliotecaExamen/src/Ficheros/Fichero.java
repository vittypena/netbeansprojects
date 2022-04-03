/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ficheros;

import java.io.*;

/**
 *
 * @author EDU
 */
public class Fichero {

    private static File f = new File("..\\BibliotecaExamen\\Archivos\\Nombre.txt");

    public static void escribirFichero() {
        try {
            FileWriter fw = new FileWriter(f);
            fw.write("Escribe aqui la cadena \n");
            fw.write("Esta es otra cadena \n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerFichero() {
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        escribirFichero();
        leerFichero();
    }
}
