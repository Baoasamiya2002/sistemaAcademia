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
import plandetrabajo.Periodo;

/**
 *
 * @author Eduar
 */
public class PeriodoTest {
    
    public PeriodoTest() {
    }

    /**
     * Test of setPeriodo method, of class Periodo.
     */
    @Test
    public void testSetPeriodo() {
        System.out.println("setPeriodo");
        String periodo = "ENERO - JUNIO 2018";
        Periodo instance = new Periodo();
        instance.setPeriodo(periodo);
    }

    /**
     * Test of setIdPeriodo method, of class Periodo.
     */
    @Test
    public void testSetIdPeriodo() {
        System.out.println("setIdPeriodo");
        int idPeriodo = 1;
        Periodo instance = new Periodo();
        instance.setIdPeriodo(idPeriodo);
    }
    
}
