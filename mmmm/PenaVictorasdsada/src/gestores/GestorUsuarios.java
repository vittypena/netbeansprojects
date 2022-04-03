package gestores;

import excepciones.Excepciones;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import modelos.Usuarios;

public class GestorUsuarios {

    private static Set<Usuarios> listaUsuarios;

    public static void iniciarListaUsuarios() {
        listaUsuarios = new HashSet<Usuarios>();
    }

    public static boolean añadirUsuario(Usuarios usuario) {
        boolean comprobar = true;
        for (Usuarios listaUsuarios : listaUsuarios) {
            if (usuario.isComprobarExcepcion() || usuario.equals(listaUsuarios)) {
                return comprobar;
            }
        }
        listaUsuarios.add(usuario);
        return false;
    }

    public static boolean listarUsuarios(String nick, String password) {
        boolean comprobar = false;
        for (Usuarios listaUsuarios : listaUsuarios) {
            if (nick.equals(listaUsuarios.getNick()) && password.equals(listaUsuarios.getPassword())) {
                comprobar = true;
            }
        }
        return comprobar;
    }

    public static boolean olvidarPassword(String nick, String email, String telefono) throws Excepciones {
        boolean comprobar = false;
        String filaAntigua = "";
        String filaNueva = "";
        String informacion = "";
        for (Usuarios listaUsuarios : listaUsuarios) {
            if (nick.equals(listaUsuarios.getNick()) && email.equals(listaUsuarios.getEmail()) && telefono.equals(listaUsuarios.getTelefono())) {
                comprobar = true;
                if (listaUsuarios.isEnviar()) {
                    informacion = "si";
                } else {
                    informacion = "no";
                }
                filaAntigua = listaUsuarios.getNick() + " " + listaUsuarios.getPassword() + " " + listaUsuarios.getEmail() + " " + listaUsuarios.getTelefono() + " " + informacion;
                listaUsuarios.setPassword("password");
                filaNueva = listaUsuarios.getNick() + " " + listaUsuarios.getPassword() + " " + listaUsuarios.getEmail() + " " + listaUsuarios.getTelefono() + " " + informacion;
                modificarFichero(filaAntigua, filaNueva);
            }
        }
        return comprobar;
    }

    public static void modificarFichero(String filaAntigua, String filaNueva) {
        String lineToRemove = filaAntigua;

        File inputFile = new File("C:\\Users\\Vitty\\Documents\\NetBeansProjects\\PenaVictor\\src\\archivos\\usuarios.txt");
        File outputFile = new File("C:\\Users\\Vitty\\Documents\\NetBeansProjects\\PenaVictor\\src\\archivos\\usuarios_nuevo.txt");

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

    public static Set<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

}
