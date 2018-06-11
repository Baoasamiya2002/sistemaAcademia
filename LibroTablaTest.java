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
public class LibroTablaTest {
    
    public LibroTablaTest() {
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
     * Test of getAutor method, of class LibroTabla.
     */
    @Test
    public void testGetAutor() {
        System.out.println("getAutor");
        LibroTabla instance = new LibroTabla();
        instance.autor.set("Jose Carlos");
        String expResult = "Jose Carlos";
        String result = instance.getAutor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTitulo method, of class LibroTabla.
     */
    @Test
    public void testGetTitulo() {
        System.out.println("getTitulo");
        LibroTabla instance = new LibroTabla();
        instance.titulo.set("Harry Potter");
        String expResult = "Harry Potter";
        String result = instance.getTitulo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEditorial method, of class LibroTabla.
     */
    @Test
    public void testGetEditorial() {
        System.out.println("getEditorial");
        LibroTabla instance = new LibroTabla();
        instance.editorial.set("Salaman");
        String expResult = "Salaman";
        String result = instance.getEditorial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAnno method, of class LibroTabla.
     */
    @Test
    public void testGetAnno() {
        System.out.println("getAnno");
        LibroTabla instance = new LibroTabla();
        instance.anno.set("2002");
        String expResult = "2002";
        String result = instance.getAnno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
