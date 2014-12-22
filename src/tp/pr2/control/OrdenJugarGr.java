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
public class OrdenJugarGr extends Orden{

    @Override
    public void ejecuta(Partida partida, Scanner input, Controlador control) {
        
        String[] par=ord.split("\\s+");
        if(par.length==3)
        {
            int tamx=0, tamy=0;
            try
            {
                tamx=Integer.parseInt(par[1]);
                tamy=Integer.parseInt(par[2]);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            control.setFactoria(new FactoriaGravity(tamx, tamy));
            partida.reset(control.getFactoria().creaReglas());
            System.out.println("Partida reiniciada.");
        }
        else if(par.length==1)
        {
            control.setFactoria(new FactoriaGravity());
            partida.reset(control.getFactoria().creaReglas());
            System.out.println("Partida reiniciada.");
        }
        else
        {
            System.err.println("No te entiendo.");
        }
    }

    @Override
    public Orden parsea(String ord) {
        if(ord.startsWith("jugar gr")) //Esto hay que pulirlo
        {
            this.ord=ord.replace("jugar gr", "");
            return this;
        }
        else return null;    
    }
    private String ord;
}
