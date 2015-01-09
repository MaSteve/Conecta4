/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr2.logica;

import tp.pr2.logica.utilidades.Utils;

/**
 *
 * @author marcoantonio
 */
public class ReglasConecta4 implements ReglasJuego{
    //HAY QUE REFACTORIZAR CLASE INTERMEDIA YAAAA!!!!
    public ReglasConecta4()
    {
        
    }
    @Override
    public Ficha hayGanador(Movimiento ultimoMovimiento, Tablero t) {
        ganador=Ficha.VACIA;
        tablas=false;
        int i=1;
        int col=ultimoMovimiento.getColumna();
        boolean stop=false;
        while(i<=ALTO && !stop)
        {
            if(t.getCasilla(col, i).equals(Ficha.VACIA))
                i++;
            else
            {
                stop=true;
            }
        }
        if(!isEnded(col,i, t))//Igual se puede evitar
        {
            return Ficha.VACIA;
        }
        return ganador;
    }
    private boolean isEnded(int lastx, int lasty, Tablero t )
    {//Determina si la partida ha terminado. Se ejecuta en el controlador.
        boolean terminada=true;
        if(!(lastx<1||lastx>ANCHO||lasty<1||lasty>ALTO)){
        Ficha color=t.getCasilla(lastx, lasty);
        ////EJE X
        if(!Utils.cuatroEnRaya(color, lastx, lasty, 1, 0, t)){
        ////EJE Y
        if(!Utils.cuatroEnRaya(color, lastx, lasty, 0, 1, t)){
        ////DIAGONAL 1
        if(!Utils.cuatroEnRaya(color, lastx, lasty, 1, 1, t)){
        ////DIAGONAL 2
        if(!Utils.cuatroEnRaya(color, lastx, lasty, 1, -1, t)){
        ////Tablas
        int i=1; 
        while(terminada && i<=ANCHO)
        {
            terminada=!t.getCasilla(i, 1).equals(Ficha.VACIA);
            i++;
        }
        if(terminada)tablas=true;
        }}}}
        if(terminada && !tablas) ganador=color;
        }
        return terminada;
    }
    
    @Override
    public Tablero iniciaTablero() {
        return new Tablero(ANCHO, ALTO);
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
    public boolean tablas(Ficha ultimoEnPoner, Tablero t) {//No entiendo los parametros
        return tablas;
    }
    
    @Override
    public Game getGame() {
        return Game.C4;
    }
    
    private Ficha ganador;
    private boolean tablas;
    private static final int ANCHO=7;
    private static final int ALTO=6;
}
