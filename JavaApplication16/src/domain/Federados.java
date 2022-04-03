package domain;

import gestores.GestorAtletas;

public class Federados extends Atleta{
    private int codFederado;
    private int numCompeticiones = 0;
    private static int contadorFederado;
    

    public Federados(String nick, String nombre, Marcas marcas, int numCompeticiones) {
        super(nick, nombre, marcas);
        this.numCompeticiones = numCompeticiones;
        codFederado = ++contadorFederado;
        noCompitio();
    }

    public int getCodFederado() {
        return codFederado;
    }

    public void setCodFederado(int codFederado) {
        codFederado = codFederado;
    }

    public int getNumCompeticiones() {
        return numCompeticiones;
    }

    public void setNumCompeticiones(int numCompeticiones) {
        this.numCompeticiones = numCompeticiones;
    }

    public  int getContadorFederado() {
        return contadorFederado;
    }

    public static void setContadorFederado(int contadorFederado) {
        Federados.contadorFederado = contadorFederado;
    }

    public void competir(){
        numCompeticiones++;
    }
    
    public void noCompitio(){
        if(numCompeticiones==0){
            GestorAtletas.planificarViaje(this);
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + "\t codFederado = " + codFederado + "\t numCompeticiones = "  + numCompeticiones;
    }
}
