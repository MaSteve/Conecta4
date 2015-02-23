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
import tp.pr3.logica.MovimientoGravity;
import tp.pr3.logica.Tablero;

/**
 *
 * @author marcoantonio
 */
public class JugadorAleatorioGravity implements Jugador{

    @Override
    public Movimiento getMovimiento(Tablero tab, Ficha color) {
        Random rand=new Random();
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=1; i<=tab.getAncho(); i++)
        {
            for(int j=1; j<=tab.getAlto(); j++)
            {
                if(tab.getCasilla(i, j).equals(Ficha.VACIA)) list.add((tab.getAncho()*(j-1))+(i-1));
            }
        }
        if(list.isEmpty())return null;
        int pos=list.get(rand.nextInt(list.size()));
        return new MovimientoGravity((pos%tab.getAncho())+1, (pos/tab.getAncho())+1, color);//, tab);
    
    }
    
    
}
