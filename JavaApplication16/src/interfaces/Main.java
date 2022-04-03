package interfaces;

import domain.Atleta;
import domain.Federados;
import domain.Marcas;
import domain.NoFederado;
import excepciones.Excepciones;
import gestores.GestorAtletas;

public class Main {
    public static void main(String[] args) throws Excepciones {
        Atleta atleta1 = new Federados("Vitty", "Victor", new Marcas(5, 6, 7, 1, 0), 1);
        Atleta atleta2 = new Federados("Roro", "Rocio", new Marcas(1, 2, 4, 3, 0), 5);
        Atleta atleta3 = new Federados("Acopl", "Milag", new Marcas(0, 0, 0, 0, 0), 0);
        Atleta atleta4 = new Federados("Hero", "Hercul", new Marcas(9, 9, 9, 9, 9), 0);
        
        Atleta atleta5 = new NoFederado("Elpepe", "Pepe", new Marcas(0, 0, 0, 2, 6), 16);
        Atleta atleta6 = new NoFederado("Mayor", "Gier", new Marcas(1, 2, 3, 4, 6), 18);
        Atleta atleta7 = new NoFederado("Yolo", "Yoes", new Marcas(2, 4, 0, 2, 6), 25);
        Atleta atleta8 = new NoFederado("Viejo", "Papi", new Marcas(0, 7, 0, 1, 8), 80);
        int numero = 0;
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
                    //GestorAtletas.añadirMarca();
                    break;
                case 3:
                    System.out.println(GestorAtletas.listarAtletas());
                    break;
                case 4:
                    System.out.println(GestorAtletas.listarOrdenados());
                    break;
                case 5:
                    break;
            }

        } while (numero == 1 || numero == 2 || numero == 3 || numero == 4);
    }

    private static void altaAtleta() {                        
        int contador = 0;
        System.out.println("Proporciona el nick del atleta");
        String nick = Excepciones.stringExcepcionConsola();
        System.out.println("Proporciona el nombre del atleta");
        String nombre = Excepciones.stringExcepcionConsola();
        System.out.println("¿Cuantas marcas quieres añadir?");
        int marcasAñadir = Excepciones.intExcepcionConsola();
        Marcas objetoMarcas = new Marcas(0, 0, 0, 0, 0);
        while(contador!=marcasAñadir){
            System.out.println("Proporciona la modalidad");
            String modalidad = Excepciones.stringExcepcionConsola();
            System.out.println("Proporciona la marca");
            int numeroMarca = Excepciones.intExcepcionConsola();
            if(modalidad.equals("fondo")){
                objetoMarcas.setFondo(numeroMarca);
            }else if(modalidad.equalsIgnoreCase("vallas")){
                objetoMarcas.setVallas(numeroMarca);
            }else if(modalidad.equalsIgnoreCase("relevos")){
                objetoMarcas.setRelevos(numeroMarca);
            }else if(modalidad.equalsIgnoreCase("velocidad")){
                objetoMarcas.setVelocidad(numeroMarca);
            }else if(modalidad.equalsIgnoreCase("marcha")){
                objetoMarcas.setMarcha(numeroMarca);
            }
            contador++;
        }                
        Atleta objeto = new Federados(nick, nombre, objetoMarcas, contador);
    }
}
