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
public class Metodit {
    
    public static double[][] kopioi(double[][] matrix) {
        double[][] ret = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ret[i][j] = matrix[i][j];
            }
        }
        return ret;
    }
    
    public static void tulostaa(double[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
