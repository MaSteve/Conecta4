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
import tp.pr2.logica.MovimientoGravity;
import tp.pr2.logica.ReglasGravity;
import tp.pr2.logica.ReglasJuego;

/**
 *
 * @author marcoantonio
 */
public class FactoriaGravity implements FactoriaTipoJuego {

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
        return new MovimientoGravity(col, fila, color);//, tab);
    }

    @Override
    public ReglasJuego creaReglas() {
        return new ReglasGravity();//Modificar
    }

    @Override
    public Game getGame() {
        return Game.GR;
    }
    
    @Override
    public boolean filasImportan() {
        return true;
    }
    
    //private Tablero tab;//Modificar
}
