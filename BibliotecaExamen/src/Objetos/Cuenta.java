/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.Serializable;

/**
 *
 * @author EDU
 */
public class Cuenta implements Serializable {

    String tutor;
    String sucursal;

    public Cuenta(String tutor, String sucursal) {
        this.tutor = tutor;
        this.sucursal = sucursal;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "tutor=" + tutor + ", sucursal=" + sucursal + '}';
    }

}
