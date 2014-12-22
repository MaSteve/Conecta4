package tp.pr2.logica;
import tp.pr2.logica.utilidades.CircularUnsignedIntStack;

/**
 *
 * @author marcoantonio
 */
public class Partida {
    /*
     * Clase Partida. Maneja un tablero de fichas y tiene las funcionalidades
     * básicas de la práctica
     */
    public Partida(ReglasJuego reglas)
    {
        reset(reglas);
    }
    public void ejecutaMovimiento(Movimiento mov) throws MovimientoInvalido
    {   //Intenta ejecutar un movimiento y comunica al controlador si hay éxito
        if(terminada||!mov.getJugador().equals(turno))
        {
            throw new MovimientoInvalido();
        }
        mov.ejecutaMovimiento(tablero);//Puede lanzar una excepción
        stack.push(mov);//Almacena el movimiento
        turno=reglas.siguienteTurno(turno, tablero);//Cambia el turno
        ganador=reglas.hayGanador(mov, tablero);
        if(!ganador.equals(Ficha.VACIA))terminada=true;
        else terminada=reglas.tablas(turno, tablero);
        //return ok;
    }
    public Ficha getGanador()
    {
        return ganador;
    }
    public Tablero getTablero()
    {
        return tablero;
    }
    public Ficha getTurno()
    {
        return turno;
    }
    
    public Game getGame()
    {
        return reglas.getGame();
    }
    
    public boolean isTerminada()
    {
        return terminada;
    }
    public final void reset()
    {
        lastx=0;
        lasty=0;
        tablero=reglas.iniciaTablero();
        stack=new CircularUnsignedIntStack();
        turno=reglas.jugadorInicial();
        terminada=false;
        ganador=Ficha.VACIA;
    }
    public final void reset(ReglasJuego reglas)//Es en sí el constructor de la Partida
    {
        this.reglas=reglas;
        reset();
    }
    public boolean undo()
    {//Función deshacer. Llama a la pila para obtener la última columna usada
        Movimiento col=stack.pop();
        if(col==null) return false;
        else
        {
            col.undo(tablero);
            turno=turno.contrario();//No me gusta!!!
            return true;
        }
    }
    
    private int lastx;//Permiten agilizar la función isTerminada()
    private int lasty;//Es la posición del último movimiento
    
    private ReglasJuego reglas;
    private CircularUnsignedIntStack stack;
    private Tablero tablero; 
    private Ficha turno; 
    private boolean terminada; 
    private Ficha ganador;
    private static final int ANCHO=7;
    private static final int ALTO=6;
}
