
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class main {
private static int numDir;
    public static void main(String[] args) {
        try {
            //PARA SABER CUANTOS DIRECTORIOS HAY EN UNA RUTA
            numDir = 0;
            walkin(new File("C:\\Users\\Vitty\\Documents\\My Games")); // Directorio raíz, modificar para pruebas..
            System.out.println("\nSe han encontrado: " + numDir + " directorios");
            File salida = new File(".\\salida.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(salida));
            bw.write("Se han encontrado: " + numDir + " directorios \n");
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void walkin(File dir) {

        File listFile[] = dir.listFiles();
        if (listFile != null && listFile.length > 0) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory())
                    walkin(listFile[i]);
            }
        } else {
            numDir++;
            System.out.print(numDir + ", "); // Por Debug, pare ver los directorios que va encontrando.
        }
    }
}
