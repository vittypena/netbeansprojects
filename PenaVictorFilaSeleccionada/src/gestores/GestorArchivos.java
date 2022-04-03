package gestores;

import excepciones.Excepciones;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Usuarios;

public class GestorArchivos {

    public static void leerInfoArchivo(File archivo) throws Excepciones {     //Lee la informacion de un archivo y va creando usuarios segun va leyendo la informacion por lineas   
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

    public static void modificarDatoLinea(String filaAntigua, String filaNueva) {//Debe recibir la linea antigua a modificar y la linea nueva para sustituirla y cambiar asi el dato
        String lineToRemove = filaAntigua;

        File inputFile = new File("src\\archivos\\usuarios.txt");//El archivo destino
        File outputFile = new File("src\\archivos\\usuarios_nuevo.txt");//Un archivo en la misma ruta

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String currentLine;

            while ((currentLine = entrada.readLine()) != null) {
                if (currentLine.trim().equals(lineToRemove)) {
                    writer.write(filaNueva + System.getProperty("line.separator"));
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            entrada.close();
            inputFile.delete();
            outputFile.renameTo(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void añadirLinea(String fila){//Debe recibir la linea a añ±adir debajo
        File archivo = new File("src/archivos/usuarios.txt");//El archivo destino
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));
                    writer.write(fila + System.getProperty("line.separator"));
                    writer.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                }
    }
    
    public static void volcarColeccion(Set<Usuarios> coleccion){//Recibira una coleccion y la volcara en el fichero
        File ruta = new File("src/archivos/usuarios.txt");//El archivo destino
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(ruta);
        BufferedWriter escritura = new BufferedWriter(fileWriter);
        for (Usuarios listaUsuarios : coleccion) {
            escritura.write(listaUsuarios.toString());
            escritura.newLine();
        }
            escritura.close();
        } catch (IOException ex) {
            Logger.getLogger(GestorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

