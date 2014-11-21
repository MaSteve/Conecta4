package tp.pr2;
import tp.pr2.control.Controlador;
import tp.pr2.logica.Partida;
import java.util.Scanner;
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
