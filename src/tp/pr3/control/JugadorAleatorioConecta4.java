/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr3.control;

import java.util.ArrayList;
import java.util.Random;
import tp.pr3.logica.Ficha;
import tp.pr3.logica.Movimiento;
import tp.pr3.logica.MovimientoConecta4;
import tp.pr3.logica.Tablero;

/**
 *
 * @author marcoantonio
 */
public class JugadorAleatorioConecta4 implements Jugador{

    @Override
    public Movimiento getMovimiento(Tablero tab, Ficha color) {
        Random rand=new Random();
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=1; i<=tab.getAncho(); i++)
        {
            if(tab.getCasilla(i, 1).equals(Ficha.VACIA)) list.add(i);
        }
        if(list.isEmpty())return null;
        return new MovimientoConecta4(list.get(rand.nextInt(list.size())), color);
    }
    
}
