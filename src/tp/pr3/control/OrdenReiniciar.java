package tp.pr3.control;

import java.util.Scanner;
import tp.pr3.logica.Partida;

/**
 *
 * @author marcoantonio
 */
public class OrdenReiniciar extends Orden{

    @Override
    public void ejecuta(Partida partida, Scanner input, Controlador control) {
        partida.reset();
        System.out.println("Partida reiniciada.");
    }

    @Override
    public Orden parsea(String[] ord) {
        if(ord[0].equals("reiniciar")) return this;
        else return null;
    }

    @Override
    public String getTextoAyuda() {
        return "REINICIAR: reinicia la partida.";
    }
    
}
