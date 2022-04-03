package Modelos;

import Excepciones.Excepciones;
import java.util.HashMap;

public class Federados extends Atleta {

    private int numCompeticiones = 0;
    private String codFederado;
    
    public Federados(String nick, String nombre, String codFederado) throws Excepciones {
        super(nick, nombre);  
        incrementar();
        this.numCompeticiones = numCompeticiones;
        setCodFederado(codFederado);
    }
    public void incrementar(){
        numCompeticiones++;
    }
    public void setCodFederado(String codFederado) throws Excepciones {
        if (codFederado.length() > 5) {
            throw new Excepciones("Solo se permite un máximo de 5 digitos");
        }
//        if (!Character.isDigit(codFederado.charAt(0))) {
//            throw new Excepciones("El primer digito ha de ser un numero");
//        }
//        if (!Character.isDigit(codFederado.charAt(1))) {
//            throw new Excepciones("El segundo digito ha de ser un numero");
//        }
//        if (!Character.isDigit(codFederado.charAt(2))) {
//            throw new Excepciones("El tercer digito ha de ser un numero");
//        }
//        if (!Character.isDigit(codFederado.charAt(3))) {
//            throw new Excepciones("El cuarto digito ha de ser un numero");
//        }
//        if (!Character.isDigit(codFederado.charAt(4))) {
//            throw new Excepciones("El quinto digito ha de ser un numero");
//        }
        this.codFederado = "AT-" + codFederado;
    }

    public int getNumCompeticiones() {
        return numCompeticiones;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" +  numCompeticiones + "\t" + codFederado;
    }

}
