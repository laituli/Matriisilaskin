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
public class RiviKerta_single_operation_Test {

    public RiviKerta_single_operation_Test() {
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
     * Test of getRow method, of class RiviKerta.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        RiviKerta instance = new RiviKerta(2, 1, 3);
        int expResult = 1;
        int result = instance.getRow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCoef method, of class RiviKerta.
     */
    @Test
    public void testGetCoef() {
        System.out.println("getCoef");
        RiviKerta instance = new RiviKerta(2, 1, 3);
        int expResult = 3;
        double result = instance.getCoef();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of matrix method, of class RiviKerta.
     */
    @Test
    public void testMatrix() {
        System.out.println("matrix");
        RiviKerta instance = new RiviKerta(2, 1, 3);
        double[][] expResult = new double[][]{
            {1, 0},
            {0, 3}
        };
        double[][] result = instance.matrix();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of get method, of class RiviKerta.
     */
    @Test
    public void testGet1() throws Exception {
        System.out.println("get");
        int i = 0;
        int j = 0;
        RiviKerta instance = new RiviKerta(2, 1, 3);
        double expResult = 1;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of get method, of class RiviKerta.
     */
    @Test
    public void testGet2() throws Exception {
        System.out.println("get");
        int i = 1;
        int j = 1;
        RiviKerta instance = new RiviKerta(2, 1, 3);
        double expResult = 3;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of get method, of class RiviKerta.
     */
    @Test
    public void testGet3() throws Exception {
        System.out.println("get");
        int i = 1;
        int j = 0;
        RiviKerta instance = new RiviKerta(2, 1, 3);
        double expResult = 0;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of opposite method, of class RiviKerta.
     */
    @Test
    public void testOpposite() {
        System.out.println("opposite");
        RiviKerta instance = new RiviKerta(2, 1, 3);
        TavallinenNeliomatriisi expResult = new TavallinenNeliomatriisi(new double[][]{
            {-1, 0},
            {0, -3}
        });
        AbstraktiMatriisi result = instance.opposite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of transpose method, of class RiviKerta.
     */
    @Test
    public void testTranspose() {
        System.out.println("transpose");
        RiviKerta instance = new RiviKerta(2, 1, 3);
        AbstraktiMatriisi expResult = instance;
        AbstraktiMatriisi result = instance.transpose();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of determinant method, of class RiviKerta.
     */
    @Test
    public void testDeterminant() {
        System.out.println("determinant");
        RiviKerta instance = new RiviKerta(2, 1, 3);
        double expResult = 3;
        double result = instance.determinant();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

}
