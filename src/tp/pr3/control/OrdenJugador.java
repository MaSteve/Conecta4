package tp.pr3.control;

import java.util.Scanner;
import tp.pr3.logica.Ficha;
import tp.pr3.logica.Partida;

/**
 *
 * @author marcoantonio
 */
public class OrdenJugador extends Orden {
    @Override
    public void ejecuta(Partida partida, Scanner input, Controlador control) {
        if(ord.length==3)
        {
            Ficha color;
            switch(ord[1])
            {
                case "blancas":color=Ficha.BLANCA;break;
                case "negras":color=Ficha.NEGRA;break;
                default: System.err.println("No te entiendo."); return;
            }
            switch(ord[2])
            {
                case "humano":control.setJugador(color, control.getFactoria().creaJugadorHumanoConsola(input));break;
                case "aleatorio":control.setJugador(color, control.getFactoria().creaJugadorAleatorio());break;
                default: System.err.println("No te entiendo.");             
            }
        }
        else System.err.println("No te entiendo.");
    }
    
    @Override
    public Orden parsea(String[] ord) {
        if(ord[0].equals("jugador")) //Esto hay que pulirlo
        {
            OrdenJugador ret=new OrdenJugador();
            ret.ord=ord;
            return ret;
        }
        else return null;    
    }
    private String[] ord;

    @Override
    public String getTextoAyuda() {
       return "JUGADOR [blancas|negras] [humano|aleatorio]: cambia el tipo de jugador."; 
    }
}
