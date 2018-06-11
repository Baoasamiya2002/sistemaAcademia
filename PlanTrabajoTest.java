/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantrabajo;

import java.sql.Connection;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import plandetrabajo.PlanTrabajo;

/**
 *
 * @author Eduar
 */
public class PlanTrabajoTest {
    
    public PlanTrabajoTest() {
    }


    /**
     * Test of setIdPlanTrabajo method, of class PlanTrabajo.
     */
    @Test
    public void testSetIdPlanTrabajo() {
        System.out.println("setIdPlanTrabajo");
        int idPlanTrabajo = 2;
        PlanTrabajo instance = new PlanTrabajo();
        instance.setIdPlanTrabajo(idPlanTrabajo);
    }

    /**
     * Test of setFechaAprov method, of class PlanTrabajo.
     */
    @Test
    public void testSetFechaAprov() {
        System.out.println("setFechaAprov");
        String fechaAprov = "12/06/18";
        PlanTrabajo instance = new PlanTrabajo();
        instance.setFechaAprov(fechaAprov);
    }

    /**
     * Test of setNumPersonal method, of class PlanTrabajo.
     */
    @Test
    public void testSetNumPersonal() {
        System.out.println("setNumPersonal");
        int numPersonal = 0;
        PlanTrabajo instance = new PlanTrabajo();
        instance.setNumPersonal(numPersonal);
    }


    /**
     * Test of setIdPeriodo method, of class PlanTrabajo.
     */
    @Test
    public void testSetIdPeriodo() {
        System.out.println("setIdPeriodo");
        Integer idPeriodo = 1;
        PlanTrabajo instance = new PlanTrabajo();
        instance.setIdPeriodo(idPeriodo);
    }

    /**
     * Test of setProgramaEduc method, of class PlanTrabajo.
     */
    @Test
    public void testSetProgramaEduc() {
        System.out.println("setProgramaEduc");
        String programaEduc = "LIS";
        PlanTrabajo instance = new PlanTrabajo();
        instance.setProgramaEduc(programaEduc);
    }

    /**
     * Test of setIdAcademia method, of class PlanTrabajo.
     */
    @Test
    public void testSetIdAcademia() {
        System.out.println("setIdAcademia");
        Integer idAcademia = 12;
        PlanTrabajo instance = new PlanTrabajo();
        instance.setIdAcademia(idAcademia);
    }
    
}
