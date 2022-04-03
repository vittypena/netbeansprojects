package datos;

import domain.PersonaDTO;
import java.sql.SQLException;
import java.util.List;

public interface PersonaDao {

    //DTO = DATA TRANSFER OBJECT 
    public List<PersonaDTO> seleccionar() throws SQLException;
    
    public void crearBaseDatosNueva(String bd) throws SQLException;
    
    public void crearTablaNueva() throws SQLException;

    public int insertar(PersonaDTO persona) throws SQLException;

    public int actualizar(PersonaDTO persona) throws SQLException;

    public int eliminar(PersonaDTO persona) throws SQLException;
}
