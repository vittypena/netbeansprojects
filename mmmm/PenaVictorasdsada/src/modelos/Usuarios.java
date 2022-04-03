package modelos;

import excepciones.Excepciones;
import java.util.Objects;

public class Usuarios {

    private String nick;
    private String password;
    private String email;
    private String telefono;
    private boolean enviar;
    private boolean comprobarExcepcion;

    public Usuarios(String nick, String password, String email, String telefono, boolean enviar) throws Excepciones {
        setNick(nick);
        setPassword(password);
        setEmail(email);
        setTelefono(telefono);
        this.enviar = enviar;
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

    public boolean isComprobarExcepcion() {
        return comprobarExcepcion;
    }

    public boolean isEnviar() {
        return enviar;
    }

    public void setPassword(String password) throws Excepciones {
        if (password.length() < 3) {
            comprobarExcepcion = true;
            throw new Excepciones("Longitud mínima de 3 carácteres");
        }
        if (password.length() > 8) {
            comprobarExcepcion = true;
            throw new Excepciones("Longitud máxima de 8 carácteres");
        }
        this.password = password;
    }

    public void setNick(String nick) throws Excepciones {
        if (nick.length() < 3) {
            comprobarExcepcion = true;
            throw new Excepciones("Longitud mínima de 3 carácteres");
        }
        if (nick.length() > 8) {
            comprobarExcepcion = true;
            throw new Excepciones("Longitud máxima de 8 carácteres");
        }
        this.nick = nick;
    }

    public void setEmail(String email) throws Excepciones {
        if (!email.contains("@")) {
            comprobarExcepcion = true;
            throw new Excepciones("No contiene la arroba");
        }
        this.email = email;
    }

    public void setTelefono(String telefono) throws Excepciones {
        if (telefono.length() != 9) {
            comprobarExcepcion = true;
            throw new Excepciones("Telefono incorrecto");
        }
        this.telefono = telefono;
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
        return "Usuarios{" + "nick=" + nick + ", password=" + password + ", email=" + email + ", telefono=" + telefono + ", enviar=" + enviar + '}';
    }

}
