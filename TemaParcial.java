
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
 * Clase para manejar los datos de un Tema Parcial.
 * @version 1.0
 * @since 06/06/18             
 * @author Eduardo Rosas Rivera.                             
*************************************************************/

public class TemaParcial {
    private StringProperty parcial1;
    private StringProperty parcial2;
    private IntegerProperty idPlan;
    private StringProperty nombreEE;
    private IntegerProperty idTemaParcial;
    ArrayList<Herramienta> herramientas = new ArrayList<>();
    
    /**
     * Constructor de la clase.
     * @param idTemaParcial identificador del tema parcial.
     * @param parcial1 lo que se vera en el parcial 1.
     * @param parcial2 lo que se vera en el parcial 2.
     * @param idPlan identificador del plan de trabajo al que pertenece.
     * @param nombreEE nombre de la EE a la que pertencen los temas parciales.
     */
    public TemaParcial(Integer idTemaParcial, String parcial1, String parcial2, Integer idPlan, String nombreEE){
        this.idTemaParcial = new SimpleIntegerProperty(idTemaParcial);
        this.parcial1 = new SimpleStringProperty(parcial1);
        this.parcial2 = new SimpleStringProperty(parcial2);
        this.idPlan = new SimpleIntegerProperty(idPlan);
        this.nombreEE = new SimpleStringProperty(nombreEE);
    }
    
    /**
     * Constructor vacio.
     */
    public TemaParcial(){}
    
    /**
     * Este metodo obtiene el primer tema parcial.
     * @return lo que se ve en el parcial 1.
     */
    public StringProperty getParcial1() {
        return parcial1;
    }

    /**
     * Este metodo fija el primer parcial.
     * @param parcial1 lo que se vera en el parcial 1.
     */
    public void setParcial1(String parcial1) {
        this.parcial1 = new SimpleStringProperty(parcial1);
    }

    /**
     * Este metodo obtiene el segundo tema parcial.
     * @return lo que se ve en el segundo parcial.
     */
    public String getParcial2() {
        return parcial2.get();
    }

    /**
     * Este metodo fija lo que se ve en el parcial 2.
     * @param parcial2 lo que se en el segundo parcial.
     */
    public void setParcial2(String parcial2) {
        this.parcial2 = new SimpleStringProperty(parcial2);
    }

    /**
     * Este metodo obtiene el identificador del plan de trabajo.
     * @return identificador del plan de trabajo.
     */
    public int getIdPlan() {
        return idPlan.get();
    }

    /**
     * Este metodo fija el identificador del plan de trabajo.
     * @param idPlan el identificador del plan de trabajo.
     */
    public void setIdPlan(Integer idPlan) {
        this.idPlan = new SimpleIntegerProperty(idPlan);
    }

    /**
     * Este metodo obtiene el nombre de la experiencia educativa.
     * @return nombre de la Experiencia Educativa.
     */
    public String getNombreEE() {
        return nombreEE.get();
    }

    /**
     * Este metodo fija el nombre de la Experiencia Educativa.
     * @param nombreEE nombre de la experiencia educativa.
     */
    public void setNombreEE(String nombreEE) {
        this.nombreEE = new SimpleStringProperty(nombreEE);
    }
    
    /**
     * Este metodo agrega una Herramienta al ArrayList de herramientas.
     * @param herramienta objeto de tipo Herramienta.
     */
    public void setHerramienta(Herramienta herramienta){
        herramientas.add(herramienta);
    }
    
    /**
     * Este metodo devuelve una herramienta especifica del ArrayList.
     * @param indice posicion de la Herramienta en el ArrayList.
     * @return Herramienta en l posicion indice.
     */
    public Herramienta getHerramienta(int indice){
        return herramientas.get(indice);
    }
    
    /**
     * Este metodo regresa el tamano del ArrayList de Herramientas.
     * @return el tamanio del Array de Herramientas.
     */
    public int getTamanioHerramientas(){
        return herramientas.size();
    }
    
    /**
     * Este metodo guarda el tema parcial en la base de datos y regresa la llave primaria generada por MYSQL.
     * @param connection conexion a la BD.
     * @return La llave primaria generada por MYSQL.
     */
    public int guardarTema(Connection connection){
        int clave = 0;
        try {
            PreparedStatement instruction = connection.prepareStatement(
                    "insert into temaparcial (idtemaParcial , parcial1 , parcial2 , idPlanTrabajo , nombreEE) "
                    + "values (null , ? , ? , ? , ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            instruction.setString(1, parcial1.get());
            instruction.setString(2, parcial2.get());
            instruction.setInt(3, idPlan.get());
            instruction.setString(4, nombreEE.get());
            instruction.executeUpdate();
            ResultSet rs = instruction.getGeneratedKeys();
            while (rs.next()) {
                int claveGenerada = rs.getInt(1);
                clave = claveGenerada;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TemaParcial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clave;
    }
}
