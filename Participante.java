
package plandetrabajo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*************************************************************
 * Clase para manejar los datos de un Participante.
 * @version 1.0
 * @since 06/06/18             
 * @author Eduardo Rosas Rivera.                             
*************************************************************/

public class Participante {
    private StringProperty nombre;
    private IntegerProperty idPlanTrabajo;
    
    /**
     * Constructor de la clase.
     * @param nombre nombre del participante.
     * @param idPlanTrabajo identificador del plan de trabajo.
     */
    public Participante(String nombre, Integer idPlanTrabajo) { 
	this.nombre = new SimpleStringProperty(nombre);
	this.idPlanTrabajo = new SimpleIntegerProperty(idPlanTrabajo);
    }
    /**
     * Constructor vacio.
     */
    public Participante() {
    }
    
    /**
     * Este metodo obtiene el nombre del participante.
     * @return el nombre del participante.
     */
    public String getNombre() {
	return nombre.get();
    }
    
    /**
     * Este metodo fija el nombre del participante.
     * @param nombre 
     */
    public void setNombre(String nombre) {
	this.nombre = new SimpleStringProperty(nombre);
    }
    
    /**
     * Este metodo obtiene el id del plan de trabajo.
     * @return 
     */
    public int getIdPlanTrabajo() {
	return idPlanTrabajo.get();
    }
    
    /**
     * Este metodo fija el id del plan de trabajo.
     * @param idPlanTrabajo id del plan de trabajo.
     */
    public void setIdPlanTrabajo(int idPlanTrabajo) {
	this.idPlanTrabajo = new SimpleIntegerProperty(idPlanTrabajo);
    }
    
    /**
     * Este metodo agrega a los participantes del plan de trabajo en la base de datos.
     * @param connection
     * @return 
     */
    public void agregar(Connection connection){
        try {
            PreparedStatement instruction = connection.prepareStatement(
                    "insert into academico_planTrabajo (idParticipante, nombre, idPlanTrabajo)"
                    + "values (null , ?, ?)");
            instruction.setString(1, nombre.get());
            instruction.setInt(2, idPlanTrabajo.get());
            instruction.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PlanTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
