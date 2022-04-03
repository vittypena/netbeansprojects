package domain;

public class Marcas{
    private int fondo;
    private int vallas;
    private int relevos;
    private int velocidad;
    private int marcha;

    public Marcas(int fondo, int vallas, int relevos, int velocidad, int marcha) {
        this.fondo = fondo;
        this.vallas = vallas;
        this.relevos = relevos;
        this.velocidad = velocidad;
        this.marcha = marcha;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }

    public int getVallas() {
        return vallas;
    }

    public void setVallas(int vallas) {
        this.vallas = vallas;
    }

    public int getRelevos() {
        return relevos;
    }

    public void setRelevos(int relevos) {
        this.relevos = relevos;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    @Override
    public String toString() {
        return "Marcas{" + "fondo=" + fondo + ", vallas=" + vallas + ", relevos=" + relevos + ", velocidad=" + velocidad + ", marcha=" + marcha + '}';
    }
    
    
}
