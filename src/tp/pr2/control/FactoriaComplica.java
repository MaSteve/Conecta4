/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr2.control;

import java.util.Scanner;
import tp.pr2.logica.Ficha;
import tp.pr2.logica.Game;
import tp.pr2.logica.Movimiento;
import tp.pr2.logica.MovimientoComplica;
import tp.pr2.logica.ReglasComplica;
import tp.pr2.logica.ReglasJuego;

/**
 *
 * @author marcoantonio
 */
public class FactoriaComplica implements FactoriaTipoJuego {

    @Override
    public Jugador creaJugadorAleatorio() {
       return new JugadorAleatorioComplica(); 
    }

    @Override
    public Jugador creaJugadorHumanoConsola(Scanner in) {
        return new JugadorHumano(in, this);
    }

    @Override
    public Movimiento creaMovimiento(int col, int fila, Ficha color) {
        return new MovimientoComplica(col, color);
    }

    @Override
    public ReglasJuego creaReglas() {
        return new ReglasComplica();
    }

    @Override
    public Game getGame() {
        return Game.CO;
    }

    @Override
    public boolean filasImportan() {
        return false;
    }
    
}
