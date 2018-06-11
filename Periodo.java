
package plandetrabajo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*************************************************************
 * Clase para manejar los datos de un Periodo.
 * @version 1.0
 * @since 06/06/18             
 * @author Eduardo Rosas Rivera.                             
*************************************************************/

public class Periodo {
    private StringProperty periodo;
    private IntegerProperty idPeriodo;
    /**
     * Contructor de periodo.
     * @param periodo nombre del periodo.
     */
    public Periodo(String periodo, Integer idPeriodo) {
        this.periodo = new SimpleStringProperty(periodo);
        this.idPeriodo = new SimpleIntegerProperty(idPeriodo);
    }
    
    /**
     * Constructor vacio de Periodo.
     */
    public Periodo(){
        
    }
    /**
     * Este metodo fija el periodo.
     * @param periodo periodo.
     */
    public void setPeriodo(String periodo) {
        this.periodo = new SimpleStringProperty(periodo);
    }
    
    /**
     * Este metodo obtiene el periodo.
     * @return periodo.
     */
    public String getPeriodo() {
        return periodo.get();
    }
    
    /**
     * Este metodo fija el identificador del periodo.
     * @param idPeriodo identificador del periodo.
     */
    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = new SimpleIntegerProperty(idPeriodo);
    }
    
    /**
     * Este metodo obtiene el identificador del periodo.
     * @return 
     */
    public int getIdPeriodo() {
        return idPeriodo.get();
    }
    
    /**
     * Este metodo recupera todos los periodo de la base de datos.
     * @param connection conexion a la base de datos.
     * @param periodos ArrayList de Periodos.
     */
    public void obtenerNombre(Connection connection, ArrayList<Periodo> periodos) {
        try{
            Statement instruccion = connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("select * from periodo");
            while(resultado.next()){
                periodos.add(new Periodo(resultado.getString("periodo"), resultado.getInt("idPeriodo")));
            }  
        }catch(SQLException ex){
            Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
