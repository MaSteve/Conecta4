package tp.pr3.control;

import java.util.Scanner;
import tp.pr3.logica.Partida;

/**
 *
 * @author marcoantonio
 */
public class OrdenAyuda extends Orden{

    @Override
    public void ejecuta(Partida partida, Scanner input, Controlador control) {
        OrdenParser.Ayuda();
    }

    @Override
    public Orden parsea(String[] ord) {
        if(ord[0].equals("ayuda")) return this;
        else return null;
    }

    @Override
    public String getTextoAyuda() {
        return "AYUDA: muestra esta ayuda.";
    }
    
}
