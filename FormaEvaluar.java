
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
 * Clase para manejar los datos de una forma de evaluar.
 * @version 1.0
 * @since 06/06/18             
 * @author Eduardo Rosas Rivera.                             
*************************************************************/

public class FormaEvaluar {
    private StringProperty elemento;
    private IntegerProperty porcentaje;
    private IntegerProperty idPlan;
    private IntegerProperty idFormaEvaluar;
    private StringProperty nombreEE;
    
    /**
     * Contructor de la clase FormaEvaluar.
     * @param elemento elemento utilizado como forma de evaluar.
     * @param porcentaje porcentaje del valor del elemento.
     * @param idPlan identificador del plan de trabajo al que pertenece.
     * @param nombreEE nombre de la experiencia educativa.
     */
    public FormaEvaluar(String elemento, Integer porcentaje, Integer idPlan, String nombreEE) {
        this.elemento = new SimpleStringProperty(elemento);
        this.porcentaje = new SimpleIntegerProperty(porcentaje);
        this.idPlan = new SimpleIntegerProperty(idPlan);
        this.nombreEE = new SimpleStringProperty(nombreEE);
    }
    
    /**
     * Este metodo fija el elemento utilizado como forma de evaluar.
     * @param elemento elemento utilizado como forma de evaluar.
     */
    public void setElemento(String elemento) {
        this.elemento = new SimpleStringProperty(elemento);
    }
    
    /**
     * Este metodo obtiene el elemento utilizado como forma de evaluar.
     * @return elemento utilizado como forma de evaluar.
     */
    public String getElemento() {
        return elemento.get();
    }
    
    /**
     * Este metodo fija el porcentaje del elemento.
     * @param porcentaje porcentaje del elemento.
     */
    public void setPorcentaje(Integer porcentaje){
        this.porcentaje = new SimpleIntegerProperty(porcentaje);
    }
    
    /**
     * Este metodo obtiene el porcentaje del elemento.
     * @return el porcentaje.
     */
    public int getPorcentaje(){
        return porcentaje.get();
    }
    
    /**
     * Este metodo fija el porcentaje del elemento.
     * @param idPlan el identificador del plan de trabajo al que pertenece la forma de evaluar.
     */
    public void setIdPlan(Integer idPlan){
        this.idPlan = new SimpleIntegerProperty(idPlan);
    }
    
    /**
     * Este metodo obtine el identificador del plan de trabajo al que pertenece la forma de evaluar
     * @return el identificador del plan de trabajo al que pertenece la forma de evaluar.
     */
    public int getIdPlan(){
        return idPlan.get();
    }
    /**
     * Este metodo obtine el nombre de la experiencia educativa de la forma de evaluar.
     * @return el nombre de la experiencia educativa.
     */
    public String getNombreEE() {
	return nombreEE.get();
    }
    
    /**
     * Este metodo fija el nombre de la experiencia educativa de la forma de evaluar.
     * @param nombreEE nombre de la experiencia educativa de la forma de evaluar.
     */
    public void setNombreEE(String nombreEE) {
	this.nombreEE = new SimpleStringProperty(nombreEE);
    }
    
    /**
     * Este metodo agrega a la base de datos la forma a evaluar.
     * @param connection conexion a la base de datos.
     * @return llave primaria generada por MYSQL.
     */
    public int agregar(Connection connection){
        int clave = 0;
        try {
            PreparedStatement instruction = connection.prepareStatement(
                    "insert into formaevaluar (elemento , porcentaje , idPlanTrabajo, idFormaEvaluar, nombreEE) "
                    + "values (? , ?, ?, null, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS);
            instruction.setString(1, elemento.get());
            instruction.setInt(2, porcentaje.get());
            instruction.setInt(3, idPlan.get());
            instruction.setString(4, nombreEE.get());
            instruction.executeUpdate();
            ResultSet rs = instruction.getGeneratedKeys();
            while (rs.next()) {
                int claveGenerada = rs.getInt(1);
                clave = claveGenerada;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormaEvaluar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clave;
    }
}
