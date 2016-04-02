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
public class TavallinenMatriisiTest {

    public TavallinenMatriisiTest() {
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
     * Test of width method, of class TavallinenMatriisi.
     */
    @Test
    public void testWidth() {
        System.out.println("width");
        TavallinenMatriisi instance = new TavallinenMatriisi(new double[][]{
            {1,2,3,4,5},
            {1,2,3,4,5},
            {1,2,3,4,5}
        });
        int expResult = 5;
        int result = instance.width();
        assertEquals(expResult, result);
    }

    /**
     * Test of height method, of class TavallinenMatriisi.
     */
    @Test
    public void testHeight() {
        System.out.println("height");
        TavallinenMatriisi instance = new TavallinenMatriisi(new double[][]{
            {1,2,3,4,5},
            {1,2,3,4,5},
            {1,2,3,4,5}
        });
        int expResult = 3;
        int result = instance.height();
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class TavallinenMatriisi.
     */
    @Test
    public void testGet_1() throws Exception {
        System.out.println("get 1");
        int i = 2;
        int j = 3;
        TavallinenMatriisi instance = new TavallinenMatriisi(new double[][]{
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15}
        });
        double expResult = 14;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
    }
    /**
     * Test of get method, of class TavallinenMatriisi.
     */
    @Test
    public void testGet_2() throws Exception {
        System.out.println("get 2");
        int i = 3;
        int j = 5;
        TavallinenMatriisi instance = new TavallinenMatriisi(new double[][]{
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15}
        });
        try{
            instance.get(i, j);
        }catch(MatriisiException.KelvotonIndeksi e){
            return;
        }
        fail("none exception throwed");
    }

    
    /**
     * Test of addition method, of class TavallinenMatriisi.
     */
    @Test
    public void testAddition() throws Exception {
        System.out.println("addition");
        double[][] toi=new double[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                toi[i][j]=i*j;
            }
        }
        double[][] ins=new double[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                ins[i][j]=i+j;
            }
        }
        double[][] res=new double[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                res[i][j]=i*j+i+j;
            }
        }
        AbstraktiMatriisi toinen = new TavallinenMatriisi(toi);
        TavallinenMatriisi instance = new TavallinenMatriisi(ins);
        AbstraktiMatriisi expResult = new TavallinenMatriisi(res);
        AbstraktiMatriisi result = instance.addition(toinen);
        assertEquals(expResult, result);
    }

    /**
     * Test of substract method, of class TavallinenMatriisi.
     */
    @Test
    public void testSubstract() throws Exception {
        System.out.println("substract");
        double[][] toi=new double[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                toi[i][j]=i*j;
            }
        }
        double[][] ins=new double[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                ins[i][j]=i+j;
            }
        }
        double[][] res=new double[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                res[i][j]=i+j-i*j;
            }
        }
        AbstraktiMatriisi toinen = new TavallinenMatriisi(toi);
        TavallinenMatriisi instance = new TavallinenMatriisi(ins);
        AbstraktiMatriisi expResult = new TavallinenMatriisi(res);
        AbstraktiMatriisi result = instance.substract(toinen);
        assertEquals(expResult, result);
    }

    /**
     * Test of mult method, of class TavallinenMatriisi.
     */
    @Test
    public void testDot() throws Exception {
        System.out.println("dot");
        double[][] toi=new double[5][7];
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 7; k++) {
                toi[i][k]=i*k;
            }
        }
        double[][] ins=new double[3][5];
        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < 5; j++) {
                ins[k][j]=k+j;
            }
        }
        double[][] res=new double[3][7];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                int s = 0;
                for(int k=0;k<5;k++){
                    s+=i*k*(k+j);
                }
                res[i][j]=s;
            }
        }
        
        AbstraktiMatriisi toinen = new TavallinenMatriisi(toi);
        TavallinenMatriisi instance = new TavallinenMatriisi(ins);
        AbstraktiMatriisi expResult = new TavallinenMatriisi(res);
        AbstraktiMatriisi result = instance.dot(toinen);
        assertEquals(expResult, result);
    }

    /**
     * Test of opposite method, of class TavallinenMatriisi.
     */
    @Test
    public void testOpposite_1() {
        System.out.println("opposite");
        double[][] ins=new double[4][6];
        double[][] res=new double[4][6];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                ins[i][j]=i*j;
                res[i][j]=-i*j;
            }
        }
        TavallinenMatriisi instance = new TavallinenMatriisi(ins);
        AbstraktiMatriisi expResult = new TavallinenMatriisi(res);
        AbstraktiMatriisi result = instance.opposite();
        assertEquals(expResult, result);
    }/**
     * Test of opposite method, of class TavallinenMatriisi.
     */
    @Test
    public void testOpposite_2() {
        System.out.println("opposite opposite");
        double[][] ins=new double[4][6];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                ins[i][j]=i*j;
            }
        }
        TavallinenMatriisi instance = new TavallinenMatriisi(ins);
        AbstraktiMatriisi expResult = new TavallinenMatriisi(ins);
        AbstraktiMatriisi result = instance.opposite().opposite();
        assertEquals(expResult, result);
    }

    /**
     * Test of substract_opposite method, of class TavallinenMatriisi.
     */
    @Test
    public void testSubstract_opposite() throws Exception {
        System.out.println("substract_opposite");
        double[][] toi= new double[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                toi[i][j]=i*j;
            }
        }
        double[][] ins=new double[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                ins[i][j]=i+j;
            }
        }
        AbstraktiMatriisi toinen =new TavallinenMatriisi(toi);
        TavallinenMatriisi instance = new TavallinenMatriisi(ins);
        AbstraktiMatriisi expResult = toinen.substract(instance).opposite();
        AbstraktiMatriisi result = instance.substract_mirrored(toinen);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testWrongSize_1() throws Exception{
        System.out.println("wrong operation size 1");
        double[][] toi= new double[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                toi[i][j]=i*j;
            }
        }
        double[][] ins=new double[5][3];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                ins[i][j]=i+j;
            }
        }
        AbstraktiMatriisi toinen =new TavallinenMatriisi(toi);
        TavallinenMatriisi instance = new TavallinenMatriisi(ins);
        try {
            instance.addition(toinen);
        } catch (MatriisiException.VaaraKokoinenMatriisi e) {
            return;
        }
        fail("none exception get");
    }
    @Test
    public void testWrongSize_2() throws Exception{
        System.out.println("wrong operation size 2");
        double[][] toi= new double[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                toi[i][j]=i*j;
            }
        }
        double[][] ins=new double[5][3];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                ins[i][j]=i+j;
            }
        }
        AbstraktiMatriisi toinen =new TavallinenMatriisi(toi);
        TavallinenMatriisi instance = new TavallinenMatriisi(ins);
        try {
            instance.substract(toinen);
        } catch (MatriisiException.VaaraKokoinenMatriisi e) {
            return;
        }
        fail("none exception get");
    }
    @Test
    public void testWrongSize_3() throws Exception{
        System.out.println("wrong operation size 2");
        double[][] ins= new double[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                ins[i][j]=i*j;
            }
        }
        TavallinenMatriisi instance = new TavallinenMatriisi(ins);
        try {
            instance.dot(instance);
        } catch (MatriisiException.VaaraKokoinenMatriisi e) {
            return;
        }
        fail("none exception get");
    }
}
