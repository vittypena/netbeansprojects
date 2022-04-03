package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Excepciones extends Exception {

    public Excepciones(String mensaje) {
        super(mensaje);
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static int intExcepcionConsola(int consola) {
        Scanner teclado = new Scanner(System.in);
        try {
            consola = teclado.nextInt();
        } catch (InputMismatchException ex) {
            return -1;
        }
        return consola;
    }

    public static String stringExcepcionConsola(String consola) {
        Scanner teclado = new Scanner(System.in);
        try {
            consola = teclado.nextLine();
        } catch (InputMismatchException ex) {
            return "";
        }
        return consola;
    }
}
