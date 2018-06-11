package minuta;

/******************************************************************/
/* Esta clase consiste definir la reunion de academia. */
/* @version 1.0 */
/* @author Puxka Acosta Domínguez */
/* @since 07/06/2018 */
/******************************************************************/

public class Reunion_de_academia {
    private String asunto;
    private String fecha;
    private String hora;
    private String lugar;
    
    /*Para crear una reunion de academia se necesita el asunto, fecha, hora y 
      lugar de la reunion de academia
    * @param asunto El asunto de la reunion de academia
    * @param fecha La fecha de la reunion de academia
    * @param hora La hora de la reunion de academia
    * @param lugar El lugar de la reunion de academia
    */
    
    public Reunion_de_academia(String asunto, String fecha, String hora,
            String lugar) {
        this.asunto = asunto;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
    }

    /**
     * Regresa el asunto de la reunion de academia
     * @return El asunto de la reunion de academia
     */
    
    public String getAsunto() {
        return asunto;
    }

    /**
    *Reemplaza el asunto de la reunion de academia con el asunto que recibe
    * @param asunto nuevo asunto
    */
    
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * Regresa la fecha de la reunion de academia
     * @return La fecha de la reunion de academia
     */
    
    public String getFecha() {
        return fecha;
    }

    /**
    *Reemplaza la fecha de la reunion de academia con la fecha que recibe
    * @param fecha nueva fecha
    */
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Regresa la hora de la reunion de academia
     * @return La hora de la reunion de academia
     */
    
    public String getHora() {
        return hora;
    }

    /**
    *Reemplaza la hora de la reunion de academia con la hora que recibe
    * @param hora nueva hora
    */
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    /**
     * Regresa el lugar de la reunion de academia
     * @return El lugar de la reunion de academia
     */
    
    public String getLugar() {
        return lugar;
    }
    
    /**
    *Reemplaza el lugar de la reunion de academia con el lugar que recibe
    * @param lugar nuevo lugar
    */
    
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}