package Modelos;

import Excepciones.Excepciones;
import java.util.HashMap;

public class NoFederado extends Atleta {

    private int edad;
    private boolean acompañado = false;
    public NoFederado(String nick, String nombre, int edad) throws Excepciones {
        super(nick, nombre);
        setEdad(edad);
    }

    public void setEdad(int edad) throws Excepciones {
        if (edad < 6 || edad > 100) {
            throw new Excepciones("La edad ha de estar comprendida entre los 6 años y los 100 años");
        }
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setAcompañado(boolean acompañado) {
        this.acompañado = acompañado;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\t" + edad;
    }

}
