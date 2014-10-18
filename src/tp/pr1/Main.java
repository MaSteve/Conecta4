/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.pr1;
import tp.pr1.logica.*;
/**
 *
 * @author marcoantonio
 */
public class Main {
    public static void main(String [] arg)
    {
        Ficha color=Ficha.BLANCA;
        Partida game=new Partida();
        Tablero board=game.getTablero();
        while(game.ejecutaMovimiento(color, 2))
        {
            color=color.contrario();
        }
        System.out.print(board.toString());
    }
}
