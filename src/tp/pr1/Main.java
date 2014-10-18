/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.pr1;
import java.util.Scanner;

import tp.pr1.control.Controlador;
import tp.pr1.logica.*;
/**
 *
 * @author marcoantonio
 * @author ivan
 */
public class Main {
    public static void main(String [] arg)
    {
    	Partida p = new Partida();
        Controlador cont = new Controlador(p, new Scanner(System.in));
        cont.run();
    }
}
