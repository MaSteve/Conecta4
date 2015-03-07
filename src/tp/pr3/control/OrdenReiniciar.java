package tp.pr3.control;

import java.util.Scanner;

/**
 *
 * @author marcoantonio
 */
public class OrdenReiniciar extends Orden{

    @Override
    public void ejecuta(Scanner input, Controlador control) {
        control.getPartida().reset();
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
