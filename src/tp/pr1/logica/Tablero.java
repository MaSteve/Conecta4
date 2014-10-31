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
        if(tx<1 || ty<1)
        {
            ancho=1;
            alto=1;
        }
        else
        {
            ancho=tx;
            alto=ty;
        }
        tablero=new Ficha[ancho][alto];
        for(int i=0; i<ancho; i++)
            for(int j=0; j<alto;j++)
                this.setCasilla(i+1, j+1, Ficha.VACIA);
    }
    public String toString()
    {
        //TODO
        String board="";
        for(int i=1; i<=alto; i++)
        {
            board+="|";
            for(int j=1; j<=ancho; j++)
            {
                Ficha color=getCasilla(j, i);
                if(color.equals(Ficha.BLANCA))board+="O";
                else if(color.equals(Ficha.NEGRA)) board+="X";
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
        if(x<1||y<1||x>ancho||y>ancho) return Ficha.VACIA;
        else return tablero[x-1][y-1]; //Por Stalin
    }
    public void setCasilla(int x, int y, Ficha color)
    {
        tablero[x-1][y-1]=color; //Por Stalin
    }
    private Ficha [ ][ ] tablero;
    private int ancho;
    private int alto;

}
