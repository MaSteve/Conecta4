/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr3.control;

import tp.pr3.logica.Ficha;
import tp.pr3.logica.Movimiento;
import tp.pr3.logica.MovimientoInvalido;
import tp.pr3.logica.Tablero;

/**
 *
 * @author marcoantonio
 */
public interface Jugador {
   public Movimiento getMovimiento(Tablero tab, Ficha color) throws MovimientoInvalido;
}
