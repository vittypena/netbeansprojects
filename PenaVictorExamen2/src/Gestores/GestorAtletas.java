
package Gestores;

import Excepciones.Excepciones;
import Modelos.Atleta;
import Modelos.Federados;
import Modelos.NoFederado;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class GestorAtletas {
    private static HashSet<Atleta> listaAtletas = new HashSet<Atleta>();        

    public static void addAtleta(Atleta atleta) {
        listaAtletas.add(atleta);        
    }   
    public static String listarAtletas(){
        Iterator<Atleta>mi_iterador = listaAtletas.iterator();
        String cadenaInicial = "Nick " + "\tNombre" + "\tFondo" + "\tVallas" + "\tRelevos" + "\tVelocidad" + "\tMarcha" + "\tComp/Edad";
        String cadena ="";        
        while (mi_iterador.hasNext()) {
            Atleta next = mi_iterador.next();
            cadena += next.toString() + "\n";            
        }
        cadenaInicial += "\n" + cadena;
        return cadenaInicial;
    }
    public static void añadirMarca(){        
    }
    public static String planificarViaje(){
        String cadena = "";
        TreeSet<String> ordenaMenores = new TreeSet<String>();      
        for (Atleta listaAtleta : listaAtletas) {
            if(listaAtleta instanceof NoFederado){
                if(((NoFederado) listaAtleta).getEdad()<18){
                    ordenaMenores.add(listaAtleta.getNick() + "\t" + listaAtleta.getNombre());
                    ((NoFederado) listaAtleta).setAcompañado(true);
                }
            }else if(listaAtleta instanceof Federados){
                if(((Federados) listaAtleta).getNumCompeticiones()== 0){
                    ordenaMenores.add(listaAtleta.getNick() + "\t" + listaAtleta.getNombre());
                }
            }
            cadena+=listaAtleta.toString() + "\n";
        }        
        return cadena;
    }

    public static HashSet<Atleta> getListaAtletas() {
        return listaAtletas;
    }    

}
