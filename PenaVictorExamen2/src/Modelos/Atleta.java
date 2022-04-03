package Modelos;

import Excepciones.Excepciones;
import java.util.HashMap;
import java.util.Objects;
public class Atleta{

    private String nick;
    private String nombre;
    private String modalidad;
    private String tiempo;
    private HashMap<String, String> marcas = new HashMap<String, String>();

    public Atleta(String nick, String nombre) throws Excepciones {
        iniciarMarcas();
        this.nick = nick;
        this.modalidad = modalidad;
        this.tiempo = tiempo;        
        setNombre(nombre);
    }

    public void iniciarMarcas() {
        marcas.put("Fondo", "-");
        marcas.put("Vallas", "-");
        marcas.put("Relevos", "-");
        marcas.put("Velocidad", "-");
        marcas.put("Marcha", "-");
    }        
    
    public void setNombre(String nombre) throws Excepciones {
        if (nombre.length() > 30) {
            throw new Excepciones("La longitud del nombre es de máximo 20 caracteres");
        }
        this.nombre = nombre;
    }

    public void setMarcas(HashMap<String, String> marcas) {
        marcas.put(modalidad,tiempo); 
        this.marcas = marcas;
    }

    public void setModalidad(String modalidad) {         
        this.modalidad = modalidad;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
        setMarcas(marcas);
    }
    
    public HashMap<String, String> getMarcas() {
        return marcas;
    }

    public String getNick() {
        return nick;
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.nick);
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

}
