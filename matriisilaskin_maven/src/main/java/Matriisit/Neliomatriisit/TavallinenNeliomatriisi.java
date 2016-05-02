/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriisit.Neliomatriisit;


import Algoritmit_ja_tyokalut.DeterminanttiBrute;
import Algoritmit_ja_tyokalut.Metodit;

import Matriisit.*;

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
        this.matriisi = Metodit.kopioi(matriisi);
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
        return Metodit.kopioi(matriisi);
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
        return DeterminanttiBrute.bruteforce_recursive_determinant(matriisi);
    }

    //bruteforce rekursiivinen algorithm
    

}
