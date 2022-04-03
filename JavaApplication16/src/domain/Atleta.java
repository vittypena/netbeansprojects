package domain;

import gestores.GestorAtletas;
import java.util.Objects;

public class Atleta implements Comparable<Object>{
    private String nick;
    private String nombre;
    private Marcas marcas;

    public Atleta(String nick, String nombre, Marcas marcas) {
        this.nick = nick;
        this.nombre = nombre;
        this.marcas = marcas;
        addAtletaAuto();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nick);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atleta other = (Atleta) obj;
        if (!Objects.equals(this.nick, other.nick)) {
            return false;
        }
        return true;
    }

        
    
    @Override
    public String toString() {
        return nick + "\t" + nombre + "\t" + marcas;
    }

    private void addAtletaAuto() {
        GestorAtletas.añadirAtleta(this);
    }   

    @Override
    public int compareTo(Object o) {
        Atleta a = (Atleta) o;
        return this.nick.compareTo(a.nick);
    }

}
