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
public class CriterioEvalTablaTest {
    
    public CriterioEvalTablaTest() {
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
     * Test of getUnidad method, of class CriterioEvalTabla.
     */
    @Test
    public void testGetUnidad() {
        System.out.println("getUnidad");
        CriterioEvalTabla instance = new CriterioEvalTabla();
        instance.unidad.set("Unidad 1 y 2");
        String expResult = "Unidad 1 y 2";
        String result = instance.getUnidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFecha method, of class CriterioEvalTabla.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        CriterioEvalTabla instance = new CriterioEvalTabla();
        instance.fecha.set("Del 13 al 17 de mayo");
        String expResult = "Del 13 al 17 de mayo";
        String result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCriterio method, of class CriterioEvalTabla.
     */
    @Test
    public void testGetCriterio() {
        System.out.println("getCriterio");
        CriterioEvalTabla instance = new CriterioEvalTabla();
        instance.criterio.set("Numero de aciertos correctos");
        String expResult = "Numero de aciertos correctos";
        String result = instance.getCriterio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getInstrumento method, of class CriterioEvalTabla.
     */
    @Test
    public void testGetInstrumento() {
        System.out.println("getInstrumento");
        CriterioEvalTabla instance = new CriterioEvalTabla();
        instance.instrumento.set("Examen");
        String expResult = "Examen";
        String result = instance.getInstrumento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPorcentaje method, of class CriterioEvalTabla.
     */
    @Test
    public void testGetPorcentaje() {
        System.out.println("getPorcentaje");
        CriterioEvalTabla instance = new CriterioEvalTabla();
        instance.porcentaje.set("20");
        String expResult = "20";
        String result = instance.getPorcentaje();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
