/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatriisiTest.yhden_matriisin_operaatio;

import Matriisit.MatriisiException;
import Matriisit.Neliomatriisit.ErikoisetMatriisit.RiviLisays;
import Matriisit.Neliomatriisit.TavallinenNeliomatriisi;
import Matriisit.AbstraktiMatriisi;
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
public class RiviLisaysTest {

    public RiviLisaysTest() {
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
     * Test of getRowTo method, of class RiviLisays.
     */
    @Test
    public void testGetRowTo() throws MatriisiException.KelvotonIndeksi {
        System.out.println("getRowTo");
        RiviLisays instance = new RiviLisays(2, 1, 0, -1);
        int expResult = 1;
        int result = instance.getRowTo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRowFrom method, of class RiviLisays.
     */
    @Test
    public void testGetRowFrom() throws MatriisiException.KelvotonIndeksi {
        System.out.println("getRowFrom");
        RiviLisays instance = new RiviLisays(2, 1, 0, -1);
        int expResult = 0;
        int result = instance.getRowFrom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCoef method, of class RiviLisays.
     */
    @Test
    public void testGetCoef() {
        System.out.println("getCoef");
        RiviLisays instance = new RiviLisays(2, 1, 0, -1);
        int expResult = -1;
        double result = instance.getCoef();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of matrix method, of class RiviLisays.
     */
    @Test
    public void testMatrix() {
        System.out.println("matrix");
        RiviLisays instance = new RiviLisays(2, 1, 0, -1);
        double[][] expResult = new double[][]{
            {1, 0},
            {-1, 1}
        };
        double[][] result = instance.matrix();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of get method, of class RiviLisays.
     */
    @Test
    public void testGet1() throws Exception {
        System.out.println("get");
        int i = 4;
        int j = 4;
        RiviLisays instance = new RiviLisays(5, 4, 3, 2);
        double expResult = 1;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of get method, of class RiviLisays.
     */
    @Test
    public void testGet2() throws Exception {
        System.out.println("get");
        int i = 3;
        int j = 4;
        RiviLisays instance = new RiviLisays(5, 4, 3, 2);
        double expResult = 0;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of get method, of class RiviLisays.
     */
    @Test
    public void testGet3() throws Exception {
        System.out.println("get");
        int i = 4;
        int j = 3;
        RiviLisays instance = new RiviLisays(5, 4, 3, 2);
        double expResult = 2;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of opposite method, of class RiviLisays.
     */
    @Test
    public void testOpposite() {
        System.out.println("opposite");
        RiviLisays instance = new RiviLisays(5, 4, 3, 2);
        AbstraktiMatriisi expResult = new TavallinenNeliomatriisi(new double[][]{
            {-1, 0, 0, 0, 0},
            {0, -1, 0, 0, 0},
            {0, 0, -1, 0, 0},
            {0, 0, 0, -1, 0},
            {0, 0, 0, -2, -1},});
        AbstraktiMatriisi result = instance.opposite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of transpose method, of class RiviLisays.
     */
    @Test
    public void testTranspose() {
        System.out.println("transpose");
        RiviLisays instance = new RiviLisays(5, 4, 3, 2);
        AbstraktiMatriisi expResult = new RiviLisays(5, 3, 4, 2);
        AbstraktiMatriisi result = instance.transpose();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of determinant method, of class RiviLisays.
     */
    @Test
    public void testDeterminant() {
        System.out.println("determinant");
        RiviLisays instance = new RiviLisays(5, 4, 3, 2);
        double expResult = 1;
        double result = instance.determinant();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

}
