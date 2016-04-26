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
public class TavallinenNeliomatriisi_single_operation_Test {

    public TavallinenNeliomatriisi_single_operation_Test() {
    }
    static TavallinenNeliomatriisi mat1 = new TavallinenNeliomatriisi(new double[][]{
        {1, 3, 9},
        {27, 81, 243},
        {729, 2187, 6561}
    });
    static TavallinenNeliomatriisi mat2 = new TavallinenNeliomatriisi(new double[][]{
        {1, 2, 8, 64},
        {2, 4, 16, 128},
        {8, 16, 32, 256},
        {64, 128, 256, 512}
    });

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
     * Test of width method, of class TavallinenMatriisi.
     */
    @Test
    public void testWidth1() {
        System.out.println("width");
        TavallinenNeliomatriisi instance = mat1;
        int expResult = 3;
        int result = instance.width();
        assertEquals(expResult, result);
    }

    /**
     * Test of height method, of class TavallinenMatriisi.
     */
    @Test
    public void testHeight1() {
        System.out.println("height");
        TavallinenNeliomatriisi instance = mat1;
        int expResult = 3;
        int result = instance.height();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of get method, of class TavallinenMatriisi.
     */
    @Test
    public void testGet1() throws Exception {
        System.out.println("get");
        int i = 2;
        int j = 1;
        TavallinenNeliomatriisi instance = mat1;
        double expResult = 2187;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of opposite method, of class TavallinenMatriisi.
     */
    @Test
    public void testOpposite1() {
        System.out.println("opposite");
        TavallinenNeliomatriisi instance = mat1;
        TavallinenNeliomatriisi expResult = new TavallinenNeliomatriisi(new double[][]{
            {-1, -3, -9},
            {-27, -81, -243},
            {-729, -2187, -6561}
        });
        AbstraktiMatriisi result = instance.opposite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of matrix method, of class TavallinenMatriisi.
     */
    @Test
    public void testMatrix1() {
        System.out.println("matrix");
        TavallinenNeliomatriisi instance = mat1;
        double[][] expResult = new double[][]{
            {1, 3, 9},
            {27, 81, 243},
            {729, 2187, 6561}
        };
        double[][] result = instance.matrix();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of transpose method, of class TavallinenMatriisi.
     */
    @Test
    public void testTranspose1() {
        System.out.println("transpose");
        TavallinenNeliomatriisi instance = mat1;
        TavallinenMatriisi expResult = new TavallinenMatriisi(new double[][]{
        {1, 27, 729},
        {3, 81, 2187},
        {9, 243, 6561}
        });
        AbstraktiMatriisi result = instance.transpose();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of width method, of class TavallinenMatriisi.
     */
    @Test
    public void testWidth2() {
        System.out.println("width");
        TavallinenNeliomatriisi instance = mat2;
        int expResult = 4;
        int result = instance.width();
        assertEquals(expResult, result);
    }

    /**
     * Test of height method, of class TavallinenMatriisi.
     */
    @Test
    public void testHeight2() {
        System.out.println("height");
        TavallinenNeliomatriisi instance = mat2;
        int expResult = 4;
        int result = instance.height();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of get method, of class TavallinenMatriisi.
     */
    @Test
    public void testGet2() throws Exception {
        System.out.println("get");
        int i = 3;
        int j = 0;
        TavallinenNeliomatriisi instance = mat2;
        double expResult = 64;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of opposite method, of class TavallinenMatriisi.
     */
    @Test
    public void testOpposite2() {
        System.out.println("opposite");
        TavallinenNeliomatriisi instance = mat2;
        TavallinenMatriisi expResult = new TavallinenMatriisi(new double[][]{
            {-1, -2, -8, -64},
            {-2, -4, -16, -128},
            {-8, -16, -32, -256},
            {-64, -128, -256, -512}
        });
        AbstraktiMatriisi result = instance.opposite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of matrix method, of class TavallinenMatriisi.
     */
    @Test
    public void testMatrix2() {
        System.out.println("matrix");
        TavallinenNeliomatriisi instance = mat2;
        double[][] expResult = new double[][]{
            {1, 2, 8, 64},
            {2, 4, 16, 128},
            {8, 16, 32, 256},
            {64, 128, 256, 512}
        };
        double[][] result = instance.matrix();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of transpose method, of class TavallinenMatriisi.
     */
    @Test
    public void testTranspose2() {
        System.out.println("transpose");
        TavallinenNeliomatriisi instance = mat2;
        TavallinenNeliomatriisi expResult = mat2;
        AbstraktiMatriisi result = instance.transpose();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}
