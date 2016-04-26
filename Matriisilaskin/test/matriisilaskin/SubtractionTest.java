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
public class SubtractionTest {

    public SubtractionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    private AbstraktiMatriisi[] mat33;
    private AbstraktiMatriisi[] mat34;
    private AbstraktiMatriisi[] mat44;

    @Before
    public void setUp() {
        mat33 = new AbstraktiMatriisi[5];
        double[][] mat = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mat[i][j] = i * 3 + j;
            }
        }
        mat33[0] = new TavallinenMatriisi(mat);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mat[i][j] = i * j + j;
            }
        }
        mat33[1] = new TavallinenNeliomatriisi(mat);
        mat33[2] = new YksikkoMatriisi(3);
        mat33[3] = new RiviKerta(3, 1, 2);
        mat33[4] = new RiviLisays(3, 1, 2, 3);

        mat34 = new AbstraktiMatriisi[2];
        mat = new double[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                mat[i][j] = 1;
            }
        }
        mat34[0] = new TavallinenMatriisi(mat);
        mat = new double[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                mat[i][j] = i == j ? 1 : 0;
            }
        }
        mat34[1] = new TavallinenMatriisi(mat);

        mat44 = new AbstraktiMatriisi[3];
        mat = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mat[i][j] = -i * 4 - j;
            }
        }
        mat44[0] = new TavallinenMatriisi(mat);
        mat = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mat[i][j] = i;
            }
        }
        mat44[1] = new TavallinenNeliomatriisi(mat);
        mat44[2] = new Rivivaihto(4, 3, 2);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addition method, of class TavallinenMatriisi.
     */
    @Test
    public void testSubtraction33() throws Exception {
        System.out.println("subtraction33");
        for (int i = 0; i < mat33.length; i++) {
            for (int j = 0; j < mat33.length; j++) {
                double[][] result = mat33[i].subtract(mat33[j]).matrix();
                double[][] exp = new double[3][3];
                double[][] a = mat33[i].matrix();
                double[][] b = mat33[j].matrix();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        exp[k][l] = a[k][l] - b[k][l];
                    }
                }
                if(i==0&&j==2){
                    Matriisilaskin.print_matrix(a);
                    Matriisilaskin.print_matrix(b);
                    Matriisilaskin.print_matrix(exp);
                    Matriisilaskin.print_matrix(result);
                }
                for (int k = 0; k < 3; k++) {
                    assertArrayEquals(exp[k], result[k],0.001);
                }
                System.out.println(i + " " + j + " pass");
            }
        }
    }

    /**
     * Test of addition method, of class TavallinenMatriisi.
     */
    @Test
    public void testSubtraction34() throws Exception {
        System.out.println("subtraction34");
        for (int i = 0; i < mat34.length; i++) {
            for (int j = 0; j < mat34.length; j++) {
                double[][] result = mat34[i].subtract(mat34[j]).matrix();
                double[][] exp = new double[3][4];
                double[][] a = mat34[i].matrix();
                double[][] b = mat34[j].matrix();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 4; l++) {
                        exp[k][l] = a[k][l] - b[k][l];
                    }
                }
                for (int k = 0; k < 3; k++) {
                    assertArrayEquals(exp[k], result[k],0.001);
                }
                System.out.println(i + " " + j + " pass");
            }
        }
    }

    /**
     * Test of addition method, of class TavallinenMatriisi.
     */
    @Test
    public void testSubtraction44() throws Exception {
        System.out.println("subtraction44");
        for (int i = 0; i < mat44.length; i++) {
            for (int j = 0; j < mat44.length; j++) {
                double[][] result = mat44[i].subtract(mat44[j]).matrix();
                double[][] exp = new double[4][4];
                double[][] a = mat44[i].matrix();
                double[][] b = mat44[j].matrix();
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        exp[k][l] = a[k][l] - b[k][l];
                    }
                }
                for (int k = 0; k < 4; k++) {
                    assertArrayEquals(exp[k], result[k], 0.001);
                }
                System.out.println(i + " " + j + " pass");
            }
        }
    }

    /**
     * Test of addition method, of class TavallinenMatriisi.
     */
    @Test
    public void testSubtration3334() throws Exception {
        System.out.println("subtraction3334");
        for (int i = 0; i < mat33.length; i++) {
            for (int j = 0; j < mat34.length; j++) {
                try {
                    mat33[i].subtract(mat34[j]);
                    System.out.println("3334[" + i + "]-[" + j + "] failed");
                    fail("expected exception");
                } catch (MatriisiException.VaaraKokoinenMatriisi e) {
                }
                try {
                    mat34[j].subtract(mat33[i]);
                    System.out.println("3334[" + i + "]-[" + j + "] mirrored failed");
                    fail("expected exception");
                } catch (MatriisiException.VaaraKokoinenMatriisi e) {
                }
            }
        }
    }

    /**
     * Test of addition method, of class TavallinenMatriisi.
     */
    @Test
    public void testsubtraction3344() throws Exception {
        System.out.println("subtraction3344");
        for (int i = 0; i < mat33.length; i++) {
            for (int j = 0; j < mat44.length; j++) {
                try {
                    mat33[i].subtract(mat44[j]);
                    fail("expected exception");
                    System.out.println("3344[" + i + "]-[" + j + "] failed");
                } catch (MatriisiException.VaaraKokoinenMatriisi e) {
                }
                try {
                    mat44[j].subtract(mat33[i]);
                    System.out.println("3334[" + i + "]-[" + j + "] mirrored failed");
                    fail("expected exception");
                } catch (MatriisiException.VaaraKokoinenMatriisi e) {
                }
            }
        }
    }

    /**
     * Test of addition method, of class TavallinenMatriisi.
     */
    @Test
    public void testSubtract3444() throws Exception {
        System.out.println("subtract3444");
        for (int i = 0; i < mat34.length; i++) {
            for (int j = 0; j < mat44.length; j++) {
                try {
                    mat34[i].subtract(mat44[j]);
                    System.out.println("3444[" + i + "]-[" + j + "] failed");
                    fail("expected exception");
                } catch (MatriisiException.VaaraKokoinenMatriisi e) {
                    continue;
                }
                try {
                    mat44[j].subtract(mat34[i]);
                    System.out.println("3444[" + i + "]-[" + j + "] failed");
                    fail("expected exception");
                } catch (MatriisiException.VaaraKokoinenMatriisi e) {
                    continue;
                }
            }
        }
    }

}
