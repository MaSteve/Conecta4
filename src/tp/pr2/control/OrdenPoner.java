/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr2.control;

import java.util.Scanner;
import tp.pr2.logica.Movimiento;
import tp.pr2.logica.MovimientoInvalido;
import tp.pr2.logica.Partida;

/**
 *
 * @author marcoantonio
 */
public class OrdenPoner extends Orden{

    @Override
    public void ejecuta(Partida partida, Scanner input, Controlador control) {
        Movimiento mov=control.getJugador().getMovimiento(control.getPartida().getTablero(),
                control.getPartida().getTurno());
        try
        {
            partida.ejecutaMovimiento(mov);
        }
        catch(MovimientoInvalido e)
        {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Orden parsea(String ord) {
        if(ord.equals("poner")) return this;
        else return null;
    }
    
}
