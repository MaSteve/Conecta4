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
public class Tablero {
    public Tablero(int tx, int ty)
    {
        ancho=tx;
        alto=ty;
        tablero=new Ficha[tx][ty];
    }
    public String toString()
    {
        //TODO
        String board="";
        for(int i=alto-1; i>=0; i--)
        {
            board+="|";
            for(int j=0; j<ancho; j++)
            {
                Ficha color=getCasilla(j, i);
                if(color==Ficha.BLANCA)board+="O";
                else if(color==Ficha.NEGRA) board+="X";
                else board+=" ";
            }
            board+="|"+"\n";
        }
        board+="+";
        for(int i=0; i<ancho; i++)
        {
            board+="-";
        }
        board+="+"+"\n"+" ";
        for(int i=0; i<ancho; i++)
        {
            board+=""+(i+1);
        }
        board+="\n";
        return board;
    }
    public int getAlto()
    {
        return alto;
    }
    public int getAncho()
    {
        return ancho;
    }
    public Ficha getCasilla(int x, int y)
    {
        return tablero[x][y];
    }
    public void setCasilla(int x, int y, Ficha color)
    {
        tablero[x][y]=color;
    }
    private Ficha [ ][ ] tablero;
    private int ancho;
    private int alto;

}
