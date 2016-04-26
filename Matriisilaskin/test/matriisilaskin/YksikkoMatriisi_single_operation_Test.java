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
public class YksikkoMatriisi_single_operation_Test {
    
    public YksikkoMatriisi_single_operation_Test() {
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
     * Test of matrix method, of class YksikkoMatriisi.
     */
    @Test
    public void testMatrix() {
        System.out.println("matrix");
        YksikkoMatriisi instance = new YksikkoMatriisi(3);
        double[][] expResult = new double[][]{
            {1,0,0},
            {0,1,0},
            {0,0,1}
        };
        double[][] result = instance.matrix();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of width method, of class YksikkoMatriisi.
     */
    @Test
    public void testWidth() {
        System.out.println("width");
        YksikkoMatriisi instance = new YksikkoMatriisi(3);
        int expResult = 3;
        int result = instance.width();
        assertEquals(expResult, result);
    }

    /**
     * Test of height method, of class YksikkoMatriisi.
     */
    @Test
    public void testHeight() {
        System.out.println("height");
        YksikkoMatriisi instance = new YksikkoMatriisi(4);
        int expResult = 4;
        int result = instance.height();
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class YksikkoMatriisi.
     */
    @Test
    public void testGet1() throws Exception {
        System.out.println("get");
        int i = 3;
        int j = 3;
        YksikkoMatriisi instance = new YksikkoMatriisi(5);
        double expResult = 1;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
    }
    /**
     * Test of get method, of class YksikkoMatriisi.
     */
    @Test
    public void testGet2() throws Exception {
        System.out.println("get");
        int i = 1;
        int j = 3;
        YksikkoMatriisi instance = new YksikkoMatriisi(5);
        double expResult = 0;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
    }
    /**
     * Test of opposite method, of class YksikkoMatriisi.
     */
    @Test
    public void testOpposite() {
        System.out.println("opposite");
        YksikkoMatriisi instance = new YksikkoMatriisi(6);
        TavallinenNeliomatriisi expResult = new TavallinenNeliomatriisi(new double[][]{
            {-1,0,0,0,0,0},
            {0,-1,0,0,0,0},
            {0,0,-1,0,0,0},
            {0,0,0,-1,0,0},
            {0,0,0,0,-1,0},
            {0,0,0,0,0,-1}
        });
        AbstraktiMatriisi result = instance.opposite();
        assertEquals(expResult, result);
    }

    /**
     * Test of transpose method, of class YksikkoMatriisi.
     */
    @Test
    public void testTranspose() {
        System.out.println("transpose");
        YksikkoMatriisi instance = new YksikkoMatriisi(7);
        AbstraktiMatriisi expResult = instance;
        AbstraktiMatriisi result = instance.transpose();
        assertEquals(expResult, result);
    }

    /**
     * Test of determinant method, of class YksikkoMatriisi.
     */
    @Test
    public void testDeterminant() {
        System.out.println("determinant");
        YksikkoMatriisi instance = new YksikkoMatriisi(8);
        double expResult = 1;
        double result = instance.determinant();
        assertEquals(expResult, result, 0.0);
    }
    
}
