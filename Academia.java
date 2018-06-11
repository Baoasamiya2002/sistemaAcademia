
package plandetrabajo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*************************************************************
 * Clase para manejar los datos de una Academia.
 * @version 1.0
 * @since 06/06/18             
 * @author Eduardo Rosas Rivera.                             
*************************************************************/

public class Academia {
    private StringProperty nombre;
    
    /**
     * Contructor de la clase.
     * @param nombre Nombre de la Academia.
     */
    public Academia(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }
    
    /**
     * Contructor vacio de la clase.
     */
    public Academia() {
    }
    
    /**
     * Este metodo recupera de la base de datos el nombre de la academia que corresponda 
     * a un nombre de academico.
     * @param connection
     * @param nombreAcad nombre de un Academico.
     * @return El nombre de la academia.
     */
    public String obtenerNombre(Connection connection, String nombreAcad) {
        try{
            Statement instruccion = connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("select nombre from academia");
            nombreAcad = resultado.getString("nombre");    
        }catch(SQLException ex){
            Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombreAcad;
    }
}
