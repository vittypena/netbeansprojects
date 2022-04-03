package Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Excepciones extends Exception{
    public Excepciones(String mensaje) {
        super(mensaje);
    }

    public static int intExcepcionConsola() {
        Scanner teclado = new Scanner(System.in);
        int consola;
        try {
            consola = teclado.nextInt();
        } catch (InputMismatchException ex) {
            return -1;
        }
        return consola;
    }

    public static String stringExcepcionConsola() {
        Scanner teclado = new Scanner(System.in);
        String consola;
        try {
            consola = teclado.nextLine();
        } catch (InputMismatchException ex) {
            return "";
        }
        return consola;
    }
}
