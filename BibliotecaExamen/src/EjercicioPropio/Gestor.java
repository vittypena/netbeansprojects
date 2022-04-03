/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioPropio;

import java.sql.*;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author EDU
 */
public class Gestor {

    public static void insertarDatos() throws Excepciones {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/probando", "dani", "dani");
            PreparedStatement pst = conn.prepareStatement("INSERT INTO PRUEBAS VALUES(?,?)");
            String valueNombre = JOptionPane.showInputDialog("Introduce aqui el nombre");
            String valueNumero = JOptionPane.showInputDialog("Introduce aqui el numero");
            pst.setString(1, valueNumero);
            pst.setString(2, valueNombre);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha insertado correctamente");
        } catch (SQLException e) {
            throw new Excepciones("Error al intentar conectar con la base de datos");
        }
    }

    public static void intercambiarDatos() throws Excepciones {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/probando", "dani", "dani");
            Statement st = conn.createStatement();
            String o = JOptionPane.showInputDialog("Introduce aqui el numero para remplazar");
            File fichero = new File("C:\\Users\\EDU\\Documents\\NetBeansProjects\\BibliotecaExamen\\Archivos\\Data" + o + ".dat");
            if (fichero.exists()) {
                st.executeUpdate("DELETE FROM PRUEBAS");
                try {
                    FileInputStream fis = new FileInputStream(fichero);
                    DataInputStream dis = new DataInputStream(fis);
                    for (int i = 0; i < 6; i++) {
                        PreparedStatement pst = conn.prepareCall("INSERT INTO PRUEBAS VALUES(?,?)");
                        String valor = dis.readUTF();
                        int codigo = dis.readInt();
                        String code = codigo + "";
                        pst.setString(1, code);
                        pst.setString(2, valor);
                        pst.executeUpdate();
                    }
                    JOptionPane.showMessageDialog(null, "Se ha remplazado todos correctamente");
                    dis.close();
                    fis.close();
                } catch (FileNotFoundException e) {
                    throw new Excepciones("No se ha podido encontrar la carpeta");
                } catch (IOException e) {
                    throw new Excepciones("No se ha podido encontrar la carpeta");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lo siento no se ha podido encontrar el archivo");
            }
        } catch (SQLException e) {
            throw new Excepciones("Error al intentar conectar con la base de datos");
        }
    }

    public static void listarDatos() throws Excepciones {
        Tabla frame = new Tabla();
        frame.setVisible(true);
        frame.setBounds(0, 0, 400, 400);
        frame.setLocationRelativeTo(null);
    }

    public static void cerrar() throws Excepciones {
        File f = new File("C:\\Users\\EDU\\Documents\\NetBeansProjects\\BibliotecaExamen\\Archivos\\Ultimo.txt");
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/probando", "dani", "dani");
            Statement st = conn.createStatement();
            FileWriter fw = new FileWriter(f);
            ResultSet rs = st.executeQuery("SELECT * FROM PRUEBAS");
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                fw.write("El codigo es: " + codigo + " el nombre es: " + nombre + "\n");
            }
            fw.close();
            System.exit(0);
        } catch (IOException e) {
            throw new Excepciones("No he ha encontrado el archivo");
        } catch (SQLException e) {
            throw new Excepciones("Error con la base de datos");
        }
    }
}
