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
public abstract class MatriisiException extends Exception{
    static Exception KelvotonIndeksi;
    public MatriisiException(String string) {
        super(string);
    }
    public static KelvotonIndeksi kelvotonIndeksi(){
        return new KelvotonIndeksi();
    }
    public static VaaraKokoinenMatriisi vaaraKokoinenMatriisi(){
        return new VaaraKokoinenMatriisi();
    }
    public static class KelvotonIndeksi extends MatriisiException{
        public KelvotonIndeksi() {
            super("Indeksi ei kelpaa");
        }
    }
    public static class VaaraKokoinenMatriisi extends MatriisiException{
        public VaaraKokoinenMatriisi() {
            super("Matriisin koko on väärä");
        }
    }
}
