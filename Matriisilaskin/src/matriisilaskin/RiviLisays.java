/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskin;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laituli
 */
public class RiviLisays extends Alkeismatriisi {

    //a+=bk

    int a, b, k;

    public RiviLisays(int a, int b, int k) throws MatriisiException.KelvotonIndeksi {
        if (a == b) {
            throw MatriisiException.kelvotonIndeksi();
        }
        this.a = a;
        this.b = b;
        this.k = k;
    }

    public int getRowTo() {
        return a;
    }

    public int getRowFrom() {
        return b;
    }

    public int getCoef() {
        return k;
    }

    @Override
    public double[][] matrix() {
        double[][] mat = new double[d][d];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                mat[i][j] = 0;
            }
        }
        for (int i = 0; i < d; i++) {
            mat[i][i] = 1;
        }
        mat[a][b] = k;
        return mat;
    }

    @Override
    public double get(int i, int j) throws MatriisiException.KelvotonIndeksi {
        if (i == j) {
            return 1;
        }
        if (a == i && b == j) {
            return k;
        }
        return 0;
    }

    @Override
    public AbstraktiMatriisi addition(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        if (width() != toinen.width() && height() != toinen.height()) {
            throw MatriisiException.vaaraKokoinenMatriisi();
        }
        double[][] mat = toinen.matrix();
        mat[a][b]+=k;
        for (int i = 0; i < d; i++) {
            mat[i][i]++;
        }
        return new TavallinenNeliomatriisi(mat);
    }

    @Override
    public AbstraktiMatriisi substract(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        return addition(toinen.opposite());
    }

    @Override
    protected AbstraktiMatriisi substract_mirrored(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        if (width() != toinen.width() && height() != toinen.height()) {
            throw MatriisiException.vaaraKokoinenMatriisi();
        }
        double[][] mat = toinen.matrix();
        mat[a][b]-=k;
        for (int i = 0; i < d; i++) {
            mat[i][i]--;
        }
        return new TavallinenNeliomatriisi(mat);
    }
    
    

    @Override
    public AbstraktiMatriisi dot(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        if (d != toinen.height()) {
            throw MatriisiException.vaaraKokoinenMatriisi();
        }
        double[][] mat = toinen.matrix();
        for (int i = 0; i < toinen.width(); i++) {
            mat[a][i] += k * mat[b][i];
        }
        return toinen.width() == toinen.height() ? new TavallinenNeliomatriisi(mat) : new TavallinenMatriisi(mat);
    }

    @Override
    protected AbstraktiMatriisi dot_mirrored(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        if (d != toinen.height()) {
            throw MatriisiException.vaaraKokoinenMatriisi();
        }
        double[][] mat = toinen.matrix();
        for (int i = 0; i < toinen.width(); i++) {
            mat[i][b] += k * mat[i][a];
        }
        return toinen.width() == toinen.height() ? new TavallinenNeliomatriisi(mat) : new TavallinenMatriisi(mat);
    }
    
    

    @Override
    public AbstraktiMatriisi opposite() {
        double[][] mat = new double[d][d];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                mat[i][j] = 0;
            }
        }
        for (int i = 0; i < d; i++) {
            mat[i][i] = -1;
        }
        mat[a][b] = -k;
        return new TavallinenNeliomatriisi(mat);
    }

    @Override
    public AbstraktiMatriisi transpose() {
        try {
            return new RiviLisays(b, a, k);
        } catch (MatriisiException.KelvotonIndeksi ex) {
            return null;
        }
    }

    @Override
    public double determinant() {
        return 1;
    }

}
