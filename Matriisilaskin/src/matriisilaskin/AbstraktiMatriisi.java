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
public abstract class AbstraktiMatriisi {
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
     * @param i indeksi leveyssuunnassa
     * @param j indeksi korkeussuunnassa
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
    public abstract AbstraktiMatriisi plus(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi;
    /**
     * 
     * @param toinen samakokoinen matriisi
     * @return erotusmatriisi vähennetty alkuperäisestä toisella
     * @throws matriisilaskin.MatriisiException.VaaraKokoinenMatriisi 
     */
    public abstract AbstraktiMatriisi minus(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi;
    /**
     * 
     * @param toinen  toisen matriisin korkeus pitää olla sama kuin alkuperäisen leveys
     * @return tulomatriisi
     * @throws matriisilaskin.MatriisiException.VaaraKokoinenMatriisi 
     */
    public abstract AbstraktiMatriisi mult(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi;
    
}
