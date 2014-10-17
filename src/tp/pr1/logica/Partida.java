/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.pr1.logica;

/**
 *
 * @author marcoantonio
 */
public class Partida {
    
    public Partida()
    {
        reset();
    }
    public boolean ejecutaMovimiento(Ficha color, int col)
    {
        if(!(tablero.getCasilla(col, 1).equals(Ficha.VACIA)))
        {
            return false;
        }
        else
        {
            int i=2;
            boolean stop=false;
            while(i<=ALTO && !stop)
            {
                if(tablero.getCasilla(col, i).equals(Ficha.VACIA))
                i++;
                else
                {
                    stop=true;
                }
            }
            tablero.setCasilla(col, i-1, color);
            turno=turno.contrario();
            return true;
        }
    }
    public Ficha getGanador()
    {
        return ganador;
    }
    public Tablero getTablero()
    {
        return tablero;
    }
    public boolean isTerminada()
    {
        return false;
    }
    public final void reset() //???
    {
        tablero=new Tablero(ANCHO, ALTO);
        turno=Ficha.BLANCA;
        terminada=false;
        ganador=Ficha.VACIA;
    }
    public boolean undo()
    {
        return false;
    }
    
    private Tablero tablero; 
    private Ficha turno; 
    private boolean terminada; 
    private Ficha ganador;
    private static final int ANCHO=8;
    private static final int ALTO=8;
}
