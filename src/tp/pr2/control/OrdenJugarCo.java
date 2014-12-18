/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr2.control;

import java.util.Scanner;
import tp.pr2.logica.Partida;
import tp.pr2.logica.ReglasComplica;

/**
 *
 * @author marcoantonio
 */
public class OrdenJugarCo extends Orden {

    @Override
    public void ejecuta(Partida partida, Scanner input) {
        partida.reset(new ReglasComplica());
        System.out.println("Partida reiniciada.");
    }

    @Override
    public Orden parsea(String ord) {
        if(ord.equals("jugar co")) return this;
        else return null;    
    }
    
}
