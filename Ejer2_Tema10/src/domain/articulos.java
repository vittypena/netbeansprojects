package domain;

import Excepciones.Excepciones;

public class articulos {

    private String cod_art;
    private String descripcion;
    private Float precio;
    private int stock;

    public articulos(String cod_art) throws Excepciones{
        setCod_art(cod_art);
    }
    
    public articulos(String cod_art, String descripcion, Float precio, int stock) throws Excepciones {
        setCod_art(cod_art);
        this.descripcion = descripcion;
        setPrecio(precio);
        setStock(stock);
    }

    public String getCod_art() {
        return cod_art;
    }

    public void setCod_art(String cod_art) throws Excepciones{
        if (cod_art.length() < 3) {
            throw new Excepciones("Longitud mínima de 3 carácteres");
        }
        if(!Character.isDigit(cod_art.charAt(0))){
            throw new Excepciones("El primer caracter ha de ser una letra");
        }
        if(!Character.isDigit(cod_art.charAt(1))){
            throw new Excepciones("El segundo caracter ha de ser una letra");
        }
        if(!Character.isDigit(cod_art.charAt(2))){
            throw new Excepciones("El tercer caracter ha de ser una letra");
        }
        this.cod_art = cod_art;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {        
        return precio;
    }

    public void setPrecio(Float precio) throws Excepciones{
        if(precio <= 0){
            throw new Excepciones("El precio ha de ser mayor que cero");
        }
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) throws Excepciones{
        if(stock <0){
            throw new Excepciones("No puede no haber stock");
        }
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "articulos{" + "cod_art=" + cod_art + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + '}';
    }

    public String[] toArray() {
        //        array[1] = String.format("%,.2f", saldo); //Esto es a dos decimales con separador de miles
        String[] array = new String[4];
        array[0] = cod_art;
        array[1] = descripcion;
        array[2] = String.format("%,.2f", precio);
        array[3] = String.valueOf(stock);
        return array;
    }

}
