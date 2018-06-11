
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

/**
 *
 * @author Eduardo Rosas Rivera
 */
public class ProgramaEducativo {
    private StringProperty nombre;
    
    public ProgramaEducativo(String nombre){
        this.nombre = new SimpleStringProperty(nombre);
    }
    
    public ProgramaEducativo(){}
    
    /**
     *
     * @param connection
     * @param nombrePrograma
     */
    public void obtenerPrograma(Connection connection, ObservableList<String> ProgramasE){
        try{
            Statement instruccion = connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("select programaeduc from programaeducativo");
            while(resultado.next()){
                ProgramasE.add(resultado.getString("programaeduc"));
            }   
        }catch(SQLException ex){
            Logger.getLogger(ProgramaEducativo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
