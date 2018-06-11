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
public class LibroTabla {
    public SimpleStringProperty autor = new SimpleStringProperty();
    public SimpleStringProperty titulo = new SimpleStringProperty();
    public SimpleStringProperty editorial = new SimpleStringProperty();
    public SimpleStringProperty anno = new SimpleStringProperty();

    /**
     * para recuperar el autor del libro
     * @return el nombre o nombres de los autores del libro
     */
    public String getAutor() {
        return autor.get();
    }

    /**
     * metodo para recuperar el titulo del libro
     * @return el titulo del libro
     */
    public String getTitulo() {
        return titulo.get();
    }

    /**
     * Metodo para recuperar la editorial del libro
     * @return la editorial del libro
     */
    public String getEditorial() {
        return editorial.get();
    }

    /**
     * Metodo para recuperar el anno del libro
     * @return el anno del libro
     */
    public String getAnno() {
        return anno.get();
    }

    
}
