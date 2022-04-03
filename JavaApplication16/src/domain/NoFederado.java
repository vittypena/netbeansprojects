package domain;

import gestores.GestorAtletas;

public class NoFederado extends Atleta{
    private int edad;

    public NoFederado(String nick, String nombre, Marcas marcas, int edad) {
        super(nick, nombre, marcas);
        this.edad = edad;
        esMenor();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void esMenor(){
        if(edad<18){
            GestorAtletas.planificarViaje(this);
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + "\t edad = " + edad;
    }
    
}
