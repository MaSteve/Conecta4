/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr3.control;

import java.util.Scanner;
import tp.pr3.logica.Ficha;
import tp.pr3.logica.Game;
import tp.pr3.logica.Movimiento;
import tp.pr3.logica.MovimientoGravity;
import tp.pr3.logica.ReglasGravity;
import tp.pr3.logica.ReglasJuego;

/**
 *
 * @author marcoantonio
 */
public class FactoriaGravity implements FactoriaTipoJuego {

    public FactoriaGravity()
    {
        tamx=tamy=0;
    }
    public FactoriaGravity(int tamx, int tamy)
    {
        this.tamx=tamx;
        this.tamy=tamy;
    }
    @Override
    public Jugador creaJugadorAleatorio() {
       return new JugadorAleatorioGravity(); 
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
        if(tamx<=0||tamy<=0) return new ReglasGravity();//Modificar
        else return new ReglasGravity(tamx, tamy);
    }

    @Override
    public Game getGame() {
        return Game.GR;
    }
    
    @Override
    public boolean filasImportan() {
        return true;
    }
    
    private int tamx, tamy;
    //private Tablero tab;//Modificar
}
