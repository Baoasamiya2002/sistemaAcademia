/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plancurso;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Foncho
 */
public class UnidadTablaTest {
    
    public UnidadTablaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUnidad method, of class UnidadTabla.
     */
    @Test
    public void testGetUnidad() {
        System.out.println("getUnidad");
        UnidadTabla instance = new UnidadTabla();
        instance.unidad.set("Unidad 1");
        String expResult = "Unidad 1";
        String result = instance.getUnidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTema method, of class UnidadTabla.
     */
    @Test
    public void testGetTema() {
        System.out.println("getTema");
        UnidadTabla instance = new UnidadTabla();
        instance.tema.set("Programacion Orientada a Objetos");
        String expResult = "Programacion Orientada a Objetos";
        String result = instance.getTema();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFecha method, of class UnidadTabla.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        UnidadTabla instance = new UnidadTabla();
        instance.fecha.set("14 de abril");
        String expResult = "14 de abril";
        String result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTarea method, of class UnidadTabla.
     */
    @Test
    public void testGetTarea() {
        System.out.println("getTarea");
        UnidadTabla instance = new UnidadTabla();
        instance.tarea.set("Resumen");
        String expResult = "Resumen";
        String result = instance.getTarea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTecnica method, of class UnidadTabla.
     */
    @Test
    public void testGetTecnica() {
        System.out.println("getTecnica");
        UnidadTabla instance = new UnidadTabla();
        instance.tecnica.set("No se que va");
        String expResult = "No se que va";
        String result = instance.getTecnica();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
