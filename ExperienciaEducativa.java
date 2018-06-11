
package plandetrabajo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/*************************************************************
 * Clase para manejar los datos de una Experiencia educativa.
 * @version 1.0
 * @since 06/06/18             
 * @author Eduardo Rosas Rivera.                             
*************************************************************/

public class ExperienciaEducativa {
    private StringProperty nombreEE;
    
    /**
     * Contructor de la Experiencia educativa
     * @param nombreEE nombre de la Experiencia educativa.
     */
    public ExperienciaEducativa(String nombreEE){
        this.nombreEE = new SimpleStringProperty(nombreEE);
    }
    
    /**
     * Constructor vacio de la Experiencia educativa.
     */
    public ExperienciaEducativa(){}
    
    
    /**
     * Este metodo recupera el nombre de la experiencia educativa y lo guarda en una lista para
     * llenar un componente.
     * @param connection conexion a la BD.
     * @param EEs lista de experiencias educativas para llenar un componente.
     */
    public void obtenerDatos(Connection connection, ObservableList<String> EEs){
        try{
            Statement instruccion = connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("select nombreEE from experienciaeducativa");
            while(resultado.next()){
                EEs.add(resultado.getString("nombreEE"));
            }
        }catch(SQLException ex){
            Logger.getLogger(ExperienciaEducativa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
