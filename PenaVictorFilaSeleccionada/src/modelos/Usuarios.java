package modelos;

import excepciones.Excepciones;
import java.util.Objects;

public class Usuarios {

    private String nick;
    private String password;
    private String email;
    private String telefono;
    private boolean enviar;
    private String stringEnviar;

    public Usuarios(String nick, String password, String email, String telefono, boolean enviar) throws Excepciones {
        setNick(nick);
        setPassword(password);
        setEmail(email);
        setTelefono(telefono);
        this.enviar = enviar;
        setStringEnviar();        
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean isEnviar() {
        return enviar;
    }
    
    public String getCifrada(){
        String cifrada = "";
        for (int i = 0; i < password.length(); i++) {
            cifrada += "*";
        }
        return cifrada;
    }
    
    public void setPassword(String password) throws Excepciones {
        if (password.length() < 3) {
            throw new Excepciones("Longitud mínima de 3 carácteres");
        }
        if (password.length() > 8) {
            throw new Excepciones("Longitud máxima de 8 carácteres");
        }
        this.password = password;
    }

    public void setNick(String nick) throws Excepciones {
        if (nick.length() < 3) {
            throw new Excepciones("Longitud mínima de 3 carácteres");
        }
        if (nick.length() > 8) {
            throw new Excepciones("Longitud máxima de 8 carácteres");
        }
        this.nick = nick;
    }

    public void setEmail(String email) throws Excepciones {
        if (!email.contains("@")) {
            throw new Excepciones("No contiene la arroba");
        }
        this.email = email;
    }

    public void setTelefono(String telefono) throws Excepciones {
        if (telefono.length() != 9) {
            throw new Excepciones("Telefono incorrecto");
        }
        this.telefono = telefono;
    }
    
    public void setStringEnviar() throws Excepciones{
        if(enviar){
            this.stringEnviar = "si";
        }else if(!enviar){
            this.stringEnviar = "no";
        }
    }        
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.nick);
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
        final Usuarios other = (Usuarios) obj;
        if (!Objects.equals(this.nick, other.nick)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nick + " " + password + " " + email + " " + telefono + " " + stringEnviar;
    }

}
