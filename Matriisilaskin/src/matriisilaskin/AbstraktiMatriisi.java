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
    public abstract AbstraktiMatriisi addition(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi;
    /**
     * 
     * @param toinen samakokoinen matriisi
     * @return erotusmatriisi vähennetty alkuperäisestä toisella
     * @throws matriisilaskin.MatriisiException.VaaraKokoinenMatriisi 
     */
    public abstract AbstraktiMatriisi substract(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi;
    /**
     * 
     * @param toinen samakokoinen matriisi
     * @return erotusmatriisi toinen - this
     * @throws matriisilaskin.MatriisiException.VaaraKokoinenMatriisi 
     */
    protected abstract AbstraktiMatriisi substract_mirrored(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi;
    /**
     * 
     * @param toinen  toisen matriisin korkeus pitää olla sama kuin alkuperäisen leveys
     * @return tulomatriisi
     * @throws matriisilaskin.MatriisiException.VaaraKokoinenMatriisi 
     */
    public abstract AbstraktiMatriisi dot(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi;
    
    protected abstract AbstraktiMatriisi dot_mirrored(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi;
    
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
        AbstraktiMatriisi m = (AbstraktiMatriisi)o;
        if(m.width()!=width())return false;
        if(m.height()!=height())return false;
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                try {
                    if(get(i, j)!=m.get(i, j))return false;
                } catch (MatriisiException.KelvotonIndeksi ex) {
                    Logger.getLogger(AbstraktiMatriisi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return true;
    }
    
    
}
