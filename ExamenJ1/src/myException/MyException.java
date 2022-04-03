/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myException;

import gestor.GestorFichero;

/**
 *
 * @author Lucas
 */
public class MyException extends Exception {

    public MyException(String string) {
        super(string);
    }
    
    public MyException(String error, String codigo) throws MyException {
        //este constructor será solo para las excepciones que tengo que guardar
        super(error);
        guardoExceptionFichero("SQL---CLASE---: " + error + "\t" + codigo);
    }
    
    private void guardoExceptionFichero(String mensaje) throws MyException{
       try {
            //llamo al fichero
            //guardo el error
            gestor.GestorFichero gEx = new GestorFichero("log.txt");
            gEx.escriboException(mensaje);
        } catch (MyException ex) {
           //la excepcion capturada no ha sido registrada
           throw new MyException("Los errores de la base de datos no están siendo registrados");
        }  
    }
    
}

