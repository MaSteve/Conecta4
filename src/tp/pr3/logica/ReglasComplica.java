package tp.pr3.logica;

import tp.pr2.logica.utilidades.Utils;

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
        if(stop)provisional=ganador;
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
        if(color.equals(Ficha.VACIA))return false;
        ////EJE X
        if(!Utils.cuatroEnRaya(color, lastx, lasty, 1, 0, t)){
        ////EJE Y
        if(!Utils.cuatroEnRaya(color, lastx, lasty, 0, 1, t)){
        ////DIAGONAL 1
        if(!Utils.cuatroEnRaya(color, lastx, lasty, 1, 1, t)){
        ////DIAGONAL 2
        if(!Utils.cuatroEnRaya(color, lastx, lasty, 1, -1, t)){
            return false;
        }}}}
        ganador=color;
        }
        return true;
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
    
    @Override
    public Game getGame() {
        return Game.CO;
    }
    
    private Ficha ganador;
    private static final int ANCHO=4;
    private static final int ALTO=7;
}
