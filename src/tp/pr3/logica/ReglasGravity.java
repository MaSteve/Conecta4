package tp.pr3.logica;

import tp.pr3.logica.utilidades.Utils;

/**
 *
 * @author marcoantonio
 */
public class ReglasGravity implements ReglasJuego{

    public ReglasGravity()
    {
        ancho=ANCHO;
        alto=ALTO;
    }
    public ReglasGravity(int ancho, int alto)
    {
        this.ancho=ancho;
        this.alto=alto;
    }
    @Override
    public Ficha hayGanador(Movimiento ultimoMovimiento, Tablero t) {
        ganador=Ficha.VACIA;
        tablas=false;
        if(!isEnded(ultimoMovimiento.getColumna(), ultimoMovimiento.getFila(), t))
        {
            return Ficha.VACIA;
        }
        return ganador;
    }
    
    private boolean isEnded(int lastx, int lasty, Tablero t )
    {//Determina si la partida ha terminado. Se ejecuta en el controlador.
        boolean terminada=true;
        if(!(lastx<1||lastx>ancho||lasty<1||lasty>alto)){
            Ficha color=t.getCasilla(lastx, lasty);
            if(!Utils.cuatroEnRaya(color, lastx, lasty, 1, 0, t) && 
                    !Utils.cuatroEnRaya(color, lastx, lasty, 0, 1, t) &&
                    !Utils.cuatroEnRaya(color, lastx, lasty, 1, 1, t) &&
                    !Utils.cuatroEnRaya(color, lastx, lasty, 1, -1, t)){
                    ////Tablas
                    for(int i=1; i<=ancho&&terminada; i++)
                    {
                        for(int j=1; j<=alto&&terminada; j++)
                        {
                            if(t.getCasilla(i, j).equals(Ficha.VACIA)) terminada=false;
                        }
                    }
                    if(terminada)tablas=true;
            }
            if(terminada && !tablas) ganador=color;
        }
        return terminada;
    }
    
    @Override
    public Tablero iniciaTablero() {
        return new Tablero(ancho, alto); //Comprobar tamaño negativo????
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
        /*for(int i=1; i<=ancho; i++)
        {
            for(int j=1; j<=alto; j++)
            {
                if(t.getCasilla(i, j).equals(Ficha.VACIA)) return false;
            }
        }
        return true;*/
        return tablas;
    }

    @Override
    public Game getGame() {
        return Game.GR;
    }
    private static final int ANCHO=10;
    private static final int ALTO=10;
    private int ancho;
    private int alto;
    private Ficha ganador;
    private boolean tablas;
}
