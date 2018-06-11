/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plancurso;

import bd.BaseDeDatos;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import vista.Sistema_academia;

/**
 * @version 1.1
 * @author Alfonso Robles Aguilar
 * @since 08/06/2018
 */
public class PlanDeCurso {
    private String objGeneral;
    private String idPeriodo;
    private String numPersonal;
    private String programaEducativo;

    /**
     * Constructor del plan de curso
     * @param objGeneral del plan de curso
     * @param idPeriodo del periodo en el que existe el curso
     * @param numPersonal del creador del plan de curso
     * @param programaEducativo al que pertenece la EE
     */
    public PlanDeCurso(String objGeneral, String idPeriodo, String numPersonal, String programaEducativo) {
        this.objGeneral = objGeneral;
        this.idPeriodo = idPeriodo;
        this.numPersonal = numPersonal;
        this.programaEducativo = programaEducativo;
    }

    public PlanDeCurso(){
        
    }
    /**
     * metodo para recuperar el objetivo general del plan de curso
     * @return el objetivo general
     */
    public String getObjGeneral() {
        return objGeneral;
    }
    
    /**
     * metodo pare recuperar el id del periodo
     * @return el id del periodo del plan de curso
     */
    public String getIdPeriodo() {
        return idPeriodo;
    }

    /**
     * metodo para recuperar el numero de personal del academico
     * @return el numero de personal
     */
    public String getNumPersonal() {
        return numPersonal;
    }

    /**
     * metodo para recuperar el programa educativo en string
     * @return el programa educativo del plan de curso
     */
    public String getProgramaEducativo() {
        return programaEducativo;
    }

    /**
     * desde aqui se guarda todo el contenido del plan de curso
     * @param unidades que son parte del plan de curso
     * @param libros que son parte del plan de curso
     * @param criterios que son parte del plan de curso
     */
    public void guardarTodo(ObservableList<UnidadTabla> unidades, ObservableList<LibroTabla> libros, ObservableList<CriterioEvalTabla> criterios){
        while(!unidades.isEmpty()){
            BaseDeDatos co = new BaseDeDatos();
            try{
                co.guardarUnidad(unidades.remove(0), "1");
            } catch (SQLException ex) {
            Logger.getLogger(Sistema_academia.class.getName()).log
                (Level.SEVERE, null, ex);
            }  
        }
        while(!libros.isEmpty()){
            BaseDeDatos co = new BaseDeDatos();
            try{
                co.guardarLibro(libros.remove(0),"1");
            } catch (SQLException ex) {
            Logger.getLogger(Sistema_academia.class.getName()).log
                (Level.SEVERE, null, ex);
            }
            
        }
        while(!criterios.isEmpty()){
            BaseDeDatos co = new BaseDeDatos();
            try{
               co.guardarCriterio(criterios.remove(0), "1"); 
            } catch (SQLException ex) {
            Logger.getLogger(Sistema_academia.class.getName()).log
                (Level.SEVERE, null, ex);
            }
        }
        
    }

    /**
     * @param objGeneral the objGeneral to set
     */
    public void setObjGeneral(String objGeneral) {
        this.objGeneral = objGeneral;
    }

    /**
     * @param idPeriodo the idPeriodo to set
     */
    public void setIdPeriodo(String idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    /**
     * @param numPersonal the numPersonal to set
     */
    public void setNumPersonal(String numPersonal) {
        this.numPersonal = numPersonal;
    }

    /**
     * @param programaEducativo the programaEducativo to set
     */
    public void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo = programaEducativo;
    }
    
}
