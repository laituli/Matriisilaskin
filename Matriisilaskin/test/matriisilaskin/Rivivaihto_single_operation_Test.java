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
public class Rivivaihto_single_operation_Test {

    public Rivivaihto_single_operation_Test() {
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
     * Test of getRowA method, of class Rivivaihto.
     */
    @Test
    public void testGetRowSmallerIndex() {
        System.out.println("getRowA");
        Rivivaihto instance = new Rivivaihto(2, 1, 0);
        int expResult = 0;
        int result = instance.getRowSmallerIndex();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRowB method, of class Rivivaihto.
     */
    @Test
    public void testGetRowGreaterIndex() {
        System.out.println("getRowB");
        Rivivaihto instance = new Rivivaihto(3, 2, 1);
        int expResult = 2;
        int result = instance.getRowGreaterIndex();
        assertEquals(expResult, result);
    }

    /**
     * Test of matrix method, of class Rivivaihto.
     */
    @Test
    public void testMatrix() {
        System.out.println("matrix");
        Rivivaihto instance = new Rivivaihto(4, 3, 2);
        double[][] expResult = new double[][]{
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 1},
            {0, 0, 1, 0}
        };
        double[][] result = instance.matrix();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of get method, of class Rivivaihto.
     */
    @Test
    public void testGet1() throws Exception {
        System.out.println("get");
        int i = 1;
        int j = 1;
        Rivivaihto instance = new Rivivaihto(5, 4, 3);
        double expResult = 1;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of get method, of class Rivivaihto.
     */
    @Test
    public void testGet2() throws Exception {
        System.out.println("get");
        int i = 1;
        int j = 0;
        Rivivaihto instance = new Rivivaihto(5, 4, 3);
        double expResult = 0;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of get method, of class Rivivaihto.
     */
    @Test
    public void testGet3() throws Exception {
        System.out.println("get");
        int i = 4;
        int j = 4;
        Rivivaihto instance = new Rivivaihto(5, 4, 3);
        double expResult = 0;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of get method, of class Rivivaihto.
     */
    @Test
    public void testGet4() throws Exception {
        System.out.println("get");
        int i = 3;
        int j = 4;
        Rivivaihto instance = new Rivivaihto(5, 4, 3);
        double expResult = 1;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
    }

   
    /**
     * Test of opposite method, of class Rivivaihto.
     */
    @Test
    public void testOpposite() {
        System.out.println("opposite");
        Rivivaihto instance = new Rivivaihto(5, 1, 2);
        TavallinenNeliomatriisi expResult = new TavallinenNeliomatriisi(new double[][]{
            {-1,0,0,0,0},
            {0,0,-1,0,0},
            {0,-1,0,0,0},
            {0,0,0,-1,0},
            {0,0,0,0,-1}
        });
        AbstraktiMatriisi result = instance.opposite();
        assertEquals(expResult, result);
    }

    /**
     * Test of transpose method, of class Rivivaihto.
     */
    @Test
    public void testTranspose() {
        System.out.println("transpose");
        Rivivaihto instance = new Rivivaihto(6, 4, 3);
        AbstraktiMatriisi expResult = instance;
        AbstraktiMatriisi result = instance.transpose();
        assertEquals(expResult, result);
    }

    /**
     * Test of determinant method, of class Rivivaihto.
     */
    @Test
    public void testDeterminant() {
        System.out.println("determinant");
        Rivivaihto instance = new Rivivaihto(9, 8, 7);
        double expResult = -1;
        double result = instance.determinant();
        assertEquals(expResult, result, 0.0);
    }

}
