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
public class TavallinenMatriisi extends AbstraktiMatriisi{
    
    private double[][] matriisi;
    
    /**
     * 
     * @param matriisi matriisin sisällöt 
     */
    public TavallinenMatriisi(double[][] matriisi) {
        this.matriisi = matriisi.clone();
    }

    @Override
    public int width() {
        return matriisi[0].length;
    }

    @Override
    public int height() {
        return matriisi.length;
    }

    @Override
    public double get(int i, int j) throws MatriisiException.KelvotonIndeksi{
        try {
            return matriisi[i][j];
        } catch (IndexOutOfBoundsException e) {
            throw MatriisiException.kelvotonIndeksi();
        }
    }

    @Override
    public AbstraktiMatriisi addition(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        if(width()!=toinen.width() && height()!=toinen.height())throw MatriisiException.vaaraKokoinenMatriisi();
        if(toinen instanceof TavallinenMatriisi){
            TavallinenMatriisi t=(TavallinenMatriisi)toinen;
            double[][] sum = new double[height()][width()];
            for (int i = 0; i < height(); i++) {
                for (int j = 0; j < width(); j++) {
                        sum[i][j]=matriisi[i][j]+t.matriisi[i][j];
                }
            }    
            return new TavallinenMatriisi(sum);
        }        
        return toinen.addition(this);
    }

    @Override
    public AbstraktiMatriisi substract(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        if(width()!=toinen.width() && height()!=toinen.height())throw MatriisiException.vaaraKokoinenMatriisi();
        if(toinen instanceof TavallinenMatriisi){
            TavallinenMatriisi t=(TavallinenMatriisi)toinen;
            double[][] dif = new double[height()][width()];
            for (int i = 0; i < height(); i++) {
                for (int j = 0; j < width(); j++) {
                        dif[i][j]=matriisi[i][j]-t.matriisi[i][j];
                }
            }    
            return new TavallinenMatriisi(dif);
        }        
        return toinen.substract_mirrored(this);
    }

    @Override
    public AbstraktiMatriisi dot(AbstraktiMatriisi toinen) throws MatriisiException.VaaraKokoinenMatriisi {
        if(width()!=toinen.height())throw MatriisiException.vaaraKokoinenMatriisi();
        if(toinen instanceof TavallinenMatriisi){
            TavallinenMatriisi t=(TavallinenMatriisi) toinen;
            double[][] tulo=new double[height()][toinen.width()];
            for (int i = 0; i < height(); i++) {
                for (int j = 0; j < toinen.width(); j++) {
                    double s = 0;
                    for (int k = 0; k < width(); k++) {
                        s+=matriisi[i][k]*t.matriisi[k][j];
                    }
                    tulo[i][j]=s;
                }
            }
            return height()==toinen.width()?new TavallinenNeliomatriisi(tulo):new TavallinenMatriisi(tulo);
        }
        return toinen.dot_mirrored(this);
    }

    @Override
    public AbstraktiMatriisi opposite() {
        double[][] oppo=new double[height()][width()];
        for (int i = 0; i < height(); i++) {
                for (int j = 0; j < width(); j++) {
                oppo[i][j] = - matriisi[i][j];
            }
        }
        return new TavallinenMatriisi(oppo);
    }
    @Override
    public double[][] matrix() {
        return matriisi.clone();
    }

    @Override
    public AbstraktiMatriisi transpose() {
        double[][] matrixt= new double[width()][height()];
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                matrixt[j][i]=matriisi[i][j];
            }
        }
        return new TavallinenMatriisi(matrixt);
    }
    
}
