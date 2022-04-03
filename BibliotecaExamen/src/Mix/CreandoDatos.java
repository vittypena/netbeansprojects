/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mix;

import java.io.*;

/**
 *
 * @author EDU
 */
public class CreandoDatos {

    static File f1 = new File("..\\BibliotecaExamen\\Archivos\\Data1.dat");
    static File f2 = new File("..\\BibliotecaExamen\\Archivos\\Data2.dat");
    static File f3 = new File("..\\BibliotecaExamen\\Archivos\\Data3.dat");

    public static void escribeBinario1() throws IOException {
        FileOutputStream fos = new FileOutputStream(f1);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF("Chacho");
        dos.writeInt(111);
        dos.writeUTF("Jimenez");
        dos.writeInt(222);
        dos.writeUTF("Juan");
        dos.writeInt(333);
        dos.writeUTF("Fernando");
        dos.writeInt(444);
        dos.writeUTF("Kiko");
        dos.writeInt(555);
        dos.writeUTF("Daniel");
        dos.writeInt(666);
    }

    public static void escribeBinario2() throws IOException {
        FileOutputStream fos = new FileOutputStream(f2);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF("Eva");
        dos.writeInt(1111);
        dos.writeUTF("Eduardo");
        dos.writeInt(2222);
        dos.writeUTF("Valentin");
        dos.writeInt(3333);
        dos.writeUTF("Vicente");
        dos.writeInt(4444);
        dos.writeUTF("Ana");
        dos.writeInt(5555);
        dos.writeUTF("Maria");
        dos.writeInt(6666);
    }

    public static void escribeBinario3() throws IOException {
        FileOutputStream fos = new FileOutputStream(f3);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF("Saruman");
        dos.writeInt(11111);
        dos.writeUTF("Eragorn");
        dos.writeInt(22222);
        dos.writeUTF("Yurima");
        dos.writeInt(33333);
        dos.writeUTF("Ludovico");
        dos.writeInt(44444);
        dos.writeUTF("Michael");
        dos.writeInt(55555);
        dos.writeUTF("Nyman");
        dos.writeInt(66666);
    }

    public static void leerBinario1() throws IOException {
        FileInputStream fis = new FileInputStream(f1);
        DataInputStream dis = new DataInputStream(fis);
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());  
    }

    public static void leerBinario2() throws IOException {
        FileInputStream fis = new FileInputStream(f2);
        DataInputStream dis = new DataInputStream(fis);
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
    }

    public static void leerBinario3() throws IOException {
        FileInputStream fis = new FileInputStream(f3);
        DataInputStream dis = new DataInputStream(fis);
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
    }

    public static void main(String[] args) {
        try {
            escribeBinario1();
            escribeBinario2();
            escribeBinario3();
            leerBinario1();
            leerBinario2();
            leerBinario3();
        } catch (IOException e) {

        }
    }
}
