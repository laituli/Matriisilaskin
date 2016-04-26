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
public abstract class AbstraktiMatriisi {

    /**
     *
     * @return matriisin sisältö
     */
    public abstract double[][] matrix();

    /**
     *
     * @return matriisin leveys
     */
    public abstract int width();

    /**
     *
     * @return matriisin korkeus
     */
    public abstract int height();

    /**
     *
     * @param i indeksi korkeussuunnassa
     * @param j indeksi leveyssuunnassa
     * @return matriisin arvo kohdassa i,j
     * @throws matriisilaskin.MatriisiException.KelvotonIndeksi
     */
    public abstract double get(int i, int j) throws MatriisiException.KelvotonIndeksi;

    /**
     *
     * @param toinen samakokoinen matriisi
     * @return summamatriisi yhteenlaskettuna
     * @throws matriisilaskin.MatriisiException.VaaraKokoinenMatriisi
     */
    public AbstraktiMatriisi addition(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        check_add_sub_size(toinen);
        if (!(toinen instanceof TavallinenMatriisi) && !(toinen instanceof TavallinenNeliomatriisi)) {
            return toinen.addition(this);
        }
        double[][] a = matrix();
        double[][] b = toinen.matrix();
        double[][] c = new double[height()][width()];
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return width() == height() ? new TavallinenNeliomatriisi(c) : new TavallinenMatriisi(c);
    }

    /**
     *
     * @param toinen samakokoinen matriisi
     * @return erotusmatriisi vähennetty alkuperäisestä toisella
     * @throws matriisilaskin.MatriisiException.VaaraKokoinenMatriisi
     */
    public AbstraktiMatriisi subtract(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        check_add_sub_size(toinen);
        if (!(toinen instanceof TavallinenMatriisi) && !(toinen instanceof TavallinenNeliomatriisi)) {
            return toinen.subtract_mirrored(this);
        }
        double[][] a = matrix();
        double[][] b = toinen.matrix();
        double[][] c = new double[height()][width()];
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return width() == height() ? new TavallinenNeliomatriisi(c) : new TavallinenMatriisi(c);
    }

    /**
     *
     * @param toinen samakokoinen matriisi
     * @return erotusmatriisi toinen - this
     * @throws matriisilaskin.MatriisiException.VaaraKokoinenMatriisi
     */
    protected AbstraktiMatriisi subtract_mirrored(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        return toinen.subtract(this);
    }

    /**
     *
     * @param toinen toisen matriisin korkeus pitää olla sama kuin thisin leveys
     * @return tulomatriisi this * toinen
     * @throws matriisilaskin.MatriisiException.VaaraKokoinenMatriisi
     */
    public abstract AbstraktiMatriisi dot(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi;

    /**
     *
     * @param toinen toisen matriisin leveys pitää olla sama kuin thisin korkeus
     * @return tulomatriisi toinen * this
     * @throws matriisilaskin.MatriisiException.VaaraKokoinenMatriisi
     */
    protected AbstraktiMatriisi dot_mirrored(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        return toinen.dot(this);
    }

    /**
     *
     * @return nollamatriisi - matriisi
     */
    public abstract AbstraktiMatriisi opposite();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AbstraktiMatriisi)) {
            return false;
        }
        AbstraktiMatriisi m = (AbstraktiMatriisi) o;
        if (m.width() != width()) {
            return false;
        }
        if (m.height() != height()) {
            return false;
        }
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                try {
                    if (get(i, j) != m.get(i, j)) {
                        return false;
                    }
                } catch (MatriisiException.KelvotonIndeksi ex) {
                    Logger.getLogger(AbstraktiMatriisi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return true;
    }
    
    /**
     *
     * @return matriisin transpoosi
     */
    public abstract AbstraktiMatriisi transpose();

    /**
     *
     * @param toinen 
     * @throws MatriisiException.VaaraKokoinenMatriisi jos koko ei ole sama
     */
    public void check_add_sub_size(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        if (width() != toinen.width() || height() != toinen.height()) {
            throw MatriisiException.vaaraKokoinenMatriisi();
        }
    }
    
    /**
     *
     * @param toinen
     * @throws MatriisiException.VaaraKokoinenMatriisi jos kertolasku ei ole määritelty
     */
    public void check_mul_size(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        if (width() != toinen.height()) {
            throw MatriisiException.vaaraKokoinenMatriisi();
        }
    }
}
