/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Binarios;

import java.io.*;

/**
 *
 * @author EDU
 */
public class Binario {

    static File f = new File("C:\\Users\\EDU\\Documents\\NetBeansProjects\\BibliotecaExamen\\Archivos\\Binario.dat");

    public static void escribeBinario() throws IOException {
        FileOutputStream fos = new FileOutputStream(f);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF("Mira estoy escribiendo en binario");
        dos.writeUTF("Pues es más facil de lo que pensaba");
    }

    public static void leerBinario() throws IOException {
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        System.out.println(dis.readUTF());
        System.out.println(dis.readUTF());
    }

    public static void main(String[] args) {
        try {
            escribeBinario();
            leerBinario();
        } catch (IOException e) {

        }
    }
}
