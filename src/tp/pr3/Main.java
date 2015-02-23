package tp.pr3;
import tp.pr3.control.Controlador;
import tp.pr3.logica.Partida;

import java.io.PrintWriter;
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
    	CommandLineParser parser = new BasicParser();
        Options options = new Options();
        Option name, tamx, tamy, help;
        
        name = new Option("g", "game", true, "Tipo de juego (c4, co, gr). Por defecto, c4."); 
        tamx = new Option("x", "tamX", true, "Número de columnas del tablero (sólo para Gravity). Por defecto, 10.");
        tamy = new Option("y", "tamY", true, "Número de filas del tablero (sólo para Gravity). Por defecto, 10.");
        help = new Option("h", "help", false, "Muestra esta ayuda.");
        
        name.setArgName("game");
        tamx.setArgName("columnNumber");
        tamy.setArgName("rowNumber");
        
        options.addOption(name);
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
            	if (cmd.hasOption(name.getOpt())) {
            		if (cmd.getOptionValue(name.getOpt()).equalsIgnoreCase("c4")) {
            			f = new FactoriaConecta4();
            		} else if (cmd.getOptionValue(name.getOpt()).equalsIgnoreCase("co")) {
            			f = new FactoriaComplica();
            		} else if (cmd.getOptionValue(name.getOpt()).equalsIgnoreCase("gr")) {
            			
                    	if (cmd.hasOption(tamx.getOpt())) {
                    		settamx = Integer.parseInt(cmd.getOptionValue(tamx.getOpt()));
                    	}
                    	
                    	if (cmd.hasOption(tamy.getOpt())) {
                    		settamy = Integer.parseInt(cmd.getOptionValue(tamy.getOpt()));
                    	}
            			
            			f = new FactoriaGravity(settamx, settamy);          			
            		} else {
                    	System.err.println("Uso incorrecto: Juego '" + cmd.getOptionValue(name.getOpt()) + "' incorrecto.");
                    	System.err.println("Use -h|--help para más detalles.");
            		}
            	}
            	
            	if (cmd.getArgs().length != 0) {
            		String argus = "";
            		for (int i = 0; i < cmd.getArgs().length -1; i++)
            			argus += cmd.getArgs()[i] + " ";
            		argus += cmd.getArgs()[cmd.getArgs().length - 1];
            		System.err.println("Uso incorrecto: Argumentos no entendidos: " + argus);
            		System.err.println("Use -h|--help para más detalles.");
            		return;
            	}
            	
            	
                Partida partida=new Partida(f.creaReglas());
                Scanner input=new Scanner(System.in);
                Controlador control=new Controlador(f, partida, input);
                control.run();
                input.close();
            	
            	
            }
        } catch (ParseException pa) {
        	System.err.println("Uso incorrecto: " + pa.getMessage());
        	System.err.println("Use -h|--help para más detalles.");
        } catch (NumberFormatException ex) {
        	System.err.println("Uso incorrecto: Argumento numérico no válido");
        	System.err.println("Use -h|--help para más detalles.");
        }
    }
}