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
import tp.pr2.logica.MovimientoConecta4;
import tp.pr2.logica.Partida;

/**
 *
 * @author marcoantonio
 */
public class OrdenPoner extends Orden{

    @Override
    public void ejecuta(Partida partida, Scanner input) {
        System.out.print("Introduce la columna: ");//Vamos a fiarnos del usuario
        String comando=input.nextLine();//No podemos usar try catch
        int col=Integer.parseInt(comando);
        Movimiento mov;
        Ficha color=partida.getTurno();
        mov=partida.getGame()==Game.C4? new MovimientoConecta4(col, color):new MovimientoComplica(col, color);
        if(!partida.ejecutaMovimiento(mov))//Hay que cambiarlo!!!!!
        {
            System.err.println("Movimiento incorrecto");
        }
    }

    @Override
    public Orden parsea(String ord) {
        if(ord.equals("poner")) return this;
        else return null;
    }
    
}
