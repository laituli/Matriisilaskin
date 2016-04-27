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

    private final int a;
    private final double k;
    
    /**
     *
     * @param d matriisin koko
     * @param a rivin indeksi joka kertaa kertaluvulla
     * @param k kertaluku
     */
    public RiviKerta(int d, int a, double k) {
        super(d);
        this.a = a;
        this.k = k;
    }

    
    /**
     *
     * @return rivin indeksi joka kertaa kertaluvulla
     */
    public int getRow() {
        return a;
    }

    /**
     *
     * @return kertaluku
     */
    public double getCoef() {
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
        mat[a][a] = k;
        return mat;
    }

    @Override
    public double get(int i, int j) throws MatriisiException.KelvotonIndeksi {
        if (i < 0 || i >= d || j < 0 || j >= d) {
            throw MatriisiException.kelvotonIndeksi();
        }
        if (i != j) {
            return 0;
        }
        if (i == a) {
            return k;
        }
        return 1;
    }

    @Override
    public AbstraktiMatriisi addition(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        check_add_sub_size(toinen);
        double[][] mat = toinen.matrix();
        mat[a][a] += k - 1;
        for (int i = 0; i < d; i++) {
            mat[i][i]++;
        }
        return new TavallinenNeliomatriisi(mat);
    }

    @Override
    public AbstraktiMatriisi subtract(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        return addition(toinen.opposite());
    }

    @Override
    protected AbstraktiMatriisi subtract_mirrored(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        check_add_sub_size(toinen);
        double[][] mat = toinen.matrix();
        mat[a][a] -= k - 1;
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
                mat[i][j] = 0;
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
