/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskin;

/**
 *
 * @author Laituli
 */
public class TavallinenNeliomatriisi extends AbstraktiMatriisi implements Neliomatriisi {

    private double[][] matriisi;

    /**
     *
     * @param matriisi matriisin sisällöt
     */
    public TavallinenNeliomatriisi(double[][] matriisi) {
        this.matriisi = Matriisilaskin.copy(matriisi);
    }

    @Override
    public int width() {
        return matriisi[0].length;
    }

    @Override
    public int height() {
        return matriisi.length;
    }

    @Override
    public double get(int i, int j) throws MatriisiException.KelvotonIndeksi {
        try {
            return matriisi[i][j];
        } catch (IndexOutOfBoundsException e) {
            throw MatriisiException.kelvotonIndeksi();
        }
    }

    @Override
    public AbstraktiMatriisi opposite() {
        double[][] oppo = new double[height()][width()];
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                oppo[i][j] = -matriisi[i][j];
            }
        }
        return new TavallinenNeliomatriisi(oppo);
    }

    @Override
    public double[][] matrix() {
        return Matriisilaskin.copy(matriisi);
    }

    @Override
    public AbstraktiMatriisi transpose() {
        double[][] matrixt = new double[width()][height()];
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                matrixt[j][i] = matriisi[i][j];
            }
        }
        return new TavallinenNeliomatriisi(matrixt);
    }

    @Override
    public double determinant() {
        return bruteforce_recursive_determinant(matriisi);
    }

    //bruteforce rekursiivinen algorithm
    private static double bruteforce_recursive_determinant(double[][] mat) {
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
