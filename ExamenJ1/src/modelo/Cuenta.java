/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import myException.MyException;

/**
 *
 * @author Alumno
 */
public class Cuenta implements Serializable {
    
    private String id_cc;
    private double saldo;

    public Cuenta(String id_cc, double saldo) {
        this.id_cc = id_cc;
        this.saldo = saldo;
    }

    public String getId_cc() {
        return id_cc;
    }

    public void setId_cc(String id_cc) throws MyException {
        if (id_cc == null) {
            throw new MyException("El ID_CC no puede ser nulo");
        }
        this.id_cc = id_cc;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) throws MyException {
        if (saldo < 0) {
            throw new MyException("El saldo no puede ser inferior que 0");
        }
        this.saldo = saldo;
    }
   public String [] toArrayCompleto() {
        String [] array = new String[2];
        array[0] = id_cc;
        array[1] = String.format("%,.2f", saldo);
        return array;
    } 
    
}
