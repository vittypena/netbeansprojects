package domain;

import gestores.GestorCuentas;
import java.io.Serializable;
import java.util.ArrayList;

public class CuentasDTO implements Serializable {

    private String id_cc;
    private Double saldo;

    public CuentasDTO() {
    }

    public CuentasDTO(String id_cc) {//Para eliminar un objeto de tipo cuenta solo necesitamos el id
        this.id_cc = id_cc;
    }

    public CuentasDTO(String id_cc, Double saldo) {//No necesitamos la llave primaria para insertar ya que es incremental en la BD
        this.id_cc = id_cc;
        this.saldo = saldo;
//        toArray();
    }

    public String getId_cc() {
        return id_cc;
    }

    public void setId_cc(String id_cc) {
        this.id_cc = id_cc;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Double aumentarSaldo(Double saldo) {
        this.saldo += saldo;
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return id_cc + " " + saldo + "/n";
    }

    public String[] toArray() {
        String[] array = new String[2];
        array[0] = id_cc;
        array[1] = String.format("%,.2f", saldo);
	return array;
    }

}
