package test;

import datos.Conexion;
import datos.PersonaDao;
import datos.GestorBaseDatos;
import domain.PersonaDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestManejoPersonas {

    public static void main(String[] args) {
        Connection conexion = null;//Se declara fuera para que podamos usarla fuera del bloque try catch
        try {
            conexion = Conexion.getConnection();//Hacemos la conexion en este caso desde el main
            //Revisamos si la conexion esta en modo Autocommit
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);//Si es verdadero lo ponemos en false
            }//De esta manera no se guardaran los cambios de manera inmediata, si no cuando hagamos el commit

            PersonaDao personaDao = new GestorBaseDatos(conexion);//Usamos el constructor de la conexion y se la enviamos, en el otro metodo de ejemplo es conexionTransaccional

            //Añadir persona
            PersonaDTO newPersona = new PersonaDTO();
            newPersona.setNombre("rocio");
            newPersona.setApellido("allueva");  
            newPersona.setEmail("roro@email.com");
            newPersona.setTelefono("333333333");
            personaDao.insertar(newPersona);
            
            //Update persona
            PersonaDTO updatePersona = new PersonaDTO();//Esto tb se podria hacer creando un nuevo item sin el consctructor vacio y pasando los datos por ahi
            updatePersona.setIdPersona(4);//Para modificar el registro 2
            updatePersona.setNombre("Karla Ivonne");
            updatePersona.setApellido("Gomez");
            updatePersona.setEmail("kgomez@email.com");
            updatePersona.setTelefono("552688112");
            personaDao.actualizar(updatePersona);
            
            //Eliminar persona (usamos el constructor del id)            
            PersonaDTO eliminarPersona = new PersonaDTO(8);
            personaDao.eliminar(eliminarPersona);
            
            //Probamos el select
            List<PersonaDTO> personas = personaDao.seleccionar();//Podemos poner el metodo de la interface y no a donde lo hemos implementado
            for (PersonaDTO persona : personas) {
                System.out.println("Persona DTO: " + persona);
            }                        
            
            conexion.commit();//Aqui se guardan los cambios
            System.out.println("Se ha hecho commit de la transacion");
        } catch (SQLException ex) {//Hay que quitar el bloque catch de cada metodo del DAO para que entre en este y los ponemos como SQLException para que la reporte pero no la procese de manera interna, de esta manera esta clase se enterara de que ha ocurrido una excepcion
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rolback");//En caso de error, por ejemplo un campo muy largo
            try {
                conexion.rollback();//Volvemos a como estaba antes si ha dado error
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
