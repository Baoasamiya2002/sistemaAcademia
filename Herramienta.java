
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
 * Clase para manejar los datos de una Herramienta.
 * @version 1.0
 * @since 06/06/18             
 * @author Eduardo Rosas Rivera.                             
**/

public class Herramienta{
    private IntegerProperty idHerramienta;
    private StringProperty nombre;
    private StringProperty nombreEE;
    private IntegerProperty idTemaParcial;
    
    /**
     * Contructor de la clase Herramienta.
     * @param idHerramienta identificador temporal de la herramienta.
     * @param nombre nombre de la herramienta.
     * @param nombreEE nombre de la Experiencia Educativa que utilizara la herramienta.
     * @param idTemaParcial identificador del tema parcial al que pertenece la herramienta.
     */
    public Herramienta(int idHerramienta, String nombre, String nombreEE, int idTemaParcial) {
        this.idHerramienta = new SimpleIntegerProperty(idHerramienta);
	this.nombre = new SimpleStringProperty(nombre);
	this.nombreEE = new SimpleStringProperty(nombreEE);
	this.idTemaParcial = new SimpleIntegerProperty(idTemaParcial);
    }
    
    /**
     * Contructor vacio de la Herramienta.
     */
    public Herramienta() {
    }
    
    /**
     * Este metodo obtiene el identificador temporal de la Herramienta.
     * @return el identificador de la herramienta.
     */
    public int getIdHerramienta() {
	return idHerramienta.get();
    }
    
    /**
     * Este metodo fija el identificador temporal de la herramienta.
     * @param idHerramienta identificador temporal de la herramienta.
     */
    public void setIdHerramienta(int idHerramienta) {
	this.idHerramienta = new SimpleIntegerProperty(idHerramienta);
    }
    
    /**
     * Este metodo obtiene el nombre de la Herramienta.
     * @return Nombre de la Herramienta.
     */
    public String getNombre() {
        return nombre.get();
    }
    
    /**
     * Este metodo fija el nombre de la Herramienta.
     * @param nombre nombre de la herramienta.
     */
    public void setNombre(String nombre) {
	this.nombre = new SimpleStringProperty(nombre);
    }

    /**
     * Este metodo regresa el nombre de la experiencia educativa que usara la herramienta.
     * @return el nombre de la experiencia educativa que usara la herramienta.
     */
    public String getNombreEE() {
	return nombreEE.get();
    }
    
    /**
     * Este metodo fija el nombre de la Experiencia educativa que usara la herrmienta.
     * @param nombreEE nombre de la Experiencia educativa.
     */
    public void setNombreEE(String nombreEE) {
	this.nombreEE = new SimpleStringProperty(nombreEE);
    }
    
    /**
     * Este metodo obtiene le identificador temporal de un tema parcial.
     * @return el identificador de un tema parcial.
     */
    public int getIdTemaParcial() {
	return idTemaParcial.get();
    }
    
    /**
     * Este metodo fija el identificador temporal del tema parcial.
     * @param idTemaParcial identificador del tema parcial.
     */
    public void setIdTemaParcial(int idTemaParcial) {
	this.idTemaParcial = new SimpleIntegerProperty(idTemaParcial);
    }
    
    /**
     * Este metodo 
     * @return 
     */
    
    /**
     * Este metodo agregar el tema parcial a la base de datos.
     * @param connection conexion a la BD.
     */
    public void agregar(Connection connection){
        try {
            PreparedStatement instruction = connection.prepareStatement(
                    "insert into herramienta (idHerramienta , nombre , idTemaParcial , nombreEE) "
                    + "values (null , ? , ? , ?)");
            instruction.setString(1,nombre.get());
            instruction.setInt(2, idTemaParcial.get());
            instruction.setString(3, nombreEE.get());
            instruction.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TemaParcial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
