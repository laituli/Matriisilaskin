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
public class RiviLisays extends Alkeismatriisi {

    private final int a, b, k;

    /**
     *
     * @param d matriisin koko
     * @param a rivin indeksi johon lisätään
     * @param b rivin indeksi josta lisätään
     * @param k lisämisen kertaluku
     */
    public RiviLisays(int d,int a, int b, int k){
        super(d);
        this.a = a;
        this.b = b;
        this.k = k;
    }

    /**
     *
     * @return rivin indeksi johon lisätään
     */
    public int getRowTo() {
        return a;
    }

    /**
     *
     * @return rivin indeksi josta lisätään
     */
    public int getRowFrom() {
        return b;
    }

    /**
     *
     * @return kertaluku
     */
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
        check_add_sub_size(toinen);
        double[][] mat = toinen.matrix();
        mat[a][b]+=k;
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
        return new RiviLisays(d, b, a, k);
    }

    @Override
    public double determinant() {
        return 1;
    }

}
