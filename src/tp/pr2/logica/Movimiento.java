/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr2.logica;

/**
 *
 * @author marcoantonio
 */
public abstract class Movimiento {
    
    public int getColumna()
    {
        return columna;
    }
    
    protected int columna;
    protected Ficha color;
}
