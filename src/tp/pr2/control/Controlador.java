package tp.pr2.control;

import tp.pr2.logica.Ficha;
import tp.pr2.logica.Partida;
import java.util.Scanner;
import tp.pr2.logica.Movimiento;
import tp.pr2.logica.MovimientoComplica;
import tp.pr2.logica.MovimientoConecta4;
import tp.pr2.logica.ReglasComplica;
import tp.pr2.logica.ReglasConecta4;

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
    }
    public void run()
    {
        Ficha color;
        boolean stop=false;
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
            switch(comando) //Opciones del jugador
            {
                case "poner":
                {
                    System.out.print("Introduce la columna: ");//Vamos a fiarnos del usuario
                    comando=input.nextLine();//No podemos usar try catch
                    int col=Integer.parseInt(comando);
                    Movimiento mov;
                    mov=c4? new MovimientoComplica(col, color):new MovimientoConecta4(col, color);
                    if(!partida.ejecutaMovimiento(mov))//Hay que cambiarlo!!!!!
                    {
                        System.err.println("Movimiento incorrecto");
                    }
                }break;
                case "deshacer":
                {
                    if(!partida.undo())System.err.println("Imposible deshacer.");
                }break;
                case "reiniciar":
                {
                    partida.reset();
                    System.out.println("Partida reiniciada.");
                }break;
                case "salir":
                {
                    stop=true;
                }break;
                case "jugar co":
                {
                    partida.reset(new ReglasComplica());
                    c4=false;
                }break;
                case "jugar c4":
                {
                    partida.reset(new ReglasConecta4());
                    c4=true;
                }break;
                default: System.err.println("No te entiendo.");
            } 
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
    private boolean c4=true; //Ñapa
    private Partida partida;
    private Scanner input;
}
