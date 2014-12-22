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
import tp.pr2.logica.MovimientoGravity;
import tp.pr2.logica.Partida;

/**
 *
 * @author marcoantonio
 */
public class OrdenPoner extends Orden{

    @Override
    public void ejecuta(Partida partida, Scanner input, Controlador control) {
        System.out.print("Introduce la columna: ");//Vamos a fiarnos del usuario
        String comando=input.nextLine();//No podemos usar try catch
        comando=comando.trim();
        int col=Integer.parseInt(comando);
        Movimiento mov;
        Ficha color=partida.getTurno();
        Game game=partida.getGame();
        if(game==Game.C4)
        {
            mov=new MovimientoConecta4(col, color);
        }
        else if(game==Game.CO)
        {
            mov=new MovimientoComplica(col, color);
        }
        else
        {
            System.out.print("Introduce la fila: ");//Vamos a fiarnos del usuario
            comando=input.nextLine();//No podemos usar try catch
            comando=comando.trim();
            int fila=Integer.parseInt(comando);
            mov=new MovimientoGravity(col, fila, color, partida.getTablero());
        }
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
