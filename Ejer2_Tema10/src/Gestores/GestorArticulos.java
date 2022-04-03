package Gestores;

import domain.articulos;
import java.util.LinkedList;

public class GestorArticulos {
    public static LinkedList<articulos> listaArticulos = new LinkedList<articulos>();
    
    public static boolean añadirArticulo(articulos articulo) {
        try {
            listaArticulos.add(articulo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
