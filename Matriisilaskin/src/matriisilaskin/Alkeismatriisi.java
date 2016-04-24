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
public abstract class Alkeismatriisi extends AbstraktiMatriisi implements Neliomatriisi{
    int d;

    @Override
    public int height() {
        return d;
    }

    @Override
    public int width() {
        return d;
    }
}
