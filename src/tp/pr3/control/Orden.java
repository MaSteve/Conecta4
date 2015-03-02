package tp.pr3.control;

import java.util.Scanner;
import tp.pr3.logica.Partida;

/**
 *
 * @author marcoantonio
 */
public abstract class Orden {
    public abstract void ejecuta(Partida partida, Scanner input, Controlador control);
    public abstract Orden parsea(String[] ord);
    public abstract String getTextoAyuda();
}
