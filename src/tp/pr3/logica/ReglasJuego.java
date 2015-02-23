/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr3.logica;

/**
 *
 * @author marcoantonio
 */
public interface ReglasJuego {
    public Ficha hayGanador(Movimiento ultimoMovimiento, Tablero t);
    public Tablero iniciaTablero();
    public Ficha jugadorInicial();
    public Ficha siguienteTurno(Ficha ultimoEnPoner, Tablero t);
    public boolean tablas(Ficha ultimoEnPoner, Tablero t);
    public Game getGame();
}
