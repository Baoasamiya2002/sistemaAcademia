/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantrabajo;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;
import plandetrabajo.Meta;

/**
 *
 * @author Eduar
 */
public class MetaTest {
    
    public MetaTest() {
    }

    /**
     * Test of setMeta method, of class Meta.
     */
    @Test
    public void testSetMeta() {
        System.out.println("setMeta");
        String meta = "Mejorar el rendimiento estudiantil";
        Meta instance = new Meta();
        instance.setMeta(meta);

    }

    /**
     * Test of getMeta method, of class Meta.
     */
    @Test
    public void testGetMeta() {
        System.out.println("getMeta");
        Meta instance = new Meta();
        String expResult = "Mejorar el rendimiento estudiantil";
        instance.setMeta("Mejorar el rendimiento estudiantil");
        String result = instance.getMeta();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdObjetivoParticular method, of class Meta.
     */
    @Test
    public void testSetIdObjetivoParticular() {
        System.out.println("setIdObjetivoParticular");
        int idObjetivoParticular = 32;
        Meta instance = new Meta();
        instance.setIdObjetivoParticular(idObjetivoParticular);
    }

    /**
     * Test of getIdObjetivoParticular method, of class Meta.
     */
    @Test
    public void testGetIdObjetivoParticular() {
        System.out.println("getIdObjetivoParticular");
        Meta instance = new Meta();
        int expResult = 32;
        instance.setIdObjetivoParticular(32);
        int result = instance.getIdObjetivoParticular();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdMeta method, of class Meta.
     */
    @Test
    public void testGetIdMeta() {
        System.out.println("getIdMeta");
        Meta instance = new Meta();
        int expResult = 2;
        instance.setIdMeta(2);
        int result = instance.getIdMeta();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdMeta method, of class Meta.
     */
    @Test
    public void testSetIdMeta() {
        System.out.println("setIdMeta");
        Integer idMeta = 2;
        Meta instance = new Meta();
        instance.setIdMeta(idMeta);
    }
    
}
