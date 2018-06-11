package minuta;

/******************************************************************/
/* Esta clase consiste definir la carrera de la minuta de academia. */
/* @version 1.0 */
/* @author Puxka Acosta Domínguez */
/* @since 07/06/2018 */
/******************************************************************/

public class Carrera {
    private String programaEduc;

    /*Para crear una carrera se necesita el programa educativo de 
      academia
    * @param programaEduc El programa educativo de academia
    */
    
    public Carrera(String programaEduc) {
        this.programaEduc = programaEduc;
    }

    /**
     * Regresa el programa educativo de la academia
     * @return El programa educativo de la academia
     */
    
    public String getProgramaEduc() {
        return programaEduc;
    }

    /**
    *Reemplaza el programa educativo de la academia con el programa educativo 
    * que recibe
    * @param programaEduc nuevo programa educativo
    */

    public void setProgramaEduc(String programaEduc) {
        this.programaEduc = programaEduc;
    }
    
}

