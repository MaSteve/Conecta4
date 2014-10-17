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
        Tablero board=new Tablero(8, 8);
        board.setCasilla(3, 0, Ficha.BLANCA);
        System.out.print(board.toString());
    }
}
