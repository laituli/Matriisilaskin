/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmit_ja_tyokalut;

/**
 *
 * @author Laituli
 */
public class DeterminanttiBrute {
    public static double bruteforce_recursive_determinant(double[][] mat) {
        if (mat.length == 1) {
            return mat[0][0];
        }
        double det = 0;
        for (int i = 0; i < mat.length; i++) {
            double[][] m = new double[mat.length - 1][mat.length - 1];
            for (int j = 1; j < mat.length; j++) {
                int k = 0;
                for (int l = 0; l < mat.length; l++) {
                    if (i == l) {
                        continue;
                    }
                    m[j - 1][k] = mat[j][l];
                    k++;
                }
            }
            det += (i%2==0?1:-1)* mat[0][i] * bruteforce_recursive_determinant(m);
        }
        return det;
    }
}
