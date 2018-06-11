package plandetrabajo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/*************************************************************
 * Clase para manejar los datos de un academico.
 * @version 1.0
 * @since 06/06/18             
 * @author Eduardo Rosas Rivera.                             
*************************************************************/

public class Academico{
    private StringProperty nombre;

    /**
     * Constructor de la clase Academico.
     * @param nombre nombre del academico.
     */
    public Academico(String nombre) { 
	this.nombre = new SimpleStringProperty(nombre);
    }
    
    /**
     *Constructor vacio de la clase academico.
     */
    public Academico(){}

    /**
     * Este metodo obtiene el nombre del academico.
     * @return Nombre del academico.
     */
    public String getNombre() {
	return nombre.get();
    }
    
    /**
     * Este metodo fija el nombre del Academico.
     * @param nombre nombre del academico.
     */
    public void setNombre(String nombre) {
	this.nombre = new SimpleStringProperty(nombre);
    }

     /**
     * Obtiene solo los nombres de los academicos donde el nombre de la academia sea el que se envio
     * como parametro.
     * @param connection conexion a la BD.
     * @param Academicos Lista de academicos para llenar un componente.
     * @param idAcademiaP id de la academia.
     */
    public void obtenerDatos(Connection connection, 
            ObservableList<String> academicos, 
            int idAcademiaP) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(
                    "select nombre from academico where idAcademia = \"" + idAcademiaP + "\"");
            while(resultado.next()){
                academicos.add(resultado.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Academico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    /**
     * Este metodo se usa para agregar los nombres de los participantes en la tabla de 
     * participantes en la base de datos.
     * @param connection conexion a la BD. 
     * @param nombreAcademico nombre del academico que participo.
     * @param idPlan identificador del plan de trabajo.
     */
    public void agregar(Connection connection, String nombreAcademico , int idPlan){
        try {
            PreparedStatement instruction = connection.prepareStatement(
                    "insert into participante (idparticipante, nombre , idplantrabajo) "
                    + "values (null, ? , ?)");
            instruction.setString(1, nombreAcademico);
            instruction.setInt(2, idPlan);
            instruction.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Academico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
   

