/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pr2.control;

import java.util.Scanner;
import tp.pr2.logica.Ficha;
import tp.pr2.logica.Partida;

/**
 *
 * @author marcoantonio
 */
public class OrdenJugador extends Orden {
    @Override
    public void ejecuta(Partida partida, Scanner input, Controlador control) {
        String[] par=ord.split("\\s+");
        if(par.length==3)
        {
            Ficha color;
            switch(par[1])
            {
                case "blancas":color=Ficha.BLANCA;break;
                case "negras":color=Ficha.NEGRA;break;
                default: System.err.println("No te entiendo."); return;
            }
            switch(par[2])
            {
                case "humano":control.setJugador(color, control.getFactoria().creaJugadorHumanoConsola(input));break;
                case "aleatorio":control.setJugador(color, control.getFactoria().creaJugadorAleatorio());break;
                default: System.err.println("No te entiendo.");             
            }
        }
        else System.err.println("No te entiendo.");
    }
    
    @Override
    public Orden parsea(String ord) {
        if(ord.startsWith("jugador")) //Esto hay que pulirlo
        {
            this.ord=ord.replace("jugar gr", "");
            return this;
        }
        else return null;    
    }
    String ord;
}
