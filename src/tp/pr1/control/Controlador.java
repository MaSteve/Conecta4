/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.pr1.control;

import java.util.Scanner;
import tp.pr1.logica.*;

/**
 *
 * @author marcoantonio
 */
public class Controlador {
    
    public Controlador(Partida p, Scanner in)
    {
        partida=p;
        input=in;
    }
    public void run()
    {
        boolean stop=false;
        System.out.print(partida.getTablero().toString()+"\n");
        while(!stop && !partida.isTerminada())
        {
            System.out.print("Juegan ");
            Ficha color=partida.getTurno();
            switch(color)
            {
                case BLANCA:System.out.print("blancas"+"\n");break;
                case NEGRA:System.out.print("negras"+"\n");
            }
            System.out.print("Qué quieres hacer? ");
            String comando=input.nextLine();
            switch(comando)
            {
                case "poner":
                {
                    System.out.print("Introduce la columna: ");
                    int col=input.nextInt();
                    if(!partida.ejecutaMovimiento(color, col))
                    {
                        System.out.println("Movimiento incorrecto");
                    }
                }break;
                case "deshacer":
                {
                    if(!partida.undo())System.out.println("Imposible deshacer");
                }break;
                case "reiniciar":
                {
                    partida.reset();
                    System.out.println("Partida reiniciada");
                }break;
                case "salir":
                {
                    stop=true;
                }
            } 
            if(!stop) System.out.print(partida.getTablero().toString()+"\n");
        }
        
    }
    private Partida partida;
    private Scanner input;
}
