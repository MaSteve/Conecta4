package tp.pr3.control;

import java.util.Scanner;

/**
 *
 * @author marcoantonio
 */
public class OrdenSalir extends Orden {

    @Override
    public void ejecuta(Scanner input, Controlador control) {
        control.exitRequest();
    }

    @Override
    public Orden parsea(String[] ord) {
        if(ord[0].equals("salir")) return this;
        else return null;
    }

    @Override
    public String getTextoAyuda() {
        return "SALIR: termina la aplicación.";
    }
    
}
