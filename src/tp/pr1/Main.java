package tp.pr1;
import java.util.Scanner;
import tp.pr1.control.*;
import tp.pr1.logica.*;
/**
 *
 * @author marcoantonio
 */
public class Main {
    /*
     * Clase principal. Crea una partida y un controlador y ejecuta una partida
     */
    public static void main(String [] arg)
    {   
        Partida game=new Partida();
        Scanner input=new Scanner(System.in);
        Controlador control=new Controlador(game, input);
        control.run();
        input.close();
    }
}
