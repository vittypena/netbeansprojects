package main;

import Gestores.GestorArchivos;
import java.io.*;

public class main {
    public static void main(String[] args) {
        int tamanioArray = GestorArchivos.obtenerBytesFichero("src\\main\\ducki.PNG");
        System.out.println(tamanioArray);
        int datosEntrada[] = GestorArchivos.obtenerArrayDatosEntradaBytes(tamanioArray, "src\\main\\ducki.PNG");
        GestorArchivos.copiarArchivoBytes(datosEntrada,"src\\main\\ducki_copia.PNG");
    }
    
    /*
    public static void main(String[] args) {
        int contador = 0;
        //Creamos el array que contendra los datos de entrada
        //int datosEntrada[] = new int[6173];
        try {
            FileInputStream archivoLectura = new FileInputStream("src\\main\\ducki.PNG");//Instancia que leera el archivo
            boolean finalArchivo = false;
            while (!finalArchivo) {//Para ir leyendo byte a byte este archivo
                int byteEntrada = archivoLectura.read();//LEE BYTE A BYTE EL ARCHIVO QUE LE HEMOS INDICADO
                
                if(byteEntrada != -1){{
                    //datosEntrada[contador]=byteEntrada;//Asi almacenamos en cada posicion el byte
                }
                    
                }else{
                    finalArchivo=true;//Le indicamos que hemos llegado al final del archivo
                } 
                //System.out.println(datosEntrada[contador]);
                contador++;//De esta manera sabemos el tamanio de bytes de la imagen o fichero
                System.out.println(contador);                
            }
            //DEBEMOS SABER CON UN CONTADOR CUANTOS BYTES TIENE, para ello lo ponemos en el while
            archivoLectura.close();
        } catch (IOException ex) {
               System.out.println("No se encuentra la imagen");
        }
        //creaFichero(datosEntrada);
    }*/
    /*
    static void creaFichero(int[] datosBytes){
        try{
            FileOutputStream ficheroNuevo = new FileOutputStream("src\\main\\ducki_copia.PNG");
            for(int i = 0; i < datosBytes.length; i++){//Tiene que ir escribiendo en el fichero
                ficheroNuevo.write(datosBytes[i]);//Almacenamos lo que tiene en cada posición del array
            }
            ficheroNuevo.close();
        }catch(IOException e){
            System.out.println("Error al crear el archivo");
        }
    }
    */
}
