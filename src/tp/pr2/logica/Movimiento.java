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
    public abstract boolean ejecutaMovimiento(Tablero tab);
    public abstract void undo(Tablero tab);
    public Ficha getJugador()
    {
        return color;
    }
    public int getColumna()
    {
        return columna;
    }
    
    public int getFila()//Ojo a ver quien lo usa
    {
        return fila;
    }
    
    protected int columna;//Esto igual no le gusta!!!!
    protected int fila;
    protected Ficha color;
}
