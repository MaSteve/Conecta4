/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr2.control;

import tp.pr2.logica.Ficha;
import tp.pr2.logica.Movimiento;
import tp.pr2.logica.Tablero;

/**
 *
 * @author marcoantonio
 */
public interface Jugador {
   public Movimiento getMovimiento(Tablero tab, Ficha color);
}
