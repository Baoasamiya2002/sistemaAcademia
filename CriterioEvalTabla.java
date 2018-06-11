/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plancurso;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @version 1.1
 * @author Foncho
 * @since 08/06/2018
 */
public class CriterioEvalTabla {
    public SimpleStringProperty unidad = new SimpleStringProperty();
    public SimpleStringProperty fecha = new SimpleStringProperty();
    public SimpleStringProperty criterio = new SimpleStringProperty();
    public SimpleStringProperty instrumento = new SimpleStringProperty();
    public SimpleStringProperty porcentaje = new SimpleStringProperty();

    /**
     * Metodo para recuperar la o las unidades del criterio
     * @return string de la o las unidades
     */
    public String getUnidad() {
        return unidad.get();
    }

    /**
     * Metodo para recuperar la o las fechas donde se aplicara el criterio
     * @return las fechas a aplicar el criterio
     */
    public String getFecha() {
        return fecha.get();
    }

    /**
     * Metodo para recuperar el o los criterios a calificar del criterio
     * @return string del criterio que se va a tomar en cuenta
     */
    public String getCriterio() {
        return criterio.get();
    }

    /**
     * Metodo para recuperar el o los instrumentos para obtener la calificacion
     * @return string del o los instrumentos
     */
    public String getInstrumento() {
        return instrumento.get();
    }

    /**
     * Metodo para recuperar el valor en porcentaje del criterio
     * @return el porcentaje del valor del criterio
     */
    public String getPorcentaje() {
        return porcentaje.get();
    }

}
