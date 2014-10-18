/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.pr1.control;

import java.util.Scanner;

import tp.pr1.logica.Ficha;
import tp.pr1.logica.Partida;

/**
 *
 * @author ivan
 */
public class Controlador {
    public Controlador(Partida p, java.util.Scanner in) {
    	this.p = p;
    	this.in = in;
    }
    
    public void run() {
    	while(!p.isTerminada()) {
    		System.out.println(p.getTablero());
    		System.out.println("Juegan "+ (p.getTurno()==Ficha.BLANCA?"blancas":"negras"));
    		System.out.print("Qué quieres hacer? ");
    		String command = in.next();
    		if (command.equals("poner")) {
    			System.out.print("Introduce la columna: ");
    			int col = Integer.parseInt(in.next()); // Y si peta pues nah
    			if(!p.ejecutaMovimiento(p.getTurno(), col))
    				System.out.println("Movimiento incorrecto");
    		} else if (command.equals("deshacer")) {
    			if (!p.undo()) 
    				System.out.println("Imposible deshacer.");
    		} else if (command.equals("reiniciar")) {
    			p.reset();
    			System.out.println("Partida reiniciada.");
    		} else if (command.equals("salir")) {
    			break; // FUCK U, ANA
    		} else System.out.println("No te entiendo, moreno.");
		}
		if (p.isTerminada()) {
			System.out.print(p.getTablero());
			System.out.println("Ganan las "
					+ (p.getTurno() == Ficha.BLANCA ? "blancas" : "negras"));
		}
	}

    private Partida p;
    private Scanner in;
}
