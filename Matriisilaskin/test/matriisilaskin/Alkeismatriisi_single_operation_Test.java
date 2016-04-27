/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laituli
 */
public class Alkeismatriisi_single_operation_Test {
    
    public Alkeismatriisi_single_operation_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of height method, of class Alkeismatriisi.
     */
    @Test
    public void testHeight() {
        System.out.println("height");
        Alkeismatriisi instance = new RiviKerta(3, 2, 1);
        int expResult = 3;
        int result = instance.height();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of width method, of class Alkeismatriisi.
     */
    @Test
    public void testWidth() {
        System.out.println("width");
        Alkeismatriisi instance = new RiviLisays(4, 3, 2, 1);
        int expResult = 4;
        int result = instance.width();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}
