/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plancurso;

import javafx.beans.property.SimpleStringProperty;

/**
 * @version 1.1
 * @author Foncho
 * @since 08/06/2018
 */
public class UnidadTabla {
    public SimpleStringProperty unidad = new SimpleStringProperty();
    public SimpleStringProperty tema = new SimpleStringProperty();
    public SimpleStringProperty fecha = new SimpleStringProperty();
    public SimpleStringProperty tarea = new SimpleStringProperty();
    public SimpleStringProperty tecnica = new SimpleStringProperty();

    /**
     * Metodo para recuperar las unidades sobre las que se van a trabjar
     * @return los numeros de las unidades
     */
    public String getUnidad() {
        return unidad.get();
    }

    /**
     * Metodo para recuperar los temas que se van a ver
     * @return los temas que se van a ver
     */
    public String getTema() {
        return tema.get();
    }

    /**
     * MEtodo para recuperar la fecha en la que se va a aplicar la unidad
     * @return la fecha a aplicar
     */
    public String getFecha() {
        return fecha.get();
    }

    /**
     * Metodo para recuperar la tare que se va a aplicar
     * @return la tarea que se va a aplicar
     */
    public String getTarea() {
        return tarea.get();
    }

    /**
     * Metodo para recuperar la tecnica que se va a utlizar
     * @return la tecnica que se va a utilizar
     */
    public String getTecnica() {
        return tecnica.get();
    }
    
}
