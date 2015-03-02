package tp.pr3.control;

import tp.pr3.logica.Ficha;
import tp.pr3.logica.Game;
import tp.pr3.logica.Movimiento;
import tp.pr3.logica.ReglasJuego;

/**
 *
 * @author marcoantonio
 */
public interface FactoriaTipoJuego {
    public Jugador creaJugadorAleatorio();
    public Jugador creaJugadorHumanoConsola(java.util.Scanner in);
    public Movimiento creaMovimiento(int col, int fila, Ficha color);
    public ReglasJuego creaReglas();
    public Game getGame();
    public boolean filasImportan();
}
