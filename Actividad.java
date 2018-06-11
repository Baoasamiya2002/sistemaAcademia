
package plandetrabajo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*************************************************************
 * Clase para manejar los datos de una actividad.
 * @version 1.0
 * @since 06/06/18             
 * @author Eduardo Rosas Rivera.                             
*************************************************************/

public class Actividad {
    private StringProperty actividad_accion;
    private StringProperty fecha_semana;
    private StringProperty formaOperar;
    private IntegerProperty idActividad;
    private IntegerProperty idObjetivoParticular;
    
    /**
     * Contructor de la clase Actividad.
     * @param actividad_accion accion a realizar.
     * @param fecha_semana fecha en que se realizara la accion.
     * @param formaOperar forma en se operara.
     * @param idActividad identificador temporal para la actividad.
     * @param idObjetivoParticular identificador para el Objetivo particular al que pertenece.
     */
    public Actividad(String actividad_accion, String fecha_semana, String formaOperar, 
                    Integer idActividad, Integer idObjetivoParticular) {
        this.actividad_accion = new SimpleStringProperty(actividad_accion);
        this.fecha_semana = new SimpleStringProperty(fecha_semana);
        this.formaOperar = new SimpleStringProperty(formaOperar);
        this.idActividad = new SimpleIntegerProperty(idActividad);
        this.idObjetivoParticular = new SimpleIntegerProperty(idObjetivoParticular);
    }
    
    /**
     * Contructor vacio de la clase.
     */
    public Actividad() {
    }
    
    /**
     * Este metodo establece la actividad_accion a una actividad.
     * @param actividad_accion accion a realizar.
     */
    public void setActividad_accion(String actividad_accion) {
        this.actividad_accion = new SimpleStringProperty(actividad_accion);
    }
    
    /**
     * Este metodo fija la fecha_semana a una actividad.
     * @param fecha_semana fecha en que se realizara la accion.
     */
    public void setFecha_semana(String fecha_semana) {
        this.fecha_semana = new SimpleStringProperty(fecha_semana);
    }
    
    /**
     * Este metodo fija la forma_operar a una actividad.
     * @param formaOperar forma en que se operara dicha accion.
     */
    public void setFormaOperar(String formaOperar) {
        this.formaOperar = new SimpleStringProperty(formaOperar);
    }
    
    /**
     * Este metodo obtiene la actividad de una Actividad.
     * @return actividad a realizar.
     */
    public String getActividad_accion() {
        return actividad_accion.get();
    }
    
    /**
     * Este metodo obtiene la fecha de una Actividad.
     * @return fecha en que se realizara dicha accion.
     */
    public String getFecha_semana() {
        return fecha_semana.get();
    }
    
    /**
     * Este metodo obtiene la forma de operar dicha accion.
     * @return la forma en que se se realizara dicha accion.
     */
    public String getFormaOperar() {
        return formaOperar.get();
    }
    
    /**
     * Este metodo fija el id del objetivo particular.
     * @param idObjetivoParticular 
     */
    public void setIdObjetivoParticular(Integer idObjetivoParticular) {
        this.idObjetivoParticular = new SimpleIntegerProperty(idObjetivoParticular);
    }
    
    /**
     * Este metodo obtiene el id del objetivo particular.
     * @return idObjetivo particular al que pertenece la actividad.
     */
    public int getIdObjetivoParticular(){
        return idObjetivoParticular.get();
    }
    
    /**
     * Este metodo agrega a la base de datos la actividad.
     * @param connection conexion.
     */
    public void agregar(Connection connection){
        try {
            PreparedStatement instruction = connection.prepareStatement(
                    "insert into actividad (idActividad, actividad_accion, fecha_semana, formaOperar, idObjetivoParticular) "
                    + "values (null , ? , ? , ? , ?)");
            instruction.setString(1, actividad_accion.get());
            instruction.setString(2, fecha_semana.get());
            instruction.setString(3, formaOperar.get());
            instruction.setInt(4, idObjetivoParticular.get());
            instruction.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Actividad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
