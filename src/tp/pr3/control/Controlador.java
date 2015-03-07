package tp.pr3.control;

import java.util.HashMap;
import tp.pr3.logica.Ficha;
import tp.pr3.logica.Partida;
import java.util.Scanner;

/**
 *
 * @author marcoantonio
 */
public final class Controlador {
    /*
     *Clase controlador. Maneja la partida.
     */
    public Controlador(FactoriaTipoJuego f, Partida p, Scanner in)
    {
        partida=p;
        input=in;
        setFactoria(f);
    }
    public FactoriaTipoJuego getFactoria()
    {
        return factoria;
    }
    public void setFactoria(FactoriaTipoJuego factoria)
    {
        this.factoria=factoria;
        jugadores=new HashMap<>();
        jugadores.put(Ficha.BLANCA, factoria.creaJugadorHumanoConsola(input));
        jugadores.put(Ficha.NEGRA, factoria.creaJugadorHumanoConsola(input));
    }
    public void setJugador(Ficha color, Jugador jugador)
    {
        jugadores.put(color, jugador);
    }
    public Jugador getJugador()
    {
        return jugadores.get(partida.getTurno());
    }
    public Partida getPartida()
    {
        return partida;
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
            Orden ord=OrdenParser.parser(comando);
            if(ord==null)System.err.println("No te entiendo.");
            else ord.ejecuta(input, this);
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
    private FactoriaTipoJuego factoria;
    private HashMap<Ficha,Jugador> jugadores;
    private Partida partida;
    private Scanner input;
}
