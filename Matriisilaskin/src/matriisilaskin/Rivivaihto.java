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
public class Rivivaihto extends Alkeismatriisi {

    private int a, b;

    public Rivivaihto(int a, int b) throws MatriisiException.KelvotonIndeksi {
        if (a == b) {
            throw MatriisiException.kelvotonIndeksi();
        }
        this.a = a;
        this.b = b;
    }

    public int getRowA() {
        return a;
    }

    public int getRowB() {
        return b;
    }

    @Override
    public double[][] matrix() {
        double[][] mat = new double[d][d];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                mat[i][j]=0;
            }
        }
        boolean ia, ib, ja, jb, ij;
        for (int i = 0; i < d; i++) {
            ia = i == a;
            ib = i == b;
            for (int j = 0; j < d; j++) {
                ja = j == a;
                jb = j == b;
                ij = i == j;
                mat[i][j] = (ja && ib) || (ia && jb) || (ij && !(ia && ib)) ? 1 : 0;
            }
        }
        return mat;
    }

    @Override
    public double get(int i, int j) throws MatriisiException.KelvotonIndeksi {
        if (i < 0 || i >= d || j < 0 || j >= d) {
            throw MatriisiException.kelvotonIndeksi();
        }
        boolean ia, ib, ja, jb, ij;
        ia = i == a;
        ib = i == b;
        ja = j == a;
        jb = j == b;
        ij = i == j;
        return (ja && ib) || (ia && jb) || (ij && !(ia && ib)) ? 1 : 0;
    }

    @Override
    public AbstraktiMatriisi addition(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        if (width() != toinen.width() && height() != toinen.height()) {
            throw MatriisiException.vaaraKokoinenMatriisi();
        }
        double[][] mat = toinen.matrix();
        mat[a][b]++;
        mat[b][a]++;
        for (int i = 0; i < d; i++) {
            if (i == a) {
                continue;
            }
            if (i == b) {
                continue;
            }
            mat[i][i]++;
        }
        return new TavallinenNeliomatriisi(mat);
    }
    @Override
    public AbstraktiMatriisi substract(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        return addition(toinen.opposite());
    }

    @Override
    public AbstraktiMatriisi substract_mirrored(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        if (width() != toinen.width() && height() != toinen.height()) {
            throw MatriisiException.vaaraKokoinenMatriisi();
        }
        double[][] mat = toinen.matrix();
        mat[a][a]++;
        mat[b][b]++;
        mat[a][b]--;
        mat[b][a]--;
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
        double z;
        for (int i = 0; i < toinen.width(); i++) {
            z = mat[a][i];
            mat[a][i] = mat[b][i];
            mat[b][i] = z;
        }
        return toinen.width() == toinen.height() ? new TavallinenNeliomatriisi(mat) : new TavallinenMatriisi(mat);
    }

    @Override
    protected AbstraktiMatriisi dot_mirrored(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        if (d != toinen.width()) {
            throw MatriisiException.vaaraKokoinenMatriisi();
        }
        double[][] mat = toinen.matrix();
        double z;
        for (int i = 0; i < toinen.height(); i++) {
            z = mat[i][a];
            mat[i][a] = mat[i][b];
            mat[i][b] = z;
        }
        return toinen.width() == toinen.height() ? new TavallinenNeliomatriisi(mat) : new TavallinenMatriisi(mat);
    }
    
    

    @Override
    public AbstraktiMatriisi opposite() {
        double[][] mat = new double[d][d];
        boolean ia, ib, ja, jb, ij;
        for (int i = 0; i < d; i++) {
            ia = i == a;
            ib = i == b;
            for (int j = 0; j < d; j++) {
                ja = j == a;
                jb = j == b;
                ij = i == j;
                mat[i][j] = (ja && ib) || (ia && jb) || (ij && !(ia && ib)) ? 1 : 0;
            }
        }
        return new TavallinenNeliomatriisi(mat);
    }

    @Override
    public AbstraktiMatriisi transpose() {
        return this;
    }

    @Override
    public double determinant() {
        return -1;
    }

}
