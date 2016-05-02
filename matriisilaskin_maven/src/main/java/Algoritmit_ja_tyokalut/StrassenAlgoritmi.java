/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmit_ja_tyokalut;

/**
 * raja
 *
 * @author Laituli
 */
public class StrassenAlgoritmi {

    //a[0].length == b.length
    public static double[][] dot(double[][] a, double[][] b) {
        // n is mininum integer power of 2 that n >= all size of a and b
        int n = Math.max(Math.max(a[0].length, a.length), b[0].length);
        int l = 0;
        while (n > 1) {
            n = n - n / 2;
            l++;
        }
        while (l > 0) {
            n *= 2;
            l--;
        }
        // fill a and b with 0
        double[][] a0 = new double[n][n];
        double[][] b0 = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a0[i][j] = i < a.length && j < a[0].length ? a[i][j] : 0;
                b0[i][j] = i < b.length && j < b[0].length ? b[i][j] : 0;
            }
        }

        // calculate
        double[][] c0 = strassenMultiplication(a0, b0, n);

        // return to right size
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                c[i][j] = c0[i][j];
            }
        }
        return c;
    }

    private static double[][] strassenMultiplication(double[][] a, double[][] b, int n) {
        // limit case
        if (n == 1) {
            return new double[][]{{a[0][0] * b[0][0]}};
        }

        // partition and plus, minus operations
        int n2 = n / 2;
        double[][] a11 = new double[n2][n2];
        double[][] a22 = new double[n2][n2];
        double[][] b11 = new double[n2][n2];
        double[][] b22 = new double[n2][n2];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n2; j++) {
                a11[i][j] = a[i][j];
                b11[i][j] = b[i][j];
                a22[i][j] = a[n2 + i][n2 + j];
                b22[i][j] = b[n2 + i][n2 + j];
            }
        }
        //  0 at index 1 
        // n2 at index 2
        double[][] m1a = plus(a, a, 0, 0, n2, n2, n2);
        double[][] m1b = plus(b, b, 0, 0, n2, n2, n2);
        double[][] m2a = plus(a, a, n2, 0, n2, n2, n2);
        double[][] m2b = b11;
        double[][] m3a = a11;
        double[][] m3b = minus(b, b, 0, n2, n2, n2, n2);
        double[][] m4a = a22;
        double[][] m4b = minus(b, b, n2, 0, 0, 0, n2);
        double[][] m5a = plus(a, a, 0, 0, 0, n2, n2);
        double[][] m5b = b22;
        double[][] m6a = minus(a, a, n2, 0, 0, 0, n2);
        double[][] m6b = plus(b, b, 0, 0, 0, n2, n2);
        double[][] m7a = minus(a, a, 0, n2, n2, n2, n2);
        double[][] m7b = plus(b, b, n2, 0, n2, n2, n2);

        //recurse
        double[][] m1 = strassenMultiplication(m1a, m1b, n2);
        double[][] m2 = strassenMultiplication(m2a, m2b, n2);
        double[][] m3 = strassenMultiplication(m3a, m3b, n2);
        double[][] m4 = strassenMultiplication(m4a, m4b, n2);
        double[][] m5 = strassenMultiplication(m5a, m5b, n2);
        double[][] m6 = strassenMultiplication(m6a, m6b, n2);
        double[][] m7 = strassenMultiplication(m7a, m7b, n2);

        //merge
        double[][] c = new double[n][n];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n2; j++) {
                c[i][j] = m1[i][j] + m4[i][j] - m5[i][j] + m7[i][j];
                c[i][n2 + j] = m3[i][j] + m5[i][j];
                c[n2 + i][j] = m2[i][j] + m4[i][j];
                c[n2 + i][n2 + j] = m1[i][j] - m2[i][j] + m3[i][j] + m6[i][j];
            }
        }
        return c;
    }

    private static double[][] plus(double[][] a, double[][] b, int ai, int aj, int bi, int bj, int n) {
        double[][] p = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = a[ai + i][aj + j] + b[bi + i][bj + j];
            }
        }
        return p;
    }

    private static double[][] minus(double[][] a, double[][] b, int ai, int aj, int bi, int bj, int n) {
        double[][] m = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = a[ai + i][aj + j] - b[bi + i][bj + j];
            }
        }
        return m;
    }
}
