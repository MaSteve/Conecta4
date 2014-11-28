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
public class ReglasComplica implements ReglasJuego{
     //HAY QUE REFACTORIZAR CLASE INTERMEDIA YAAAA!!!!
    public ReglasComplica()
    {
        
    }

    @Override
    public Ficha hayGanador(Movimiento ultimoMovimiento, Tablero t) {
        int col=ultimoMovimiento.getColumna();
        Ficha provisional=Ficha.VACIA;
        int i=1; 
        boolean stop=false;
        while(i<=ALTO && !stop)
        {
            stop=isEnded(col, i, t);
            i++;
        }
        provisional=ganador;
        while(i<=ALTO)
        {
            if(isEnded(col, i, t) && !provisional.equals(ganador)) return Ficha.VACIA;
            i++;
        }
        return provisional;
    }
    private boolean isEnded(int lastx, int lasty, Tablero t )
    {//Determina si la partida ha terminado en una posición.
        if(!(lastx<1||lastx>ANCHO||lasty<1||lasty>ALTO)){
        Ficha color=t.getCasilla(lastx, lasty);
        ////EJE X
        if(!cuatroEnRaya(color, lastx, lasty, 1, 0, t)){
        ////EJE Y
        if(!cuatroEnRaya(color, lastx, lasty, 0, 1, t)){
        ////DIAGONAL 1
        if(!cuatroEnRaya(color, lastx, lasty, 1, 1, t)){
        ////DIAGONAL 2
        if(!cuatroEnRaya(color, lastx, lasty, 1, -1, t)){
            return false;
        }}}}}
        return true;
    }
    
    private boolean cuatroEnRaya(Ficha color, int posx, int posy, int incrx, int incry, Tablero t)
    {//En esta versión se usa este método
        int x=posx+incrx;
        int y=posy+incry;
        int cont=1;
        boolean stop=false;
        while(!stop && x<=ANCHO && y<=ALTO && x>=1 && y>=1)
        {
            if(t.getCasilla(x, y).equals(color))
            {
                x=x+incrx;
                y=y+incry;
                cont++;
                if(cont==4)
                {
                    ganador=color;//Revisar
                    return true;
                }
            }
            else stop=true;
        }
        x=posx-incrx;
        y=posy-incry;
        stop=false;
        while(!stop && x<=ANCHO && y<=ALTO && x>=1 && y>=1)
        {
            if(t.getCasilla(x, y).equals(color))
            {
                x=x-incrx;
                y=y-incry;
                cont++;
                if(cont==4)
                {
                    ganador=color;
                    return true;
                }
            }
            else stop=true;
        }
        return false;
    }
    
    @Override
    public Tablero iniciaTablero() {
        return new Tablero(ANCHO,ALTO);
    }

    @Override
    public Ficha jugadorInicial() {
        return Ficha.BLANCA;
    }

    @Override
    public Ficha siguienteTurno(Ficha ultimoEnPoner, Tablero t) {
        return ultimoEnPoner.contrario();
    }

    @Override
    public boolean tablas(Ficha ultimoEnPoner, Tablero t) {
        return false;
    }
    
    private Ficha ganador;
    private static final int ANCHO=4;
    private static final int ALTO=7;
}
