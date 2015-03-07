package tp.pr3.control;

import java.util.Scanner;

/**
 *
 * @author marcoantonio
 */
public abstract class Orden {
    public abstract void ejecuta(Scanner input, Controlador control);
    public abstract Orden parsea(String[] ord);
    public abstract String getTextoAyuda();
}
