/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plancurso;

import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samsung RV415
 */
public class PlanDeCursoTest {
    
    public PlanDeCursoTest() {
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
     * Test of setProgramaEducativo method, of class PlanDeCurso.
     */
    @Test
    public void testSetProgramaEducativo() {
        System.out.println("setProgramaEducativo");
        String programaEducativo = "Ingenieria de Software";
        PlanDeCurso instance = new PlanDeCurso();
        instance.setProgramaEducativo(programaEducativo);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setObjGeneral method, of class PlanDeCurso.
     */
    @Test
    public void testSetObjGeneral() {
        System.out.println("setObjGeneral");
        String objGeneral = "El objetivo de este plan de curso es...";
        PlanDeCurso instance = new PlanDeCurso();
        instance.setObjGeneral(objGeneral);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setIdPeriodo method, of class PlanDeCurso.
     */
    @Test
    public void testSetIdPeriodo() {
        System.out.println("setIdPeriodo");
        String idPeriodo = "Agosto-Enero 2019";
        PlanDeCurso instance = new PlanDeCurso();
        instance.setIdPeriodo(idPeriodo);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNumPersonal method, of class PlanDeCurso.
     */
    @Test
    public void testSetNumPersonal() {
        System.out.println("setNumPersonal");
        String numPersonal = "12234";
        PlanDeCurso instance = new PlanDeCurso();
        instance.setNumPersonal(numPersonal);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getObjGeneral method, of class PlanDeCurso.
     */
    @Test
    public void testGetObjGeneral() {
        System.out.println("getObjGeneral");
        PlanDeCurso instance = new PlanDeCurso();
        String expResult = "El objetivo es...";
        instance.setObjGeneral("El objetivo es...");
        String result = instance.getObjGeneral();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIdPeriodo method, of class PlanDeCurso.
     */
    @Test
    public void testGetIdPeriodo() {
        System.out.println("getIdPeriodo");
        PlanDeCurso instance = new PlanDeCurso();
        String expResult = "Agosto-Enero 2019";
        instance.setIdPeriodo("Agosto-Enero 2019");
        String result = instance.getIdPeriodo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNumPersonal method, of class PlanDeCurso.
     */
    @Test
    public void testGetNumPersonal() {
        System.out.println("getNumPersonal");
        PlanDeCurso instance = new PlanDeCurso();
        String expResult = "1234";
        instance.setNumPersonal("1234");
        String result = instance.getNumPersonal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getProgramaEducativo method, of class PlanDeCurso.
     */
    @Test
    public void testGetProgramaEducativo() {
        System.out.println("getProgramaEducativo");
        PlanDeCurso instance = new PlanDeCurso();
        String expResult = "LIS";
        instance.setProgramaEducativo("LIS");
        String result = instance.getProgramaEducativo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    
}

