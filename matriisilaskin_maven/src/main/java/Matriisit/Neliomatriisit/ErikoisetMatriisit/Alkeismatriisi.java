/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriisit.Neliomatriisit.ErikoisetMatriisit;

import Matriisit.AbstraktiMatriisi;
import Matriisit.Neliomatriisit.Neliomatriisi;

/**
 *
 * @author Laituli
 */
public abstract class Alkeismatriisi extends AbstraktiMatriisi implements Neliomatriisi{
    final int d;

    protected Alkeismatriisi(int d) {
        this.d = d;
    }

    @Override
    public int height() {
        return d;
    }

    @Override
    public int width() {
        return d;
    }
}
