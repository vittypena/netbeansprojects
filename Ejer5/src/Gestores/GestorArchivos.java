package Gestores;

import Excepciones.Excepciones;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
//import modelos.Usuarios;

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
                //gestores.GestorUsuarios.añadirUsuario(new Usuarios(nombre, password, email, telefono, informacion));
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

    public static void añadirLinea(String fila) {//Debe recibir la linea a añ±adir debajo
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

    /*
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
     */
    public static void FileOutputStream() {//Escribe en un fichero con bytes
        try (FileOutputStream archivo = new FileOutputStream("D:\\fichero_bin.ddr")) {//

            String texto = "Esto es una prueba para ficheros binariosssss";

            //Copiamos el texto en un array de bytes
            byte codigos[] = texto.getBytes();

            archivo.write(codigos);

        } catch (IOException e) {

        }
    }

    public static void FileInputStream() {//Leemos en un fichero con bytes
        try (FileInputStream fis = new FileInputStream("D:\\ejemplo_fich.png")) {//Lee una imagen en bytes

            int valor = fis.read();
            while (valor != -1) {
                System.out.print((char) valor);
                valor = fis.read();
            }
        } catch (IOException ex) {

        }
    }

    //COPIAR ARCHIVO EN OTRO CON BYTES----------------------------------------------------------------------------------------------------------------------------
    public static int obtenerBytesFichero(String ruta) {//Obtiene la cantidad necesaria del array de datos de entrada, se usa el primero y se indica la ruta destino
        int contador = 0;
        try {
            FileInputStream archivoLectura = new FileInputStream(ruta);//Instancia que leera el archivo
            boolean finalArchivo = false;
            while (!finalArchivo) {//Para ir leyendo byte a byte este archivo
                int byteEntrada = archivoLectura.read();//LEE BYTE A BYTE EL ARCHIVO QUE LE HEMOS INDICADO
                
                if(byteEntrada != -1){{
                    //datosEntrada[contador]=byteEntrada;//Asi almacenamos en cada posicion el byte
                }
                    
                }else{
                    finalArchivo=true;//Le indicamos que hemos llegado al final del archivo
                } 
                contador++;//De esta manera sabemos el tamanio de bytes de la imagen o fichero                              
            }
            archivoLectura.close();
        } catch (IOException ex) {
               System.out.println("No se encuentra la imagen");
        }
        return contador;
    }

    public static int[] obtenerArrayDatosEntradaBytes(int tamanioArray,String ruta) {//Obtiene los datos en bytes, se usa el segundo y se indica el tamanioArray obtenido previamente y la ruta destino
        int contador = 0;
        //Creamos el array que contendra los datos de entrada
        int datosEntrada[] = new int[tamanioArray];
        try {
            FileInputStream archivoLectura = new FileInputStream(ruta);//Instancia que leera el archivo
            boolean finalArchivo = false;
            while (!finalArchivo) {//Para ir leyendo byte a byte este archivo
                int byteEntrada = archivoLectura.read();//LEE BYTE A BYTE EL ARCHIVO QUE LE HEMOS INDICADO

                if (byteEntrada != -1) {
                    {
                        datosEntrada[contador] = byteEntrada;//Asi almacenamos en cada posicion el byte
                    }

                } else {
                    finalArchivo = true;//Le indicamos que hemos llegado al final del archivo
                }
                contador++;//De esta manera sabemos el tamanio de bytes de la imagen o fichero                
            }
            //DEBEMOS SABER CON UN CONTADOR CUANTOS BYTES TIENE, para ello lo ponemos en el while
            archivoLectura.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return datosEntrada;
    }

    public static void copiarArchivoBytes(int[] datosBytes, String rutaDestino) {//Recibe los datos en forma de bytes y los copia en la ruta destino, se usa el tercero
        try{
            FileOutputStream ficheroNuevo = new FileOutputStream(rutaDestino);
            for(int i = 0; i < datosBytes.length; i++){//Tiene que ir escribiendo en el fichero
                ficheroNuevo.write(datosBytes[i]);//Almacenamos lo que tiene en cada posición del array
            }
            ficheroNuevo.close();
        }catch(IOException ex){
            ex.printStackTrace(System.out);
        }
    }
    //FIN DE COPIAR ARCHIVO EN OTRO CON BYTES----------------------------------------------------------------------------------------------------------------------------
}
