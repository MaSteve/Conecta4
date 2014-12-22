package tp.pr2.control;

import tp.pr2.logica.Ficha;
import tp.pr2.logica.Partida;
import java.util.Scanner;

/**
 *
 * @author marcoantonio
 */
public class Controlador {
    /*
     *Clase controlador. Maneja la partida.
     */
    public Controlador(Partida p, Scanner in)
    {
        partida=p;
        input=in;
        parser=new OrdenParser();
    }
    public void exitRequest()
    {
        stop=true;
    }
    public void run()
    {
        Ficha color;
        stop=false;
        System.out.print(partida.getTablero().toString()+"\n");
        while(!stop && !partida.isTerminada())
        {
            System.out.print("Juegan ");
            color=partida.getTurno();
            switch(color)
            {
                case BLANCA:System.out.print("blancas"+"\n");break;
                case NEGRA:System.out.print("negras"+"\n");
            }
            System.out.print("Qué quieres hacer? ");
            String comando=input.nextLine();
            //comando=comando.replace(" ", ""); o trim
            comando=comando.toLowerCase();
            Orden ord=parser.Parser(comando);
            if(ord==null)System.err.println("No te entiendo.");
            else ord.ejecuta(partida, input, this);
            if(!stop) System.out.print(partida.getTablero().toString()+"\n");
        }
        if(!stop)
        {   //Partida terminada sin salirse
            color=partida.getGanador();
            switch(color)
            {
                case BLANCA:System.out.println("Ganan las blancas");break;
                case NEGRA:System.out.println("Ganan las negras");break;
                default:System.out.println("Partida terminada en tablas.");
            }
        }
        
    }
    
    private boolean stop;
    private Partida partida;
    private Scanner input;
    private OrdenParser parser;
}
