/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantrabajo;

import org.junit.Test;
import static org.junit.Assert.*;
import plandetrabajo.Herramienta;

/**
 *
 * @author Eduar
 */
public class HerramientaTest {
    
    public HerramientaTest() {
    }

    /**
     * Test of getIdHerramienta method, of class Herramienta.
     */
    @Test
    public void testGetIdHerramienta() {
        System.out.println("getIdHerramienta");
        Herramienta instance = new Herramienta();
        int expResult = 1;
        int result = instance.getIdHerramienta();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdHerramienta method, of class Herramienta.
     */
    @Test
    public void testSetIdHerramienta() {
        System.out.println("setIdHerramienta");
        int idHerramienta = 1;
        Herramienta instance = new Herramienta();
        instance.setIdHerramienta(idHerramienta);
    }

    /**
     * Test of getNombre method, of class Herramienta.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Herramienta instance = new Herramienta();
        String expResult = "DIA";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Herramienta.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "DIA";
        Herramienta instance = new Herramienta();
        instance.setNombre(nombre);
    }

    /**
     * Test of getNombreEE method, of class Herramienta.
     */
    @Test
    public void testGetNombreEE() {
        System.out.println("getNombreEE");
        Herramienta instance = new Herramienta();
        String expResult = "Programacion";
        String result = instance.getNombreEE();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombreEE method, of class Herramienta.
     */
    @Test
    public void testSetNombreEE() {
        System.out.println("setNombreEE");
        String nombreEE = "Programacion";
        Herramienta instance = new Herramienta();
        instance.setNombreEE(nombreEE);
    }

    /**
     * Test of getIdTemaParcial method, of class Herramienta.
     */
    @Test
    public void testGetIdTemaParcial() {
        System.out.println("getIdTemaParcial");
        Herramienta instance = new Herramienta();
        int expResult = 1;
        int result = instance.getIdTemaParcial();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdTemaParcial method, of class Herramienta.
     */
    @Test
    public void testSetIdTemaParcial() {
        System.out.println("setIdTemaParcial");
        int idTemaParcial = 1;
        Herramienta instance = new Herramienta();
        instance.setIdTemaParcial(idTemaParcial);
    }
    
}
