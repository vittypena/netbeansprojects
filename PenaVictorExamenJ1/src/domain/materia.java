package domain;

import Excepciones.Excepciones;

public class materia {
    private String simbolo;
    private String nombre;
    private Double p_venta;
    private Double p_compra;

    public materia(String simbolo, String nombre, Double p_venta, Double p_compra) throws Excepciones {
        setSimbolo(simbolo);
        setNombre(nombre);
        setP_venta(p_venta);
        setP_compra(p_compra);
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) throws Excepciones{
        if(simbolo.equals("")){
            throw new Excepciones("El campo simbolo no puede ser nulo");
        }
        this.simbolo = simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Excepciones{
        if(nombre.equals("")){
            throw new Excepciones("El campo nombre no puede ser nulo");
        }
        this.nombre = nombre;
    }

    public Double getP_venta() {
        return p_venta;
    }

    public void setP_venta(Double p_venta) throws Excepciones{
        if(p_venta<=0){
            throw new Excepciones("El precio de venta no puede ser negativo o cero, ha de ser positivo");
        }
        this.p_venta = p_venta;
    }

    public Double getP_compra() {
        return p_compra;
    }

    public void setP_compra(Double p_compra) throws Excepciones{
        if(p_compra<=0){
            throw new Excepciones("El precio de compra no puede ser negativo o cero, ha de ser positivo");
        }
        this.p_compra = p_compra;
    }

    @Override
    public String toString() {
        return "materia{" + "simbolo=" + simbolo + ", nombre=" + nombre + ", p_venta=" + p_venta + ", p_compra=" + p_compra + '}';
    }
    
    public String[] toArray() {
        String[] array = new String[4];
        array[0] = simbolo;
        array[1] = nombre;        
        array[2] = String.format("%,.2f", p_venta);
        array[3] = String.format("%,.2f", p_compra);
        return array;
    }
}
