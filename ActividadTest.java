/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantrabajo;

import org.junit.Test;
import static org.junit.Assert.*;
import plandetrabajo.Actividad;

/**
 *
 * @author Eduar
 */
public class ActividadTest {
    
    public ActividadTest() {
    }

    /**
     * Test of setActividad_accion method, of class Actividad.
     */
    @Test
    public void testSetActividad_accion() {
        System.out.println("setActividad_accion");
        String actividad_accion = "Accion";
        Actividad instance = new Actividad();
        instance.setActividad_accion(actividad_accion);
    }

    /**
     * Test of setFecha_semana method, of class Actividad.
     */
    @Test
    public void testSetFecha_semana() {
        System.out.println("setFecha_semana");
        String fecha_semana = "Esta semana";
        Actividad instance = new Actividad();
        instance.setFecha_semana(fecha_semana);
    }

    /**
     * Test of setFormaOperar method, of class Actividad.
     */
    @Test
    public void testSetFormaOperar() {
        System.out.println("setFormaOperar");
        String formaOperar = "Operar";
        Actividad instance = new Actividad();
        instance.setFormaOperar(formaOperar);
    }

    /**
     * Test of getActividad_accion method, of class Actividad.
     */
    @Test
    public void testGetActividad_accion() {
        System.out.println("getActividad_accion");
        Actividad instance = new Actividad();
        String expResult = "Actividad";
        instance.setActividad_accion("Actividad");
        String result = instance.getActividad_accion();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFecha_semana method, of class Actividad.
     */
    @Test
    public void testGetFecha_semana() {
        System.out.println("getFecha_semana");
        Actividad instance = new Actividad();
        String expResult = "Semana";
        instance.setFecha_semana("Semana");
        String result = instance.getFecha_semana();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormaOperar method, of class Actividad.
     */
    @Test
    public void testGetFormaOperar() {
        System.out.println("getFormaOperar");
        Actividad instance = new Actividad();
        String expResult = "Operar";
        instance.setFormaOperar("Operar");
        String result = instance.getFormaOperar();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdObjetivoParticular method, of class Actividad.
     */
    @Test
    public void testSetIdObjetivoParticular() {
        System.out.println("setIdObjetivoParticular");
        Integer idObjetivoParticular = 23;
        Actividad instance = new Actividad();
        instance.setIdObjetivoParticular(idObjetivoParticular);
    }

    /**
     * Test of getIdObjetivoParticular method, of class Actividad.
     */
    @Test
    public void testGetIdObjetivoParticular() {
        System.out.println("getIdObjetivoParticular");
        Actividad instance = new Actividad();
        int expResult = 32;
        instance.setIdObjetivoParticular(32);
        int result = instance.getIdObjetivoParticular();
        assertEquals(expResult, result);
    }
    
}
