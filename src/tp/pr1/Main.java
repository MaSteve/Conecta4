/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.pr1;
import java.util.Scanner;
import tp.pr1.control.*;
import tp.pr1.logica.*;
/**
 *
 * @author marcoantonio
 */
public class Main {
    public static void main(String [] arg)
    {
        /*Ficha color=Ficha.BLANCA;
        Partida game=new Partida();
        Tablero board=game.getTablero();
        System.out.print(board.toString());
        while(game.ejecutaMovimiento(color, 2))
        {
            color=color.contrario();
            System.out.print(board.toString());
        }*/
        Partida game=new Partida();
        Scanner input=new Scanner(System.in);
        Controlador control=new Controlador(game, input);
        control.run();
    }
}
