package minuta;

/**
 *Esta clase consiste definir el asunto adicional de la minuta de academia.
 *@version 1.0, 07/06/2018
 *@author Puxka Acosta Domínguez
 */

public class Asunto {
    private String asuntoAdicional;

    /*Para crear un asunto se necesita el asunto adicional de la minuta de 
      academia
    * @param asuntoAdicional El asunto adicional de la minuta de academia
    */
    
    public Asunto(String asuntoAdicional) {
        this.asuntoAdicional = asuntoAdicional;
    }

    /**
     * Regresa el asunto adicional de la minuta de academia
     * @return El asunto adicional de la minuta de academia
     */
    
    public String getAsuntoAdicional() {
        return asuntoAdicional;
    }

    /**
    *Reemplaza el asunto adicional de la minuta de academia con el asunto 
    * adicional que recibe
    * @param asuntoAdicional nuevo asunto adicional
    */

    public void setAsuntoAdicional(String asuntoAdicional) {
        this.asuntoAdicional = asuntoAdicional;
    }
}
