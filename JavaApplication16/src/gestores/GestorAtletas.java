package gestores;

import domain.Atleta;
import java.util.HashSet;
import java.util.TreeSet;

public class GestorAtletas {
    private static HashSet<Atleta> listaAtletas = new HashSet<Atleta>();  
    private static TreeSet <Atleta> lista = new TreeSet<Atleta>();
    public static void añadirAtleta(Atleta atleta){
        listaAtletas.add(atleta);
    }
    
    public static void planificarViaje(Atleta atleta){
        lista.add(atleta);
    }
    
    public static String listarAtletas(){        
        String cadena = "";
        for (Atleta listaAtleta : listaAtletas) {
            cadena += listaAtleta.toString() + "\n";
        }
        return cadena;
    }
    
    public static String listarOrdenados(){
        String cadena = "";
        for (Atleta atleta : lista) {
            cadena += atleta.getNick() + "\t" +  atleta.getNombre() + "\n";
        }
        return cadena;
    }
    
    
}
