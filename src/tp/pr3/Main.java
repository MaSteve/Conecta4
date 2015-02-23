package tp.pr3;
import tp.pr3.control.Controlador;
import tp.pr3.logica.Partida;
import java.util.Scanner;
import tp.pr3.control.FactoriaConecta4;
import tp.pr3.control.FactoriaTipoJuego;

import org.apache.commons.cli.*;

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
        CommandLineParser parser;  
        CommandLine cmdLine;
        
        Options options = new Options();  
        options.addOption("g", "game", true, "Elige juego"); 
        options.addOption("x", "tamx", true, "Modifica el tamaño x");
        options.addOption("y", "tamy", true, "Modifica el tamaño y");
        options.addOption("h", "help", false, "Imprime el mensaje de ayuda");
        
        
        
        FactoriaTipoJuego f= new FactoriaConecta4();
        Partida game=new Partida(f.creaReglas());
        Scanner input=new Scanner(System.in);
        Controlador control=new Controlador(f, game, input);
        control.run();
        input.close();
    }
}