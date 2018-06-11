/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantrabajo;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;
import plandetrabajo.Participante;

/**
 *
 * @author Eduar
 */
public class ParticipanteTest {
    
    public ParticipanteTest() {
    }

    /**
     * Test of getNombre method, of class Participante.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Participante instance = new Participante();
        String expResult = "Arenas Valdes Maria de los Angeles";
        instance.setNombre("Arenas Valdes Maria de los Angeles");
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Participante.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "Arenas Valdes Maria de los Angeles";
        Participante instance = new Participante();
        instance.setNombre(nombre);
    }

    /**
     * Test of getIdPlanTrabajo method, of class Participante.
     */
    @Test
    public void testGetIdPlanTrabajo() {
        System.out.println("getIdPlanTrabajo");
        Participante instance = new Participante();
        int expResult = 32;
        instance.setIdPlanTrabajo(32);
        int result = instance.getIdPlanTrabajo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdPlanTrabajo method, of class Participante.
     */
    @Test
    public void testSetIdPlanTrabajo() {
        System.out.println("setIdPlanTrabajo");
        int idPlanTrabajo = 32;
        Participante instance = new Participante();
        instance.setIdPlanTrabajo(idPlanTrabajo);
    }
    
}
