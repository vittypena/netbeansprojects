package Gestores;

import Datos.Conexion;
import Datos.GestorBaseDatos;
import Excepciones.Excepciones;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import modelos.Usuarios;

public class GestorArchivos {
    private static int sizeArray = 30;
    public static String[] leerFicheroDataInputStream(File fichero) throws Excepciones{
        try {
            DataInputStream entrada = new DataInputStream(new FileInputStream(fichero));            
            while(true){                
//                String[] idioma = {entrada.readUTF(),entrada.readUTF(),entrada.readUTF(), entrada.readUTF(), entrada.readUTF(), entrada.readUTF(), entrada.readUTF(), entrada.readUTF(), entrada.readUTF(), entrada.readUTF(), entrada.readUTF(), entrada.readUTF(),
//             entrada.readUTF(), entrada.readUTF(), entrada.readUTF(),entrada.readUTF(),entrada.readUTF(),entrada.readUTF(),entrada.readUTF(),entrada.readUTF(),entrada.readUTF(),entrada.readUTF(),entrada.readUTF(),entrada.readUTF(),entrada.readUTF(),entrada.readUTF(),entrada.readUTF(),entrada.readUTF(),entrada.readUTF(),entrada.readUTF()};
                String[] idioma = new String[sizeArray];
                for (int i = 0; i < sizeArray; i++) {
                    idioma[i] = entrada.readUTF();
                }
                return idioma;                           
            }
        } catch (FileNotFoundException ex) {
            throw new Excepciones("El fichero no existe");
        } catch (IOException ex) {
            throw new Excepciones("Error al leer el archivo");
        }
    }
    
    
    public static void escribirFichero(String primeraCadena, String segundaCadena){        
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream("src\\ficheros\\espanol.dat", true));){
            //Escribimos una cadena
            dos.writeUTF(primeraCadena);
            dos.writeUTF(segundaCadena);               
        }catch(IOException e){
            System.out.println("Error E/S");
        }     
    }
    
//    public static void crearFicheroObjectOutputStream() throws Excepciones{ //Hay que hacer el modelo Serializable
//            FileOutputStream fichero = null;
//        try {
//            fichero = new FileOutputStream("src\\ficheros\\hacienda.obj");        
//            ObjectOutputStream entrada;        
//            entrada = new ObjectOutputStream(fichero);        
//            for (CuentasDTO cuentasDTO : gestores.GestorCuentas.hacienda) {
//                entrada.writeObject(cuentasDTO);
//            }
//        }catch(FileNotFoundException ex){
//            throw new Excepciones("Fichero no encontrado");
//        }catch(IOException ex){
//            throw new Excepciones("Error");
//        }finally{
//            try{
//                fichero.close();
//            }catch(IOException ex){
//                
//            }
//        }
//    }
    
//    public static void leerInfoArchivo(File archivo) throws Excepciones {     //Lee la informacion de un archivo y va creando usuarios segun va leyendo la informacion por lineas   
//        int contador = 0;
//        try {
//            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
//            String lectura;
//            while ((lectura = entrada.readLine()) != null) {
//                String nombre = "";
//                String password = "";
//                String email = "";
//                String telefono = "";
//                boolean informacion = false;
//                String[] strArr = lectura.split("\\ ");
//                for (String str : strArr) {
//                    if (contador == 0) {
//                        nombre = str;
//                    } else if (contador == 1) {
//                        password = str;
//                    } else if (contador == 2) {
//                        email = str;
//                    } else if (contador == 3) {
//                        telefono = str;
//                    } else if (contador == 4) {
//                        if (str.equals("si")) {
//                            informacion = true;
//                        } else if (str.equals("no")) {
//                            informacion = false;
//                        }
//                    }
//                    contador++;
//                }
//                contador = 0;
//                //gestores.GestorUsuarios.añadirUsuario(new Usuarios(nombre, password, email, telefono, informacion));
//            }
//            entrada.close();
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace(System.out);
//        } catch (IOException ex) {
//            ex.printStackTrace(System.out);
//        }
//    }
    
//    public static void modificarDatoLinea(String filaAntigua, String filaNueva) {//Debe recibir la linea antigua a modificar y la linea nueva para sustituirla y cambiar asi el dato
//        String lineToRemove = filaAntigua;
//
//        File inputFile = new File("src\\archivos\\usuarios.txt");//El archivo destino
//        File outputFile = new File("src\\archivos\\usuarios_nuevo.txt");//Un archivo en la misma ruta
//
//        try {
//            BufferedReader entrada = new BufferedReader(new FileReader(inputFile));
//            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
//
//            String currentLine;
//
//            while ((currentLine = entrada.readLine()) != null) {
//                if (currentLine.trim().equals(lineToRemove)) {
//                    writer.write(filaNueva + System.getProperty("line.separator"));
//                    continue;
//                }
//                writer.write(currentLine + System.getProperty("line.separator"));
//            }
//
//            writer.close();
//            entrada.close();
//            inputFile.delete();
//            outputFile.renameTo(inputFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    
//    public static void añadirLinea(String fila) {//Debe recibir la linea a añ±adir debajo
//        File archivo = new File("src/archivos/usuarios.txt");//El archivo destino
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));
//            writer.write(fila + System.getProperty("line.separator"));
//            writer.close();
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace(System.out);
//        } catch (IOException ex) {
//            ex.printStackTrace(System.out);
//        }
//    }
    
//    public static void volcarColeccionFileWriter(LinkedList<articulos> coleccion) throws Excepciones {//Recibira una coleccion y la volcara en el fichero
//        File ruta = new File("src/archivos/usuarios.txt");//El archivo destino
//        FileWriter fileWriter;
//        try {
//            fileWriter = new FileWriter(ruta);
//            BufferedWriter escritura = new BufferedWriter(fileWriter);
//            for (articulos listaArticulos : coleccion) {
//                escritura.write(listaArticulos.toString());
//                escritura.newLine();
//            }
//            escritura.close();
//        } catch (IOException ex) {
//            throw new Excepciones("Error al volcar la colección en el fichero" + ruta.getAbsolutePath());
//        }
//    }

//    public static void volcarModeloFileWriter(articulos modelo) throws Excepciones {//Recibira un modelo y lo añadira en el fichero
//        File ruta = new File("src/ficheros/borrados.txt");//El archivo destino
//        FileWriter fileWriter;
//        try {
//            fileWriter = new FileWriter(ruta, true);
//            BufferedWriter escritura = new BufferedWriter(fileWriter);
//            escritura.write(modelo.toString() + System.getProperty("line.separator"));
//            escritura.close();
//        } catch (IOException ex) {
//            throw new Excepciones("Error al volcar el modelo en el fichero" + ruta.getAbsolutePath());
//        }
//    }

//    public static void FileOutputStream() {//Escribe en un fichero con bytes
//        try (FileOutputStream archivo = new FileOutputStream("D:\\fichero_bin.ddr")) {//
//
//            String texto = "Esto es una prueba para ficheros binariosssss";
//
//            //Copiamos el texto en un array de bytes
//            byte codigos[] = texto.getBytes();
//
//            archivo.write(codigos);
//
//        } catch (IOException e) {
//
//        }
//    }
    
//    public static void FileInputStream() {//Leemos en un fichero con bytes
//        try (FileInputStream fis = new FileInputStream("D:\\ejemplo_fich.png")) {//Lee una imagen en bytes
//
//            int valor = fis.read();
//            while (valor != -1) {
//                System.out.print((char) valor);
//                valor = fis.read();
//            }
//        } catch (IOException ex) {
//
//        }
//    }
    
    //COPIAR ARCHIVO EN OTRO CON BYTES----------------------------------------------------------------------------------------------------------------------------
//    public static int obtenerBytesFichero(String ruta) {//Obtiene la cantidad necesaria del array de datos de entrada, se usa el primero y se indica la ruta destino
//        int contador = 0;
//        try {
//            FileInputStream archivoLectura = new FileInputStream(ruta);//Instancia que leera el archivo
//            boolean finalArchivo = false;
//            while (!finalArchivo) {//Para ir leyendo byte a byte este archivo
//                int byteEntrada = archivoLectura.read();//LEE BYTE A BYTE EL ARCHIVO QUE LE HEMOS INDICADO
//                
//                if(byteEntrada != -1){{
//                    //datosEntrada[contador]=byteEntrada;//Asi almacenamos en cada posicion el byte
//                }
//                    
//                }else{
//                    finalArchivo=true;//Le indicamos que hemos llegado al final del archivo
//                } 
//                contador++;//De esta manera sabemos el tamanio de bytes de la imagen o fichero                              
//            }
//            archivoLectura.close();
//        } catch (IOException ex) {
//               System.out.println("No se encuentra la imagen");
//        }
//        return contador;
//    }
    
//    public static int[] obtenerArrayDatosEntradaBytes(int tamanioArray,String ruta) {//Obtiene los datos en bytes, se usa el segundo y se indica el tamanioArray obtenido previamente y la ruta destino
//        int contador = 0;
//        //Creamos el array que contendra los datos de entrada
//        int datosEntrada[] = new int[tamanioArray];
//        try {
//            FileInputStream archivoLectura = new FileInputStream(ruta);//Instancia que leera el archivo
//            boolean finalArchivo = false;
//            while (!finalArchivo) {//Para ir leyendo byte a byte este archivo
//                int byteEntrada = archivoLectura.read();//LEE BYTE A BYTE EL ARCHIVO QUE LE HEMOS INDICADO
//
//                if (byteEntrada != -1) {
//                    {
//                        datosEntrada[contador] = byteEntrada;//Asi almacenamos en cada posicion el byte
//                    }
//
//                } else {
//                    finalArchivo = true;//Le indicamos que hemos llegado al final del archivo
//                }
//                contador++;//De esta manera sabemos el tamanio de bytes de la imagen o fichero                
//            }
//            //DEBEMOS SABER CON UN CONTADOR CUANTOS BYTES TIENE, para ello lo ponemos en el while
//            archivoLectura.close();
//        } catch (IOException ex) {
//            ex.printStackTrace(System.out);
//        }
//        return datosEntrada;
//    }
    
//    public static void copiarArchivoBytes(int[] datosBytes, String rutaDestino) {//Recibe los datos en forma de bytes y los copia en la ruta destino, se usa el tercero
//        try{
//            FileOutputStream ficheroNuevo = new FileOutputStream(rutaDestino);
//            for(int i = 0; i < datosBytes.length; i++){//Tiene que ir escribiendo en el fichero
//                ficheroNuevo.write(datosBytes[i]);//Almacenamos lo que tiene en cada posición del array
//            }
//            ficheroNuevo.close();
//        }catch(IOException ex){
//            ex.printStackTrace(System.out);
//        }
//    }
    //FIN DE COPIAR ARCHIVO EN OTRO CON BYTES----------------------------------------------------------------------------------------------------------------------------
    
//    public static void escribirLog(String textoMensaje) throws Excepciones {
//        String nombreArchivo = "src\\ficheros\\log.txt";
//        BufferedWriter bw = null;
//        FileWriter fw = null;
//        try {
//            fw = new FileWriter(nombreArchivo, true);
//            bw = new BufferedWriter(fw);
//            bw.write(textoMensaje);
//        } catch (IOException e) {
//            throw new Excepciones("No se ha escrito con exito el fichero log");
////            e.printStackTrace();
//        } finally {
//            try {
//                if (bw != null) {
//                    bw.close();
//                }
//                if (fw != null) {
//                    fw.close();
//                }
//            } catch (IOException ex) {
//                throw new Excepciones("No se ha cerrado la escritura del fichero log con exito");
//            }
//        }
//    }
    
//    private static ArrayList<String> lista = new ArrayList<String>();        
//    public static void obtenerNombreFicherosRuta(File carpeta){
//	File[] contenido = carpeta.listFiles();
//	for(File file : contenido){
//		if(file.isDirectory()){
//                    obtenerNombreFicherosRuta(file);
//		}else{
//                    lista.add(file.getName());
//		}
//	}
//    }

//    public static ArrayList<String> getLista() {
//        return lista;
//    }
    
}
