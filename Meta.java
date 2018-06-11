
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
 * Clase para manejar los datos de una Academia.
 * @version 1.0
 * @since 06/06/18             
 * @author Eduardo Rosas Rivera.                             
*************************************************************/

public class Meta {
    private StringProperty meta;
    private IntegerProperty idObjetivoParticular;
    private IntegerProperty idMeta;
    
    /**
     * Contructor de la clase Meta.
     * @param idMeta identificador temporal de la clase Meta.
     * @param meta Meta a alcanzar.
     * @param idObjetivoParticular identificador del objetivo particular al que pertenece la meta.
     */
    public Meta(Integer idMeta, String meta, Integer idObjetivoParticular) {
        this.idMeta = new SimpleIntegerProperty(idMeta);
        this.meta = new SimpleStringProperty(meta);
        this.idObjetivoParticular = new SimpleIntegerProperty(idObjetivoParticular);
    }
    
    /**
     * Constructor vacio de la clase.
     */
    public Meta() {
    }
    
    /**
     * Este metodo fija la meta al alcanzar.
     * @param meta meta a alcanzar.
     */
    public void setMeta(String meta) {
        this.meta = new SimpleStringProperty(meta);
    }
    
    /**
     * Este metodo obtiene la meta al alcanzar.
     * @return la meta a alcanzar.
     */
    public String getMeta(){
        return meta.get();
    }
    
    /**
     * Este metodo fija el identificador del objetivo particular al que pertenece la meta.
     * @param idObjetivoParticular 
     */
    public void setIdObjetivoParticular(Integer idObjetivoParticular){
        this.idObjetivoParticular = new SimpleIntegerProperty(idObjetivoParticular);
    }
    
    /**
     * Este metodo obtiene el identificador del objetivo particular al que pertenece la meta.
     * @return el identificador del objetivo particular. 
     */
    public int getIdObjetivoParticular(){
        return idObjetivoParticular.get();
    }
    
    /**
     * Este metodo obtiene le identificador de la meta.
     * @return el identificador de la meta.
     */
    public int getIdMeta(){
        return idMeta.get();
    }
    
    /**
     * Este metodo fija el identificador de la meta.
     * @param idMeta 
     */
    public void setIdMeta(Integer idMeta){
        this.idMeta = new SimpleIntegerProperty(idMeta);
    }
    
    /**
     * Este metodo agrega la meta a la base de datos.
     * @param connection conexion a la BD.
     */
    public void agregar(Connection connection){
        try {
            PreparedStatement instruction = connection.prepareStatement(
                    "insert into meta (idmeta, meta, idObjetivoParticular) "
                    + "values (null , ? , ?)");
            instruction.setString(1, meta.get());
            instruction.setInt(2, idObjetivoParticular.get());
            instruction.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Actividad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
