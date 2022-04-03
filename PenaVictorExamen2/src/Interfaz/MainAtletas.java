package Interfaz;

import Excepciones.Excepciones;
import Gestores.GestorAtletas;
import Modelos.Atleta;
import Modelos.Federados;
import Modelos.NoFederado;
import java.time.temporal.TemporalAdjusters;
import java.util.Iterator;

public class MainAtletas {

    public static void crearAtletasIniciales() throws Excepciones {
        try {
            Atleta atleta1 = new Federados("Pepito", "Pepe", "11111");
            GestorAtletas.addAtleta(atleta1);
            atleta1.setModalidad("Fondo");
            atleta1.setTiempo("5.3");
            Atleta atleta2 = new Federados("Vitty", "Victor", "22222");
            GestorAtletas.addAtleta(atleta2);
            atleta2.setModalidad("Vallas");
            atleta2.setTiempo("1.76");
            Atleta atleta3 = new Federados("Pablito", "Pablo", "33333");
            GestorAtletas.addAtleta(atleta3);
            atleta3.setModalidad("Relevos");
            atleta3.setTiempo("3.2");
            Atleta atleta4 = new Federados("Mery", "Maria", "44444");
            GestorAtletas.addAtleta(atleta4);
            atleta4.setModalidad("Velocidad");
            atleta4.setTiempo("5.3");
            
            Atleta atleta5 = new NoFederado("Benjamino", "Benjamin", 7);
            GestorAtletas.addAtleta(atleta5);
            atleta5.setModalidad("Fondo");
            atleta5.setTiempo("0.4");
            Atleta atleta6 = new NoFederado("Pascualin", "Pascual", 10);
            GestorAtletas.addAtleta(atleta6);
            atleta6.setModalidad("Velocidad");
            atleta6.setTiempo("9.03");
            Atleta atleta7 = new NoFederado("Cris", "Cristina", 16);
            GestorAtletas.addAtleta(atleta7);
            atleta1.setModalidad("Fondo");
            atleta1.setTiempo("3.9");
            Atleta atleta8 = new NoFederado("Rox", "Rocio", 12);
            GestorAtletas.addAtleta(atleta8);
            atleta1.setModalidad("Velocidad");
            atleta1.setTiempo("5.7");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void altaAtleta() throws Excepciones {
        crearAtletasIniciales();
        String nick;
        String nombre;
        String modalidad;
        String tiempo;
        int contarMarcas;
        int contadorMarcas = 0;
        int numCompeticiones;
        String codFederado;
        try {
            System.out.println("Proporciona el nick del atleta");
            nick = Excepciones.stringExcepcionConsola();
            System.out.println("Proporciona el nombre del atleta");
            nombre = Excepciones.stringExcepcionConsola();
            System.out.println("Proporciona el codigo de la Federacion de atletismo");
            codFederado = Excepciones.stringExcepcionConsola();
            Atleta atleta = new Federados(nick, nombre, codFederado);
            GestorAtletas.addAtleta(atleta);
            System.out.println("Cuantas marcas quieres añadir");
            contarMarcas = Excepciones.intExcepcionConsola();
            while (contadorMarcas != contarMarcas) {
                System.out.println("Proporciona la modalidad del atleta");
                modalidad = Excepciones.stringExcepcionConsola();
                System.out.println("Proporciona el tiempo del atleta");
                tiempo = Excepciones.stringExcepcionConsola();
                atleta.setModalidad(modalidad);
                atleta.setTiempo(tiempo);
                contadorMarcas++;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Excepciones {
        int numero;
        do {
            System.out.println("1.- Alta de atleta(Federado)");
            System.out.println("2.- Añadir marca");
            System.out.println("3.- Listado de todos los atletas");
            System.out.println("4.- Planificar viaje");
            System.out.println("5.- Fin");
            numero = Excepciones.intExcepcionConsola();
            switch (numero) {
                case 1:
                    altaAtleta();
                    break;
                case 2:
                    GestorAtletas.añadirMarca();
                    break;
                case 3:
                    System.out.println(GestorAtletas.listarAtletas());
                    break;
                case 4:
                    System.out.println(GestorAtletas.planificarViaje());
                    break;
                case 5:
                    break;
            }

        } while (numero == 1 || numero == 2 || numero == 3 || numero == 4);
    }
}
