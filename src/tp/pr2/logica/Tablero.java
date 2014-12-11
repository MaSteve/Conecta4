package tp.pr2.logica;

/**
 *
 * @author marcoantonio
 */
public class Tablero {
    /*
     * Clase Tablero. Contiene las fichas de la partida 
     */
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
        StringBuilder board=new StringBuilder();
        board.append("");
        for(int i=1; i<=alto; i++)
        {
            board.append("|");
            for(int j=1; j<=ancho; j++)
            {
                Ficha color=getCasilla(j, i);
                if(color.equals(Ficha.BLANCA))board.append("O");
                else if(color.equals(Ficha.NEGRA)) board.append("X");
                else board.append(" ");
            }
            board.append("|"+"\n");
        }
        board.append("+");
        for(int i=0; i<ancho; i++)
        {
            board.append("-");
        }
        board.append("+"+"\n"+" ");
        for(int i=0; i<ancho; i++)
        {
            board.append(""+(i+1));
        }
        board.append("\n");
        return board.toString();
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
        if(x<1||y<1||x>ancho||y>alto) return Ficha.VACIA;
        else return tablero[x-1][y-1];
    }
    public void setCasilla(int x, int y, Ficha color)
    {
        if(x>=1&&y>=1&&x<=ancho&&y<=alto)tablero[x-1][y-1]=color;
    }
    private Ficha [ ][ ] tablero;
    private int ancho;
    private int alto;

}
