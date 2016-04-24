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
public class RiviKerta extends Alkeismatriisi {

    private int a, k;

    public RiviKerta(int a, int k) {
        this.a = a;
        this.k = k;
    }

    public int getRow() {
        return a;
    }

    public int getCoef() {
        return k;
    }

    @Override
    public double[][] matrix() {
        double[][] mat = new double[d][d];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                mat[i][j]=0;
            }
        }
        for (int i = 0; i < d; i++) {
            mat[i][i] = 1;
        }
        mat[a][a] = k;
        return mat;
    }

    @Override
    public double get(int i, int j) throws MatriisiException.KelvotonIndeksi {
        if (i < 0 || i >= d || j < 0 || j >= d) {
            throw MatriisiException.kelvotonIndeksi();
        }
        if(i!=j)return 0;
        if(i==a)return k;
        return 1;
    }

    @Override
    public AbstraktiMatriisi addition(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        if (width() != toinen.width() && height() != toinen.height()) {
            throw MatriisiException.vaaraKokoinenMatriisi();
        }
        double[][] mat = toinen.matrix();
        mat[a][a]+=k-1;
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
        mat[a][a]-=k-1;
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
            mat[a][i] *= k;
        }
        return toinen.width() == toinen.height() ? new TavallinenNeliomatriisi(mat) : new TavallinenMatriisi(mat);
    }

    @Override
    protected AbstraktiMatriisi dot_mirrored(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        if (d != toinen.width()) {
            throw MatriisiException.vaaraKokoinenMatriisi();
        }
        double[][] mat = toinen.matrix();
        for (int i = 0; i < toinen.width(); i++) {
            mat[i][a] *= k;
        }
        return toinen.width() == toinen.height() ? new TavallinenNeliomatriisi(mat) : new TavallinenMatriisi(mat);
    }
    
    
    @Override
    public AbstraktiMatriisi opposite() {
        double[][] mat = new double[d][d];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                mat[i][j]=0;
            }
        }
        for (int i = 0; i < d; i++) {
            mat[i][i] = -1;
        }
        mat[a][a] = -k;
        return new TavallinenNeliomatriisi(mat);
    }

    @Override
    public AbstraktiMatriisi transpose() {
        return this;
    }

    @Override
    public double determinant() {
        return k;
    }

}
