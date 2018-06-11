package minuta;

/******************************************************************/
/* Esta clase consiste definir al coordinador de academia. */
/* @version 1.0 */
/* @author Puxka Acosta Domínguez */
/* @since 07/06/2018 */
/******************************************************************/

public class Coordinador_de_academia extends Academico{
    
    /*Para crear un coordinador de academia se necesita el numero de personal, 
      email, fecha de nacimiento y nombre del coordinador de academia
    * @param numPersonal El numero personal del academico
    * @param email El email del academico
    * @param fechaNacimiento La fecha de nacimiento del academico
    * @param nombre El nombre del academico
    */
    
    public Coordinador_de_academia(int numPersonal, String email, 
            String fechaNacimiento, String nombre) {
        super(numPersonal, email, fechaNacimiento, nombre);
    }
    
    /*Para crear un coordinador de academia se necesita el nombre del 
      coordinador de academia
    * @param nombre El nombre del academico
    */
    
    public Coordinador_de_academia(String nombre) {
        super(nombre);
    }
    
}
