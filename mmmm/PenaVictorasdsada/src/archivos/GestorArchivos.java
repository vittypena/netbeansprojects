package gestores;

import excepciones.Excepciones;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import modelos.Usuarios;

public class GestorArchivos {
    public static void leerInfoArchivo(File archivo) throws Excepciones {        
        int contador = 0;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura;
            while ((lectura = entrada.readLine()) != null) {
                String nombre = "";
                String password = "";
                String email = "";
                String telefono = "";
                boolean informacion = false;
                String[] strArr = lectura.split("\\ ");
                for (String str : strArr) {
                    if (contador == 0) {
                        nombre = str;
                    } else if (contador == 1) {
                        password = str;
                    } else if (contador == 2) {
                        email = str;
                    } else if (contador == 3) {
                        telefono = str;
                    } else if (contador == 4) {
                        if (str.equals("si")) {
                            informacion = true;
                        } else if (str.equals("no")) {
                            informacion = false;
                        }
                    }
                    contador++;
                }
                contador = 0;
                gestores.GestorUsuarios.añadirUsuario(new Usuarios(nombre, password, email, telefono, informacion));
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
