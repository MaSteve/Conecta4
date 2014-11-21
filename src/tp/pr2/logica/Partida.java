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
    public Partida()
    {
        reset();
    }
    public boolean ejecutaMovimiento(Ficha color, int col)
    {   //Intenta ejecutar un movimiento y comunica al controlador si hay éxito
        if(col<=0||col>ANCHO)return false;
        if(!(tablero.getCasilla(col, 1).equals(Ficha.VACIA))||
                !color.equals(turno)||terminada)
        {
            return false;
        }
        else
        {
            int i=2;
            boolean stop=false;
            while(i<=ALTO && !stop)
            {
                if(tablero.getCasilla(col, i).equals(Ficha.VACIA))
                i++;
                else
                {
                    stop=true;
                }
            }
            lastx=col;
            lasty=i-1;
            tablero.setCasilla(col, i-1, color);//Tras localizar la posición coloca la ficha
            stack.push(col);//Almacena el movimiento
            turno=turno.contrario();//Cambia el turno
            isEnded(); //Actualiza la bandera de fin de partida
            return true;
        }
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
    public boolean cuatroEnRaya(Ficha color, int posx, int posy, int incrx, int incry)
    {//En esta versión se usa este método
        int x=posx+incrx;
        int y=posy+incry;
        int cont=1;
        boolean stop=false;
        while(!stop && x<=ANCHO && y<=ALTO && x>=1 && y>=1)
        {
            if(tablero.getCasilla(x, y).equals(color))
            {
                x=x+incrx;
                y=y+incry;
                cont++;
                if(cont==4)
                {
                    terminada=true;
                    ganador=turno.contrario();
                    return true;
                }
            }
            else stop=true;
        }
        x=posx-incrx;
        y=posy-incry;
        stop=false;
        while(!stop && x<=ANCHO && y<=ALTO && x>=1 && y>=1)
        {
            if(tablero.getCasilla(x, y).equals(color))
            {
                x=x-incrx;
                y=y-incry;
                cont++;
                if(cont==4)
                {
                    terminada=true;
                    ganador=turno.contrario();
                    return true;
                }
            }
            else stop=true;
        }
        return false;
    }
    public boolean isTerminada()
    {
        return terminada;
    }
    public void isEnded()
    {//Determina si la partida ha terminado. Se ejecuta en el controlador.
        if(!(lastx<1||lastx>ANCHO||lasty<1||lasty>ALTO)){
        Ficha color=tablero.getCasilla(lastx, lasty);
        ////EJE X
        if(!cuatroEnRaya(color, lastx, lasty, 1, 0)){
        ////EJE Y
        if(!cuatroEnRaya(color, lastx, lasty, 0, 1)){
        ////DIAGONAL 1
        if(!cuatroEnRaya(color, lastx, lasty, 1, 1)){
        ////DIAGONAL 2
        if(!cuatroEnRaya(color, lastx, lasty, 1, -1)){
        ////Tablas
        boolean end=true;
        int i=1; 
        while(end && i<=ANCHO)
        {
            end=!tablero.getCasilla(i, 1).equals(Ficha.VACIA);
            i++;
        }
        terminada=end;
        }}}}}
    }
    public void reset()//Es en sí el constructor de la Partida
    {
        lastx=0;
        lasty=0;
        tablero=new Tablero(ANCHO, ALTO);
        stack=new CircularUnsignedIntStack();
        turno=Ficha.BLANCA;
        terminada=false;
        ganador=Ficha.VACIA;
    }
    public boolean undo()
    {//Función deshacer. Llama a la pila para obtener la última columna usada
        int col=stack.pop();
        if(col<1||col>ANCHO) return false;
        else
        {
            int i=1;
            boolean stop=false;
            while(i<=ALTO && !stop)
            {
                if(tablero.getCasilla(col, i).equals(Ficha.VACIA))
                i++;
                else
                {
                    stop=true;
                }
            }
            if(stop){
            tablero.setCasilla(col, i, Ficha.VACIA); //Se pone vacio
            turno=turno.contrario();//Cambia el turno
            lastx=0;
            lasty=0; //Se ponen a cero para evitar problemas
            return true;}
            else return false;//Otra ñapa de mierda
        }
    }
    
    private int lastx;//Permiten agilizar la función isTerminada()
    private int lasty;//Es la posición del último movimiento
    
    private CircularUnsignedIntStack stack;
    private Tablero tablero; 
    private Ficha turno; 
    private boolean terminada; 
    private Ficha ganador;
    private static final int ANCHO=7;
    private static final int ALTO=6;
}
