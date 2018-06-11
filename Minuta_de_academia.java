package minuta;

import bd.BaseDeDatos;
import java.util.ArrayList;

/**
 *Esta clase consiste definir la minuta de academia.
 *@version 1.0, 07/06/2018
 *@author Puxka Acosta Domínguez
 */

public class Minuta_de_academia {
    private String objetivo;
    private String conclusion;
    private String temaTratar;
    private ArrayList listaDeParticipante;    
    private ArrayList listaDeAsuntoParticipante;
    private ArrayList asuntoAdicional;
    
    /*Para crear una minuta de academia se necesita el objetivo, conclusion y 
    * tema a tratar de la minuta de academia
    * @param objetivo El objetivo de la minuta de academia
    * @param conclusion La conclusion de la minuta de academia
    * @param temaTratar El tema a tratar de la minuta de academia
    */
    
    public Minuta_de_academia(String objetivo, String conclusion, String 
            temaTratar) {
        this.objetivo = objetivo;
        this.conclusion = conclusion;
        this.temaTratar = temaTratar;     
    }

    /*Para crear una minuta de academia se puede no necesitar parametro y esta 
    * inicia los ArrayList que son una lista de participantes de la minuta y 
    * lista de 
    * participantes en los asuntos
    */
    
    public Minuta_de_academia() {
        this.listaDeParticipante = new ArrayList();
        this.listaDeAsuntoParticipante = new ArrayList();
        this.asuntoAdicional = new ArrayList(); 
    }
    
    /**
     * Regresa el objetivo de la minuta de academia
     * @return El objetivo de la minuta de academia
     */
    
    public String getObjetivo() {
        return objetivo;
    }

    /**
    *Reemplaza el objetivo de la minuta de academia con el objetivo que recibe
    * @param objetivo nuevo objetivo
    */
    
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * Regresa la conclusion de la minuta de academia
     * @return la conclusion de la minuta de academia
     */
    
    public String getConclusion() {
        return conclusion;
    }

    /**
    *Reemplaza la conclusion de la minuta de academia con la conclusion que 
    * recibe
    * @param conclusion nueva conclusion
    */
    
    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    /**
     * Regresa el tema a tratar de la minuta de academia
     * @return El tema a tratar de la minuta de academia
     */
    
    public String getTemaTratar() {
        return temaTratar;
    }

    /**
    *Reemplaza tema a tratar de la minuta de academia con el tema a tratar que 
    * recibe
    * @param temaTratar nuevo tema a tratar
    */
    
    public void setTemaTratar(String temaTratar) {
        this.temaTratar = temaTratar;
    }
    
    /**
    *Guarda el nombre del academico que participo en la minuta de academia en 
    * un ArrayList
    * @param nombreAcademico participante en la minuta de academia
    */
    
    public void guardarListaDeParticipante(String nombreAcademico){
        int repetido = 0;
        if(!this.listaDeParticipante.isEmpty()){
            for(int i = 0; i < this.listaDeParticipante.size(); i++){
                if(nombreAcademico.equals(this.listaDeParticipante.get(i))){
                    repetido++;
                }
            }
        }
        if(repetido < 3){
           this.listaDeParticipante.add(nombreAcademico);
        } else {
            int ultimo = 0;
            for(int i = 0; i < 3; i++){
                ultimo = this.listaDeParticipante.lastIndexOf(nombreAcademico);
                this.listaDeParticipante.remove(ultimo);
            }
        }
    }
    
    /**
    *Guarda el nombre del academico que participo en un asunto adicional de la 
    * minuta de academia en un ArrayList y también recibe el id del TextField 
    * donde se escribió el asunto adicional
    * @param nombreAcademico participante en un asunto adicional
    * @param miId id de TextField donde se escribió el asunto adicinal
    */
    
    public void guardarListaDeAsuntoParticipante(String nombreAcademico, 
            String miId){
        if(miId.equals("miAsunto1")){
            if(this.listaDeAsuntoParticipante.isEmpty()){
                this.listaDeAsuntoParticipante.add(nombreAcademico);
            } else{
                this.listaDeAsuntoParticipante.set(0, nombreAcademico);
            }
        } else if(miId.equals("miAsunto2")){
            if(this.listaDeAsuntoParticipante.size() < 2){
                this.listaDeAsuntoParticipante.add(nombreAcademico);
            } else{
                this.listaDeAsuntoParticipante.set(1, nombreAcademico);
            }
        } else{
            if(this.listaDeAsuntoParticipante.size() < 3){
                this.listaDeAsuntoParticipante.add(nombreAcademico);
            } else{
                this.listaDeAsuntoParticipante.set(2, nombreAcademico);
            }
        }
    }
    
    
    /**
     * Guarda el asunto adicional de la minuta de academia el ArrayList 
     * @param asuntoAdicional asunto adicional de la minuta de academia
     */
    
    public void guardarListaAsunto(String asuntoAdicional){
        if(!asuntoAdicional.equals(null)){
            this.asuntoAdicional.add(asuntoAdicional);
        }
    }
    
    /**
     * Regresa el ArrayList con los nombres de los participantes en la minuta de
     * academia
     * @return ArrayList con nombres de participantes
     */
    
    public ArrayList getListaDeParticipante(){
        return listaDeParticipante;
    }
    
    /**
     * Regresa el ArrayList con los nombres de los participantes en un asunto 
     * adicional
     * @return ArrayList con nombres de participantes en un asunto adicional
     */
    
    public ArrayList getListaDeAsuntoParticipante(){
        return listaDeAsuntoParticipante;
    }
    
    /**
     * Regresa el ArrayList con los asuntos adicionales de la minuta de academia
     * @return ArrayList con asuntos adicionales de la minuta de academia
     */
    
    public ArrayList getAsuntoAdicional(){
        return asuntoAdicional;
    }
    
    /*Para crear una guardar una minuta de academia se puede no necesitar 
    * parametro y esta guarda la minuta de academia en la base de datos
    */
    
    public void guardar(){
        BaseDeDatos baseDatos = new BaseDeDatos();
        baseDatos.guardarMinuta_de_academia(this);
    }
}