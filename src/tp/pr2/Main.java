package tp.pr2;
import tp.pr2.control.Controlador;
import tp.pr2.logica.Partida;
import java.util.Scanner;
import tp.pr2.control.FactoriaConecta4;
import tp.pr2.control.FactoriaTipoJuego;
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
        FactoriaTipoJuego f= new FactoriaConecta4();
        Partida game=new Partida(f.creaReglas());
        Scanner input=new Scanner(System.in);
        Controlador control=new Controlador(f, game, input);
        control.run();
        input.close();
    }
}