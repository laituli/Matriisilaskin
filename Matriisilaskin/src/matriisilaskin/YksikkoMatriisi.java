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
public class YksikkoMatriisi extends AbstraktiMatriisi implements Neliomatriisi {
    int d;

    public YksikkoMatriisi(int i) {
        d = i;
    }

    @Override
    public double[][] matrix() {
        double[][] mat = new double[d][d];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                mat[i][j] = i == j ? 1 : 0;
            }
        }
        return mat;
    }

    @Override
    public int width() {
        return d;
    }

    @Override
    public int height() {
        return d;
    }

    @Override
    public double get(int i, int j) throws MatriisiException.KelvotonIndeksi {
        return i == j ? 1 : 0;
    }

    @Override
    public AbstraktiMatriisi addition(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        check_add_sub_size(toinen);
        double[][] mat = toinen.matrix();
        for (int i = 0; i < d; i++) {
            mat[i][i]+=1;
        }        
        return new TavallinenNeliomatriisi(mat);
    }

    @Override
    public AbstraktiMatriisi subtract(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        check_add_sub_size(toinen);
        double[][] mat = toinen.opposite().matrix();
        for (int i = 0; i < d; i++) {
            mat[i][i]++;
        }
        return new TavallinenNeliomatriisi(mat);
    }
    @Override
    protected AbstraktiMatriisi subtract_mirrored(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        check_add_sub_size(toinen);
        double[][] mat = toinen.matrix();
        for (int i = 0; i < d; i++) {
            mat[i][i]--;
        }
        return new TavallinenNeliomatriisi(mat);
    }

    @Override
    public AbstraktiMatriisi dot(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        check_mul_size(toinen);
        return toinen;
    }

    @Override
    protected AbstraktiMatriisi dot_mirrored(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        toinen.check_mul_size(this);
        return toinen; //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public AbstraktiMatriisi opposite() {
        double[][] mat = new double[d][d];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                mat[i][j] = i == j ? -1 : 0;
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
        return 1;
    }

}
