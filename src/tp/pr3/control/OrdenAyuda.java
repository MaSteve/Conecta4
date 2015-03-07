package tp.pr3.control;

import java.util.Scanner;

/**
 *
 * @author marcoantonio
 */
public class OrdenAyuda extends Orden{

    @Override
    public void ejecuta(Scanner input, Controlador control) {
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
