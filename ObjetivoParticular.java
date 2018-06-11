
package plandetrabajo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*************************************************************
 * Clase para manejar los datos de un Objetivo particular.
 * @version 1.0
 * @since 06/06/18             
 * @author Eduardo Rosas Rivera.                             
*************************************************************/

public class ObjetivoParticular {
    private StringProperty objetivoParticular;
    private IntegerProperty idPlan;
    private IntegerProperty idObjetivoParticular;
    private ArrayList<Meta> metas = new ArrayList<>();
    private ArrayList<Actividad> actividades = new ArrayList<>();
    private ArrayList<Herramienta> herramientas = new ArrayList<>();
    
    /**
     * Constructor de la clase ObjetivoParticular.
     * @param objetivoParticular objetivo particular del plan de trabajo.
     * @param idPlan identificador del plan de trabajo al que pertenece el Objetivo Particular.
     * @param idObjetivoParticular identificador del objetivo particular.
     */
    public ObjetivoParticular(String objetivoParticular, Integer idPlan, 
            Integer idObjetivoParticular) {
        this.objetivoParticular = new SimpleStringProperty(objetivoParticular);
        this.idPlan = new SimpleIntegerProperty(idPlan);
        this.idObjetivoParticular = new SimpleIntegerProperty(idObjetivoParticular);
    }
    
    /**
     * Constructor vacio de la clase ObjetivoParticular.
     */
    public ObjetivoParticular() {
    }
    
    /**
     * Este metodo fija el objetivo particular.
     * @param objetivoParticular fija el objetivo particular.
     */
    public void setObjetivoParticular(String objetivoParticular) {
        this.objetivoParticular = new SimpleStringProperty(objetivoParticular);
    }
    
    /**
     * Este metodo obtiene el objetivo particular.
     * @return el objetivo partiuclar.
     */
    public String getObjetivoParticular() {
        return objetivoParticular.get();
    }
    
    /**
     * Este metodo obtiene el identificador del objetivo particular.
     * @return id del objetivo particular.
     */
    public int getIdObjetivoParticular() {
        return idObjetivoParticular.get();
    }
    
    /**
     * Este metodo agregra una Meta a la lista de metas.
     * @param meta objeto de tipo Meta.
     */
    public void setMetas(Meta meta) {
        metas.add(meta);
    }
    
    /**
     * Este metodo devuelve una Meta en especifico del ArrayList.
     * @param indice posicion de la Meta a devolver.
     * @return Meta en la posicion indice.
     */
    public Meta getMeta(int indice) {
        return metas.get(indice);
    }
    
    /**
     * Este metodo agrega un actividad al objetivo particular al ArrayList del actividades.
     * @param actividad objeto de tipo Actividad.
     */
    public void setActividad(Actividad actividad) {
        actividades.add(actividad);
    }
    
    /**
     * Este metodo devuelve una actividad en especifico del ArrayList.
     * @param indice posicion de la actividad a devolver.
     * @return Actividad en la posicion indice.
     */
    public Actividad getActividad(int indice) {
        return actividades.get(indice);
    }
    
    /**
     * Este metodo agrega una Herramienta al objetivo particular al ArrayList de herramientas.
     * @param herramienta objeto de tipo Herramienta.
     */
    public void setHerramientas(Herramienta herramienta) {
        herramientas.add(herramienta);
    }
    
    /**
     * Este metodo devuelve una Herramienta en especifico del ArrayList.
     * @param indice posicion de la Herramienta a devolver.
     * @return Herramienta en la posicion indice.
     */
    public Herramienta getHerramienta(int indice) {
        return herramientas.get(indice);
    }
    
    /**
     * Este metodo fija el identificador del plan de trabajo al que pertenece.
     * @param idPlan identificador del plan de trabajo.
     */
    public void setIdPlan(int idPlan) {
	this.idPlan = new SimpleIntegerProperty(idPlan);
    }
    
    /**
     * Este metodo regresa el tamano del ArrayList de Metas.
     * @return el tamano del ArrayList metas.
     */
    public int getTamanioMetas() {
        return metas.size();
    }
    
    /**
     * Este metodo regresa el tamanio del ArrayList de Actividades.
     * @return el tamanio del ArrayList de actividades.
     */
    public int getTamanioActividades() {
        return actividades.size();
    }
    
    /**
     * Este metodo agrega el objetivo particular a la base de datos.
     * @param connection conexion a la BD.
     * @return el id generado por MYSQL.
     */
    public int agregar(Connection connection) {
        int clave = 0;
        try {
            PreparedStatement instruction = connection.prepareStatement(
                    "insert into objetivoParticular ("
                            + "idObjetivoParticular , "
                            + "objetivoParticular , "
                            + "idPlan) "
                    + "values (null , ? , ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            instruction.setString(1, objetivoParticular.get());
            instruction.setInt(2, idPlan.get());
            instruction.executeUpdate();
            ResultSet rs = instruction.getGeneratedKeys();
            while (rs.next()) {
                int claveGenerada = rs.getInt(1);
                clave = claveGenerada;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObjetivoParticular.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clave;
    }
}
