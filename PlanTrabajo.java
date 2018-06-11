package plandetrabajo;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Clase para manejar los datos de un Plan de trabajo.
 * @version 1.0
 * @since 06/06/18             
 * @author Eduardo Rosas Rivera.                             
*************************************************************/

public class PlanTrabajo{
    private IntegerProperty idPlanTrabajo;
    private StringProperty fechaAprov;
    private StringProperty objGeneral;
    private IntegerProperty numPersonal;
    private IntegerProperty idPeriodo;
    private StringProperty programaEduc;
    private IntegerProperty idAcademia;
    private ArrayList<ObjetivoParticular> objetivos = new ArrayList<>();
    private ArrayList<TemaParcial> temas = new ArrayList<>();
    private ArrayList<FormaEvaluar> formas = new ArrayList<>();
    
    /**
     * Constructor de la clase.
     * @param idPlanTrabajo
     * @param fechaAprov
     * @param objGeneral
     * @param numPersonal
     * @param idPeriodo
     * @param programaEduc
     * @param idAcademia 
     */
    public PlanTrabajo(int idPlanTrabajo, String fechaAprov, String objGeneral, 
        int numPersonal, int idPeriodo, String programaEduc, int idAcademia) { 
	this.idPlanTrabajo = new SimpleIntegerProperty(idPlanTrabajo);
	this.fechaAprov = new SimpleStringProperty(fechaAprov);
	this.objGeneral = new SimpleStringProperty(objGeneral);
	this.numPersonal = new SimpleIntegerProperty(numPersonal);
	this.idPeriodo = new SimpleIntegerProperty(idPeriodo);
	this.programaEduc = new SimpleStringProperty(programaEduc);
	this.idAcademia = new SimpleIntegerProperty(idAcademia);
    }
    
    /**
     * Constructor vacio.
     */
    public PlanTrabajo(){}
    
    /**
     * Este mnetodo obtine el id del plan de trabajo.
     * @return el id del plan de trabajo.
     */
    public int getIdPlanTrabajo() {
	return idPlanTrabajo.get();
    }
    
    /**
     * Este metodo fija el id del plan de trabajo.
     * @param idPlanTrabajo el id del plan de trabajo.
     */
    public void setIdPlanTrabajo(int idPlanTrabajo) {
	this.idPlanTrabajo = new SimpleIntegerProperty(idPlanTrabajo);
    }

    /**
     * Este metodo obtiene la fecha de aprovacion del plan de trabajo.
     * @return la fecha de aprovacion del plan de trabajo.
     */
    public String getFechaAprov() {
	return fechaAprov.get();
    }
    
    /**
     * Este medodo fija la fecha de aporvacion del plan de trabajo.
     * @param fechaAprov la fecha de aprovacion del plan de trabajo.
     */
    public void setFechaAprov(String fechaAprov) {
	this.fechaAprov = new SimpleStringProperty(fechaAprov);
    }

    /**
     * Este metodo obtiene el objetico general del plan de trabajo.
     * @return el objetivo general del plan de trabajo.
     */
    public String getObjGeneral() {
        return objGeneral.get();
    }
    
    /**
     * Este metodo fija el objetivo general del plan de trabajo.
     * @param objGeneral el objetivo general del plan de trabajo.
     */
    public void setObjGeneral(String objGeneral) {
	this.objGeneral = new SimpleStringProperty(objGeneral);
    }

    /**
     * Este metodo obtiene el numero de personal del coordinador que creo el plan de trabajo.
     * @return el numero de personal.
     */
    public int getNumPersonal() {
        return numPersonal.get();
    }
    
    /**
     * Este metodo fija el numero de personal del coordinador de academia.
     * @param numPersonal numero de personal del coordinador de academia.
     */
    public void setNumPersonal(int numPersonal) {
	this.numPersonal = new SimpleIntegerProperty(numPersonal);
    }

    /**
     * Este metodo obtiene el id del periodo.
     * @return id del periodo.
     */
    public int getIdPeriodo() {
        return idPeriodo.get();
    }
    
    /**
     * Este metodo fija el periodo en que se hizo el plan de trabajo.
     * @param idPeriodo id del periodo.
     */
    public void setIdPeriodo(int idPeriodo) {
	this.idPeriodo = new SimpleIntegerProperty(idPeriodo);
    }

    /**
     * Este metodo obtiene el programa educativo.
     * @return programa educativo.
     */
    public String getProgramaEduc() {
	return programaEduc.get();
    }
    
    /**
     * Este metodo fija el programa educativo.
     * @param programaEduc programa educativo.
     */
    public void setProgramaEduc(String programaEduc) {
	this.programaEduc = new SimpleStringProperty(programaEduc);
    }

    /**
     * Este metodo obtiene el id de la academia.
     * @return id de la academia.
     */
    public int getIdAcademia() {
	return idAcademia.get();
    }
    
    /**
     * Este metodo fija el id de la academia.
     * @param idAcademia id de la academia.
     */
    public void setIdAcademia(int idAcademia) {
	this.idAcademia = new SimpleIntegerProperty(idAcademia);
    }

    /**
     * Este metodo agrega el plan de trabajo en la base de datos.
     * @param connection
     * @return La llave primaria generada automaticamente por MYSQL.
     */
    public int agregar(Connection connection){
        int clave = 0;
        try {
            PreparedStatement instruction = connection.prepareStatement(
                    "insert into plantrabajo (idPlanTrabajo, fechaAprov, objGeneral, numPersonal,"
                            + "idPeriodo, programaEduc, idAcademia ) "
                    + "values (null , ?, ?, ?, ?, ?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            instruction.setString(1, fechaAprov.get());
            instruction.setString(2, objGeneral.get());
            instruction.setInt(3, numPersonal.get());
            instruction.setInt(4, idPeriodo.get());
            instruction.setString(5, programaEduc.get());
            instruction.setInt(6, idAcademia.get());
            instruction.executeUpdate();
            ResultSet rs = instruction.getGeneratedKeys();
            while (rs.next()) {
                int claveGenerada = rs.getInt(1);
                clave = claveGenerada;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlanTrabajo.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return clave;
    }
    
    /**
     * Este metodo recupera de la base de datos los planes de trabajo que haya realizado un determinado autor.
     * @param connection
     * @param listaMaterias Lista para obtener todos los Plan de trabajo de la base de datos.
     * @param numPersona Autor del documento.
     */
    public static void obtenerPlanes(Connection connection, ArrayList<PlanTrabajo> listaMaterias, int numPersona){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(
                    "select idPlanTrabajo, fechaAprov, objGeneral, numPersonal, idPeriodo, programaEduc, idAcademia from PlanTrabajo where numPersonal = "+ numPersona);
            while(resultado.next()){
                listaMaterias.add(new PlanTrabajo(
                        resultado.getInt("idPlanTrabajo"),
                        resultado.getString("fechaAprov"),
                        resultado.getString("objGeneral"),
                        resultado.getInt("numPersonal"),
                        resultado.getInt("idPeriodo"),
                        resultado.getString("programaEduc"),
                        resultado.getInt("idAcademia")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlanTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}