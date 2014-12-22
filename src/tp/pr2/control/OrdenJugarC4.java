/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr2.control;

import java.util.Scanner;
import tp.pr2.logica.Partida;

/**
 *
 * @author marcoantonio
 */
public class OrdenJugarC4 extends Orden{

    @Override
    public void ejecuta(Partida partida, Scanner input, Controlador control) {
        control.setFactoria(new FactoriaConecta4());
        partida.reset(control.getFactoria().creaReglas());
        System.out.println("Partida reiniciada.");
    }

    @Override
    public Orden parsea(String ord) {
        if(ord.equals("jugar c4")) return this;
        else return null;    
    }
    
}
