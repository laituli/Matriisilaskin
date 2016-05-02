/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatriisiTest.yhden_matriisin_operaatio;

import Matriisit.TavallinenMatriisi;
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
public class TavallinenMatriisiTest {

    public TavallinenMatriisiTest() {
    }
    static TavallinenMatriisi mat1 = new TavallinenMatriisi(new double[][]{
        {1, 2, 3},
        {3, 4, 5},
        {5, 7, 9}
    });
    static TavallinenMatriisi mat2 = new TavallinenMatriisi(new double[][]{
        {1, 2},
        {3, 4},
        {5, 7},
        {6, 0}
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
        TavallinenMatriisi instance = mat1;
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
        TavallinenMatriisi instance = mat1;
        int expResult = 3;
        int result = instance.height();
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class TavallinenMatriisi.
     */
    @Test
    public void testGet1() throws Exception {
        System.out.println("get");
        int i = 2;
        int j = 1;
        TavallinenMatriisi instance = mat1;
        double expResult = 7;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of opposite method, of class TavallinenMatriisi.
     */
    @Test
    public void testOpposite1() {
        System.out.println("opposite");
        TavallinenMatriisi instance = mat1;
        TavallinenMatriisi expResult = new TavallinenMatriisi(new double[][]{
            {-1, -2, -3},
            {-3, -4, -5},
            {-5, -7, -9}
        });
        AbstraktiMatriisi result = instance.opposite();
        assertEquals(expResult, result);
    }

    /**
     * Test of matrix method, of class TavallinenMatriisi.
     */
    @Test
    public void testMatrix1() {
        System.out.println("matrix");
        TavallinenMatriisi instance = mat1;
        double[][] expResult = new double[][]{
            {1, 2, 3},
            {3, 4, 5},
            {5, 7, 9}
        };
        double[][] result = instance.matrix();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of transpose method, of class TavallinenMatriisi.
     */
    @Test
    public void testTranspose1() {
        System.out.println("transpose");
        TavallinenMatriisi instance = mat1;
        TavallinenMatriisi expResult = new TavallinenMatriisi(new double[][]{
            {1, 3, 5},
            {2, 4, 7},
            {3, 5, 9}
        });
        AbstraktiMatriisi result = instance.transpose();
        assertEquals(expResult, result);
    }

    /**
     * Test of width method, of class TavallinenMatriisi.
     */
    @Test
    public void testWidth2() {
        System.out.println("width");
        TavallinenMatriisi instance = mat2;
        int expResult = 2;
        int result = instance.width();
        assertEquals(expResult, result);
    }

    /**
     * Test of height method, of class TavallinenMatriisi.
     */
    @Test
    public void testHeight2() {
        System.out.println("height");
        TavallinenMatriisi instance = mat2;
        int expResult = 4;
        int result = instance.height();
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class TavallinenMatriisi.
     */
    @Test
    public void testGet2() throws Exception {
        System.out.println("get");
        int i = 3;
        int j = 0;
        TavallinenMatriisi instance = mat2;
        double expResult = 6;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of opposite method, of class TavallinenMatriisi.
     */
    @Test
    public void testOpposite2() {
        System.out.println("opposite");
        TavallinenMatriisi instance = mat2;
        TavallinenMatriisi expResult = new TavallinenMatriisi(new double[][]{
            {-1, -2},
            {-3, -4},
            {-5, -7},
            {-6, -0}
        });
        AbstraktiMatriisi result = instance.opposite();
        assertEquals(expResult, result);
    }

    /**
     * Test of matrix method, of class TavallinenMatriisi.
     */
    @Test
    public void testMatrix2() {
        System.out.println("matrix");
        TavallinenMatriisi instance = mat2;
        double[][] expResult = new double[][]{
            {1, 2},
            {3, 4},
            {5, 7},
            {6, 0}
        };
        double[][] result = instance.matrix();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of transpose method, of class TavallinenMatriisi.
     */
    @Test
    public void testTranspose2() {
        System.out.println("transpose");
        TavallinenMatriisi instance = mat2;
        TavallinenMatriisi expResult = new TavallinenMatriisi(new double[][]{
            {1, 3, 5, 6},
            {2, 4, 7, 0}
        });
        AbstraktiMatriisi result = instance.transpose();
        assertEquals(expResult, result);
    }

}
