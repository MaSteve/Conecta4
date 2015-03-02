package tp.pr3.control;

import java.util.Scanner;
import tp.pr3.logica.Ficha;
import tp.pr3.logica.Game;
import tp.pr3.logica.Movimiento;
import tp.pr3.logica.MovimientoConecta4;
import tp.pr3.logica.ReglasConecta4;
import tp.pr3.logica.ReglasJuego;

/**
 *
 * @author marcoantonio
 */
public class FactoriaConecta4 implements FactoriaTipoJuego {

    @Override
    public Jugador creaJugadorAleatorio() {
       return new JugadorAleatorioConecta4(); 
    }

    @Override
    public Jugador creaJugadorHumanoConsola(Scanner in) {
        return new JugadorHumano(in, this);
    }

    @Override
    public Movimiento creaMovimiento(int col, int fila, Ficha color) {
        return new MovimientoConecta4(col, color);
    }

    @Override
    public ReglasJuego creaReglas() {
        return new ReglasConecta4();
    }

    @Override
    public Game getGame() {
        return Game.C4;
    }

    @Override
    public boolean filasImportan() {
        return false;
    }
    
}
