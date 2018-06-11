/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantrabajo;

import java.sql.Connection;
import javafx.collections.ObservableList;
import org.junit.Test;
import static org.junit.Assert.*;
import plandetrabajo.Academico;

/**
 *
 * @author Eduar
 */
public class AcademicoTest {
    
    public AcademicoTest() {
    }

    /**
     * Test of getNombre method, of class Academico.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Academico instance = new Academico();
        String expResult = "Arenas Valdes Maria de los Angeles";
        instance.setNombre(expResult);
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Academico.
      */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "Arenas Valdes Maria de los Angeles";
        Academico instance = new Academico();
        instance.setNombre(nombre);
    }
   
}
