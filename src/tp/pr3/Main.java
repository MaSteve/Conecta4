package tp.pr3;
import tp.pr3.control.Controlador;
import tp.pr3.logica.Partida;

import java.util.Scanner;

import tp.pr3.control.FactoriaComplica;
import tp.pr3.control.FactoriaConecta4;
import tp.pr3.control.FactoriaGravity;
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
    	CommandLineParser parser = new BasicParser();//new PosixParser()
        Options options = new Options();
        Option game, tamx, tamy, help;
        
        game = new Option("g", "game", true, "Tipo de juego (c4, co, gr). Por defecto, c4."); 
        tamx = new Option("x", "tamX", true, "Número de columnas del tablero (sólo para Gravity). Por defecto, 10.");
        tamy = new Option("y", "tamY", true, "Número de filas del tablero (sólo para Gravity). Por defecto, 10.");
        help = new Option("h", "help", false, "Muestra esta ayuda.");
        
        game.setArgName("game");
        tamx.setArgName("columnNumber");
        tamy.setArgName("rowNumber");
        
        options.addOption(game);
        options.addOption(tamx);
        options.addOption(tamy);
        options.addOption(help);
        
        int settamx = 10, settamy = 10; // Valores por defecto
        
        FactoriaTipoJuego f= new FactoriaConecta4(); // Valor por defecto
        
        try  {
            CommandLine cmd = parser.parse(options, arg);
            if ( cmd.hasOption(help.getOpt()) ) {
                new HelpFormatter().printHelp(Main.class.getCanonicalName(), options, true);       	
            } else {
            	if (cmd.hasOption(game.getOpt())) {
                    if (cmd.getOptionValue(game.getOpt()).equalsIgnoreCase("c4")) {
            		f = new FactoriaConecta4();
                    } else if (cmd.getOptionValue(game.getOpt()).equalsIgnoreCase("co")) {
            		f = new FactoriaComplica();
                    } else if (cmd.getOptionValue(game.getOpt()).equalsIgnoreCase("gr")) {
            			
                    	if (cmd.hasOption(tamx.getOpt()) && cmd.hasOption(tamy.getOpt())) {
                    		settamx = Integer.parseInt(cmd.getOptionValue(tamx.getOpt()));
                    		settamy = Integer.parseInt(cmd.getOptionValue(tamy.getOpt()));
                    	}
            			f = new FactoriaGravity(settamx, settamy);          			
                    } else {
                        System.err.println(errorMessage("Juego '" + cmd.getOptionValue(game.getOpt()) + "' incorrecto."));
                        System.exit(1);
                    }
            	}
            	
            	if (cmd.getArgs().length != 0) {
            		String argus = "";
            		for (int i = 0; i < cmd.getArgs().length -1; i++)
            			argus += cmd.getArgs()[i] + " ";
            		argus += cmd.getArgs()[cmd.getArgs().length - 1];
                        System.err.println(errorMessage("Argumentos no entendidos: "+argus));
            		System.exit(1);
            	}
                //Si todo va bien se ejecuta el juego
                Partida partida=new Partida(f.creaReglas());
                Scanner input=new Scanner(System.in);
                Controlador control=new Controlador(f, partida, input);
                control.run();
                input.close();	
            }
        } catch (ParseException pa) {
            System.err.println(errorMessage(pa.getMessage()));
            System.exit(1);
        } catch (NumberFormatException ex) {
            System.err.println(errorMessage("Argumento numérico no válido"));
            System.exit(1);
        }
    }
    
    private static String errorMessage(String err)
    {
        return "Uso incorrecto: "+err+"\nUse -h|--help para más detalles.";
    }
}