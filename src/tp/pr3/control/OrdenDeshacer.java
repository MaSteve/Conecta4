package tp.pr3.control;

import java.util.Scanner;
import tp.pr3.logica.Partida;

/**
 *
 * @author marcoantonio
 */
public class OrdenDeshacer extends Orden{

    @Override
    public void ejecuta(Partida partida, Scanner input, Controlador control) {
        if(!partida.undo())System.err.println("Imposible deshacer.");
    }

    @Override
    public Orden parsea(String[] ord) {
        if(ord[0].equals("deshacer")) return this;
        else return null;
    }

    @Override
    public String getTextoAyuda() {
        return "DESHACER: deshace el último movimiento hecho en la partida.";
    }
    
}
